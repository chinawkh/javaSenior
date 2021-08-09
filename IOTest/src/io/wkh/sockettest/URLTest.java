package io.wkh.sockettest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author wkh
 * @create 2021-08-05 19:20
 */
public class URLTest {
    /**
     *
     * @param args
     *
     * 序列化：将内存层面的数据储存到文件；【为了保存】
     * 反序列化：将文件里面的数据还原为内存层面的数据【为了还原到内存层面】
     *
     */

    public static void main(String[] args){
        HttpURLConnection urlConnection = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL("http://localhost:8080/examples/hetong.png");
            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.connect();

            is = urlConnection.getInputStream();
            fos = new FileOutputStream("IOTest\\hetong1.png");

            byte[] buffer = new byte[10];
            int len;
            while ((len = is.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null){

                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            urlConnection.disconnect();

        }

    }
}
