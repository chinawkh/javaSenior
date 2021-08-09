package io.wkh.test;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author wkh
 * @create 2021-08-03 19:36
 */
public class RandomAccessFileTest {

    /*
    1.直接继承Object类，实现了DataInput,DataOutput接口
    2.既是输入流，也是输出流; 是一个字节流
    3.如果作为输出流；如果不存在，则自动创建；如果存在，则对原有文件内容覆盖（从头覆盖）
    4.
     */

    @Test
    public void test1() {
        RandomAccessFile raf2 = null;
        RandomAccessFile raf1 = null;
        try {
            // 1.
            raf1 = new RandomAccessFile(new File("微信收款码.png"), "r");
            raf2 = new RandomAccessFile(new File("微信收款码1.png"), "rw");

            // 2.
            byte[] buffer = new byte[1024];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                raf2.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 3.
            if (raf2 != null) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Test
    public void test2() {
        RandomAccessFile raf1 = null;
        try {
            raf1 = new RandomAccessFile("hello.txt", "rw");
//        RandomAccessFile raf2 = new RandomAccessFile("","");
            raf1.seek(4);  // 这个数字代表的是字节
            raf1.write("xyz".getBytes());
            raf1.write("11111".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                raf1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test3() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt", "rw");
        raf1.seek(3);

        StringBuilder builder = new StringBuilder((int) new File("hello.txt").length());

        byte[] buffer = new byte[20];

        int len;
        while ((len = raf1.read(buffer)) != -1) {
            builder.append(new String(buffer, 0, len));
        }

        raf1.seek(3);
        raf1.write("xyz".getBytes());
        raf1.write(builder.toString().getBytes());

        raf1.close();
    }

    public static void main(String[] args) {
        RandomAccessFile raf1 = null;
        try {
            raf1 = new RandomAccessFile("IOTest/hello.txt", "rw");
            raf1.seek(3);

            StringBuilder builder = new StringBuilder((int) new File("IOTest/hello.txt").length());

            byte[] buffer = new byte[20];

            int len;
            while ((len = raf1.read(buffer)) != -1) {
                builder.append(new String(buffer, 0, len));
            }

            raf1.seek(3);
            raf1.write("xyz".getBytes());
            raf1.write(builder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf1 != null)
                    raf1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}
