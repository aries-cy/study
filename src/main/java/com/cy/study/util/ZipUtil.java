package com.cy.study.util;

import net.sf.sevenzipjbinding.*;
import net.sf.sevenzipjbinding.impl.RandomAccessFileInStream;
import net.sf.sevenzipjbinding.simple.ISimpleInArchive;
import net.sf.sevenzipjbinding.simple.ISimpleInArchiveItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tk.mybatis.mapper.util.StringUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 压缩工具类
 *
 * @author cy
 */
public class ZipUtil {

    private static Logger logger = LoggerFactory.getLogger(ZipUtil.class);

    /**
     * 解压文件 zip/7z格式
     * @param zipFile 压缩包
     * @param passWord 密码
     * @return 解压出来的文件
     */
    public static List<File> unZip(File zipFile,String passWord){
        IInArchive archive;
        RandomAccessFile randomAccessFile;
        try{
            randomAccessFile = new RandomAccessFile(zipFile,"r");
            if(StringUtil.isNotEmpty(passWord)){
                archive = SevenZip.openInArchive(null,new RandomAccessFileInStream(randomAccessFile),passWord);
            }else {
                archive = SevenZip.openInArchive(null,new RandomAccessFileInStream(randomAccessFile));
            }
            ISimpleInArchive simpleInterface = archive.getSimpleInterface();
            List<File> files = new ArrayList<>();
            for(final ISimpleInArchiveItem item:simpleInterface.getArchiveItems()){
                if(!item.isFolder()){
                    ExtractOperationResult result;
                    result = item.extractSlow(new ISequentialOutStream() {
                        @Override
                        public int write(byte[] bytes) throws SevenZipException {
                            //byte[]写成文件
                            String fileName = item.getPath();
                            try {
                                File tempFile = File.createTempFile(fileName.substring(0, fileName.lastIndexOf(".")), fileName.substring(fileName.lastIndexOf(".")));
                                InputStream inputStream = new FileInputStream(tempFile);
                                inputStream.read(bytes);
                                files.add(tempFile);
                            } catch (Exception e) {
                               logger.error("解析文件出错！",e);
                            }
                            return 0;
                        }
                    },passWord);
                    if(result == ExtractOperationResult.OK){
                        logger.debug("解压文件成功！");
                    }else {
                        logger.debug("解压文件失败！");
                    }
                }
            }
            return files;
        }catch (Exception e){
            logger.error("解析文件出错！",e);
            return null;
        }
    }

    /**
     * 压缩文件
     * @param files 需要压缩的文件
     * @param zipName 压缩的文件名
     * @return 压缩好的文件
     */
    public static File zip(List<File> files,String zipName){
        byte[] buf = new byte[1024];
        int fileCount = 0;
        try{
            File zipFile = File.createTempFile(zipName, ".zip");
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile));
            for(File file:files){
                FileInputStream fileInputStream = new FileInputStream(file);
                zos.putNextEntry(new ZipEntry(file.getName()));
                int len;
                while ((len = fileInputStream.read())>0){
                    zos.write(buf,0,len);
                }
                zos.closeEntry();
                fileInputStream.close();
                fileCount++;
            }
            logger.debug("压缩文件成功，压缩了"+fileCount+"个文件");
            return zipFile;
        }catch (Exception e){
            logger.error("压缩文件失败！",e);
            return null;
        }
    }

    /**
     * 删除临时文件
     * @param files 需要删除的文件
     */
    public static void deleteTempFile(File...files){
        for(File file:files){
            if(file.exists()){
                boolean delete = file.delete();
                if(delete){
                    logger.debug("删除文件成功！");
                }
            }
        }
    }

}
