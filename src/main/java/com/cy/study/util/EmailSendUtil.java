package com.cy.study.util;

import com.cy.study.model.email.EmailAuthCreator;
import com.cy.study.model.email.EmailConfigInfo;
import com.cy.study.model.email.EmailInfo;
import org.springframework.util.CollectionUtils;

import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * 邮件发送工具类
 *
 * @author cy
 */
public class EmailSendUtil {



    public static void sendHtmlEmail(EmailInfo emailInfo){
        try{
            EmailConfigInfo emailConfigInfo = SpringUtil.getBean(EmailConfigInfo.class);
            //密码验证器
            EmailAuthCreator emailAuthCreator = new EmailAuthCreator(emailConfigInfo);
            //邮件session
            Session session = Session.getInstance(emailConfigInfo.getProperties(), emailAuthCreator);
            //邮件message
            Message message = new MimeMessage(session);
            //发送地址
            Address from = new InternetAddress(emailConfigInfo.getUsername());
            message.setFrom(from);

            Address[][] addresses = getAddressArray(emailInfo.getReceiveAddresses(), emailInfo.getCcAddresses());
            //接收地址
            if(addresses[0]!=null&&addresses[0].length>0){
                message.setRecipients(Message.RecipientType.TO,addresses[0]);
            }
            //抄送地址
            if(addresses[1]!=null&&addresses[1].length>0){
                message.setRecipients(Message.RecipientType.CC,addresses[1]);
            }
            //邮件主题
            message.setSubject(emailInfo.getTitle());
            //邮件发送时间
            message.setSentDate(new Date());

            Multipart multipart = new MimeMultipart();
            BodyPart bodyPart = new MimeBodyPart();
            bodyPart.setContent(emailInfo.getContent(),"text/html; charset=utf-8");
            multipart.addBodyPart(bodyPart);
            //添加附件
            if(!CollectionUtils.isEmpty(emailInfo.getFiles())){
                emailInfo.getFiles().forEach((k,v)->{
                    BodyPart part = new MimeBodyPart();
                    //TODO 设置文件的输入流
                    InputStream inputStream = null;
                    try {
                        ByteArrayDataSource dataSource = new ByteArrayDataSource(inputStream, "application/octet-stream");
                        part.setDataHandler(new DataHandler(dataSource));
                        part.setFileName(k);
                        multipart.addBodyPart(part);
                    } catch (IOException | MessagingException e) {
                        e.printStackTrace();
                    }
                });
            }
            //邮件内容
            message.setContent(multipart);
            Transport.send(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static Address[][] getAddressArray(List<String> receiveAddresses,List<String> ccAddresses) throws AddressException {
        Address[] toAddress = null;
        Address[] ccAddress = null;
        if(!CollectionUtils.isEmpty(receiveAddresses)){
            toAddress = new InternetAddress[receiveAddresses.size()];
            for (int i=0;i<receiveAddresses.size();i++) {
                toAddress[i] = new InternetAddress(receiveAddresses.get(i));
            }
        }
        if(!CollectionUtils.isEmpty(ccAddresses)){
            ccAddress = new InternetAddress[ccAddresses.size()];
            for (int i=0;i<ccAddresses.size();i++){
                ccAddress[i] = new InternetAddress(ccAddresses.get(i));
            }
        }
        return new Address[][]{toAddress,ccAddress};
    }
}
