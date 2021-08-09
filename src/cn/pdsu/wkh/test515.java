package cn.pdsu.wkh;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wkh
 * @create 2021-05-15 15:27
 */
public class test515 {

    public static void main(String[] args) {
        /*Date date = new Date();

        System.out.println(date);

        long timeMillis = System.currentTimeMillis();
        System.out.println(timeMillis);

        System.out.println(date.getTime());

        Date date1 = new Date(date.getTime());

        System.out.println(date1.getTime());

        System.out.println(date1.toString());*/

        Date date = new Date();

        SimpleDateFormat formater = new SimpleDateFormat();

        System.out.println(formater.format(date));

        SimpleDateFormat formater2 = new SimpleDateFormat("yyyy年MM月dd日 EEE HH:mm:ss");

        System.out.println(formater2.format(date));

        try {
        // 实例化一个指定的格式对象
            Date date2 = formater2.parse("2008年08月08日 星期一 08:08:08");
        // 将指定的日期解析后格式化按指定的格式输出
            System.out.println(date2.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }





    }
}
