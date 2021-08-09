package io.wkh.test;

import org.junit.Test;

import java.io.*;

/**
 * @author wkh
 * @create 2021-07-27 19:25
 */
public class BufferedTest {
    /**
     * 缓冲流（处理流）的使用
     *
     *
     *
     */
    @Test
    public void BufferedStreamTest() throws IOException {
        // 实现非文本文件
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            // 1. 造文件
            File srcFile = new File("微信收款码.png");
            File destFile = new File("微信收款码1.png");

            // 2.造流
            // 2.1 造节点流/文件流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            // 2.2 造处理流/ 缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            // 3.复制的细节：读取、写入
            byte[] buf = new byte[10];
            int len;
            while ((len = bis.read(buf))!=-1){
                bos.write(buf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //4.资源关闭
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 说明：关闭外层流的同时，内层 流也会自动关闭，也就是内层流的关闭，可以省略
//            fos.close();
//            fis.close();
        }

    }

    // 实现文件复制的方法
    public void copyFileWithBuffered(String srcPath,String destPath){
        // 实现非文本文件
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            // 1. 造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            // 2.造流
            // 2.1 造节点流/文件流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            // 2.2 造处理流/ 缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            // 3.复制的细节：读取、写入
            byte[] buf = new byte[10];
            int len;
            while ((len = bis.read(buf))!=-1){
                bos.write(buf,0,len);
                // 刷新缓冲区
//                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //4.资源关闭
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // 说明：关闭外层流的同时，内层 流也会自动关闭，也就是内层流的关闭，可以省略
//            fos.close();
//            fis.close();
        }
    }

    @Test
    public void testCopyFileWithBuffered(){

    }


}
