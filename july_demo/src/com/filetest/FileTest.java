package com.filetest;

import org.junit.Test;

import java.io.File;

/**
 * @author wkh
 * @create 2021-07-19 19:59
 */
public class FileTest {
    /*
    1.File类的一个对象，代表一个文件或一个文件夹
    2.File类声明在java.io包下
     */

    @Test
    public void test1(){
        // 构造器一：
        File file = new File("hello.txt");  // 相对于当前module  相对路径
        File file1 = new File("D:\\workspace_idea\\test\\july_demo\\hello.txt");

        System.out.println(file);
        System.out.println(file1);
        // 构造器二：
        File file2 = new File("D:\\workspace_idea","test");

        // 构造器三；
        File file3 = new File(file2,"hi.txt");
        System.out.println(file3);


        String absolutePath = file2.getAbsolutePath();
        System.out.println(absolutePath);


    }


}
