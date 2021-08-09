package io.wkh.test;

import org.junit.Test;

import java.io.*;

/**
 * @author wkh
 * @create 2021-07-28 17:52
 */
public class InputStreamReaderTest {

    //处理流：转换流，属于字符流，提供字节流与字符流之间的转换
    /**
     * InputStreamReader ：将一个字节的输入流转换为字符的输入流
     *
     * OutputStreamWriter：将一个字符的输出流转换为字节的输出流
     *
     * 字符集：
     *
      */
    @Test
    public void testInputStreamReader() {
        // 1
        FileInputStream fis = null;
        InputStreamReader isr = null;
        try {
            fis = new FileInputStream("注意事项 - 副本.txt");

            isr = new InputStreamReader(fis);

            char[] cbuf = new char[5];
            int len;
            while ((len=isr.read(cbuf))!=-1){
                for (int i=0;i<len;i++){
                    System.out.print(cbuf[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (isr != null)
                    isr.close();
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
    public void test1() throws IOException {
        // 1.
        File file1 = new File("注意事项 - 副本.txt");
        File file2 = new File("注意事项 - 副本gbk.txt");

        // 2.
        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);

        InputStreamReader isr = new InputStreamReader(fis);
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");

        // 3.
        char[] cbuf = new char[5];
        int len;
        while ((len = isr.read(cbuf)) != -1){
            String str = new String(cbuf,0,len);
            System.out.print(str);

            osw.write(cbuf,0,len);
        }
        // 4.
        osw.close();
        isr.close();

    }

    public static void main(String[] args) {
        String[] str = new String[5];
        for (String myStr : str) {
            myStr = "atguigu";
            System.out.println(myStr);
        }
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }


}
