package cn.pdsu.wkh;

/**
 * @author wkh
 * @create 2021-05-14 14:25
 */
public class test514 {

    public static void main(String[] args) {
        /*StringBuffer buffer = new StringBuffer("abcdefghijk");
        buffer.setCharAt(3,'z');

        int d = buffer.indexOf("d");
        String s = buffer.toString();

        int length = s.length();


        System.out.println(length);
        System.out.println(s);*/


        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());//
        System.out.println(sb);//
        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);//

    }
}
