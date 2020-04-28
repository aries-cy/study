package com.cy.study.util;

import net.lingala.zip4j.io.outputstream.ZipOutputStream;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;
import tk.mybatis.mapper.util.StringUtil;

import java.io.*;
import java.util.List;

/**
 * zip4j压缩/解压文件
 * zip4j-github: https://github.com/srikanth-lingala/zip4j
 *
 * @author cy
 */
public class Zip4jUtil {


    /**
     * 加密压缩文件
     * @param filesToAdd 要压缩的文件
     * @param password 压缩密码
     * @param fileName 压缩包的名称
     * @return 压缩后的文件
     * @throws IOException 异常
     */
    public File encryptCompressFiles( List<File> filesToAdd, String password,String fileName)
            throws IOException {
        File outputZipFile = File.createTempFile(fileName,".zip");
        ZipParameters zipParameters = buildZipParameters(password);
        byte[] buff = new byte[4096];
        int readLen;

        try{
            ZipOutputStream zos = initializeZipOutputStream(outputZipFile, password);
            for (File fileToAdd : filesToAdd) {

                zipParameters.setFileNameInZip(fileToAdd.getName());
                zos.putNextEntry(zipParameters);

                InputStream inputStream = new FileInputStream(fileToAdd);
                while ((readLen = inputStream.read(buff)) != -1) {
                    zos.write(buff, 0, readLen);
                }
                zos.closeEntry();
            }
            return outputZipFile;
        }catch (Exception e){
            System.out.println("...");
        }
        return null;
    }

    private ZipParameters buildZipParameters(String password) {
        ZipParameters zipParameters = new ZipParameters();
        zipParameters.setCompressionMethod(CompressionMethod.DEFLATE);
        zipParameters.setAesKeyStrength(AesKeyStrength.KEY_STRENGTH_256);
        if(StringUtil.isNotEmpty(password)){
            zipParameters.setEncryptFiles(true);
            zipParameters.setEncryptionMethod(EncryptionMethod.ZIP_STANDARD);
        }
        return zipParameters;
    }

    private ZipOutputStream initializeZipOutputStream(File outputZipFile, String password)
            throws IOException {

        FileOutputStream fos = new FileOutputStream(outputZipFile);

        if (StringUtil.isNotEmpty(password)) {
            return new ZipOutputStream(fos, password.toCharArray());
        }

        return new ZipOutputStream(fos);
    }

}
