package Test7month;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author wkh
 * @create 2021-07-03 19:24
 */
public class StringTest {
    public static void main(String[] args) {
        final StringBuilder sb = new StringBuilder("abc");
      //  sb = new StringBuilder("456");
        StringBuilder sb1 = sb.append("123");
        System.out.println(sb1);

        final String str = new String("123");

        final Collection coll = new ArrayList();
        coll.add(123);
        System.out.println(coll);
    }

    @Test
    public void test1(){
        String[] arr = new String[]{"mm","mm","mm"};

//        for (int i = 0;i < arr.length;i++){
//            arr[i] = "gg";
//        }

        // 出现了新变量 String的不可变性
        for (String s : arr) {
            s = "gg";
        }

        for (int i = 0; i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

}
