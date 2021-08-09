package io.wkh.sockettest;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author wkh
 * @create 2021-08-05 12:18
 */
public class SocketTest {



    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        try {
            // 1.造socket,指明网络地址，端口号
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 8080);
            // 2.通过socket获取输出流，{往服务器端输出数据，所以要用socket来获取输出流}
            os = socket.getOutputStream();
            // 3.造输入流，即往客户端内输入的数据
            fis = new FileInputStream(new File("微信收款码.png"));
            // 4.对数据的读写操作
            int len;
            byte[] buffer = new byte[10];
            while ((len = fis.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {

                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
    }

    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            // 1.获取socket
            ss = new ServerSocket(8080);
            // 2. 接收客户端
            socket = ss.accept();
            // 3. 获取输入流
            is = socket.getInputStream();
            // 4. 造输出流
            fos = new FileOutputStream(new File("微信收款码1.png"));

            // 5.对数据进行读写操作
            byte[] buffer = new byte[10];
            int len;
            while ((len = is.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 6.对资源进行关闭
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
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (ss != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


    }
}
