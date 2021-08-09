package io.wkh.test;

import org.junit.Test;

import java.io.*;
import java.util.WeakHashMap;

/**
 * @author wkh
 * @create 2021-07-26 19:27
 */
public class ReaderWriterTest {

    @Test
    public void testFileWriter() throws IOException {
        // 1.提供File类的对象，指明写出的文件
        File file = new File("hello1.txt");

        // 2.提供FileWriter的对象，用于数据的写出
        FileWriter fw = new FileWriter(file,true);

        // 3. 写出的操作
        fw.write("dog is dog\n");
        fw.write("cat is cat");


        // 4.流资源的关闭
        fw.close();
    }

    @Test
    public void testFileReader()  {
        FileReader fr = null;

        try {
            // 1. 有一个文件
            File file = new File("hello.txt");

            // 2. 造一个读入对象对硬盘文件进行操作
            fr = new FileReader(file);

            // 3.对硬盘文件进行操作
            // 方式一：逐个字符的读

//        int rc ;
//
//        while ((rc = fr.read())!=-1){
//            System.out.print((char)rc);
//            //rc = fr.read();
//        }

            // 方式二：
            char[] chars = new char[5];
            int rc = fr.read(chars);

            while (rc != -1){

                // String str = new String((char)rc,rc);
                //System.out.println((char) rc);


                String str = new String();

    //            for (int i = 0;i < rc; i++){
    //                System.out.print(chars[i]);
    //            }
                rc = fr.read(chars);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    // 4.流资源的关闭
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testFileReaderFileWriter() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            // 1.创建File类的对象，指明读入和写出的文件
//            File srcFile = new File("hello.txt");
//            File destFile = new File("hello2.txt");
            // 不能使用字符流处理字节等数据
            File srcFile = new File("微信收款码.png");
            File destFile = new File("微信收款码1.png");

            // 2.创建输入流和输出流的对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            // 3. 数据的读入和写出操作
            char[] cbuf = new char[5];
            int len; //记录每次读入到cbuf数组中的字符的个数
            while ((len = fr.read(cbuf)) != -1){
                // 每次写出len个字符
                fw.write(cbuf,0,len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭流资源
            if (fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void testFileInputStreamFileOutPutStream() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            // 1.创建文件对象
            File srcFile = new File("微信收款码.png");
            File destFile = new File("微信收款码1.jpg");

            // 2.创建输入流和输出流的对象
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            // 3.数据的输入、输出操作
            byte[] bbuf = new byte[100];

            //   int read = fis.read(bbuf);
            int len;
            while ((len = fis.read(bbuf)) != -1){
                // 把bbuf中的内容写出去
                fos.write(bbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.流资源的关闭
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null)
                     fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 指定路径下文件的复制
    public void copyFile(String srcPath,String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            // 1.创建文件对象
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            // 2.创建输入流和输出流的对象
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            // 3.数据的输入、输出操作
            byte[] bbuf = new byte[1024];

            //   int read = fis.read(bbuf);
            int len;
            while ((len = fis.read(bbuf)) != -1){
                // 把bbuf中的内容写出去
                fos.write(bbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.流资源的关闭
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();
        String srcPath = "制作链接.docx";
        String destPath = "制作链接1.docx";

        copyFile(srcPath,destPath);

        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间为"+(end-start));
    }


}
