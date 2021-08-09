package io.wkh.test;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author wkh
 * @create 2021-07-26 23:29
 */
public class FileInputOutputStreamTest {

    @Test
    public void testFileInputStream() throws IOException {

        // 1.造文件
        File file = new File("hello.txt");
        // 2.造流
        FileInputStream fis = new FileInputStream(file);
        // 3.读数据
        byte[] bbuf = new byte[1];
        int len;

        while ((len = fis.read(bbuf)) != -1){
            String str = new String(bbuf,0,len);
            System.out.print(str);
        }
        // 4.流关闭
        fis.close();
    }
}
