package cn.pdsu.wkh;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wkh
 * @create 2021-05-22 11:58
 */
public class Test522 {

   /* public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            // 由于是两数相加等于target
            // 索引另一个数的值是target减去当前考察的元素值
            int anotherNum = target-nums[i];

            // 判断另一个数在map中是否存在
            // 存在则说明找到两个数，其和为target
            if (map.containsKey(anotherNum)) {
                return new int[]{map.get(anotherNum), i};
            }

            // key是当前考察的元素值，value是当前考察的元素对应的索引
            map.put(nums[i], i);
        }
        return new int[0];
    }*/

    @Test
    public void testSum(){
        Test522 test522 = new Test522();
        int [] nums = new int[3];
        nums[0] = 2;
        nums[1] = 3;
        nums[2] = 5;

        int[] ints = test522.twoSum(nums, 7);
        System.out.println(ints.length);
        System.out.println(ints.toString()+":"+ints[0]+":"+ints[1]);

    }

    // 两数之和
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){

            int anotherNum = target - nums[i];

            if (map.containsKey(anotherNum)){
                return new int[]{map.get(anotherNum),i};
            }

            map.put(nums[i],i);
        }

        return new int[0];

    }

    // 整数反转
    public int reverse(int x) {

        if (x!=0){
            String xString = Integer.toString(x);

            String str = xString;

            int flag = 1;

            if (x < 0){
                flag = -1;
                str = xString.substring(1);
            }
            try {
                StringBuffer sb = new StringBuffer(str);
                StringBuffer reverseStr = sb.reverse();
                String str1 = reverseStr.toString();
                int int1 = Integer.parseInt(str1);
                return int1*flag;
            } catch (Exception e) {
                return 0;
            }

        }
        return 0;
    }
   /* public int reverse(int x) {
        String xString = Integer.toString(x);
        String string = xString;
        int flag = 1;
        if (x < 0) {
            flag = -1;
            string = xString.substring(1);
        }
        try {
            return Integer.valueOf((new StringBuilder(string)).reverse().toString()) * flag;
        }catch (Exception e){
            return 0;
        }
    }*/
    @Test
    public void testReverse(){
        Test522 test522 = new Test522();
        int reverseNum = test522.reverse(1534236469);
        System.out.println(reverseNum);


    }



    @Test
    public void testStr(){
        String str = "1320";
        StringBuffer sbu = new StringBuffer(str); // sbu 1320
        StringBuffer reverseStr = sbu.reverse();   // reverserStr 0231
        Integer num = Integer.valueOf(reverseStr.toString());  // num 231
        System.out.println(num);
    }

}
