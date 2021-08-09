package io.wkh.test;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author wkh
 * @create 2021-07-27 21:53
 */
public class IOexercise {

    @Test
    public void charCount() throws IOException {
        // 造文件
      File srcfile = new File("注意事项 - 副本.txt");
      File destfile = new File("wordcount.txt");
        // 造流
//        FileInputStream fis = new FileInputStream("注意事项 - 副本.txt");
//        FileOutputStream fos = new FileOutputStream("wordcount.txt");
        FileReader fr = new FileReader(srcfile);
        FileWriter fw = new FileWriter(destfile);
        BufferedReader br = new BufferedReader(fr);
        BufferedWriter bw = new BufferedWriter(fw);

        // 操作数据
        Map<Character,Integer> map = new HashMap<>();
        char[] cbuf = new char[5];
        int len;
        while ((len = br.read(cbuf))!=-1){
            char c;
            for (int i=0;i<len;i++){
                c = cbuf[i];
                if (map.get(c)==null){
                    map.put(c,1);
                }else {
                    map.put(c,map.get(c)+1);
                }
            }
        }


        // 遍历map把数据写入wordCount.txt文件中
        Set<Map.Entry<Character,Integer>> entrySet = map.entrySet();
        for (Map.Entry<Character,Integer> entry : entrySet){
            switch (entry.getKey()){
                case ' ':
                    bw.write("空格="+entry.getValue());
                    break;
                case '\t':
                    bw.write("tab键="+entry.getValue());
                    break;
                case '\n':
                    bw.write("换行="+entry.getValue());
                    break;
                case '\r':
                    bw.write("回车键="+entry.getValue());
                    break;
                default:
                    bw.write(entry.getKey()+"="+entry.getValue());
                    break;
            }
            bw.newLine();
        }




        // 流资源关闭

        bw.close();
        br.close();

    }
}
