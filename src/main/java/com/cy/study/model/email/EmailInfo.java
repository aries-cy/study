package com.cy.study.model.email;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 邮件信息
 *
 * @author cy
 */
@Data
public class EmailInfo {

    /**
     * 收件地址
     */
    private List<String> receiveAddresses;
    /**
     * 抄送地址
     */
    private List<String> ccAddresses;

    /**
     * 邮件标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 附件:k-文件名；v-oss地址
     */
    private Map<String,String> files;

}
