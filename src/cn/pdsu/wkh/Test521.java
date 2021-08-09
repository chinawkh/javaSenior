package cn.pdsu.wkh;

import java.sql.SQLOutput;

/**
 * @author wkh
 * @create 2021-05-21 10:22
 */
public class Test521 {

    public int getCount(String mainStr,String subStr){
        int count = 0;
        int mainLenth = mainStr.length();
        int subLenth = subStr.length();
        int index = 0;
        if (mainLenth>=subLenth){
            // 方式一：效率略低
//            while ((index=mainStr.indexOf(subStr))!=-1){
//                count++;
//                mainStr = mainStr.substring(index+subStr.length());
//            }
            // 方式二：不需要重新造String
            while ((index=mainStr.indexOf(subStr,index))!=-1){
                count++;
                index += subLenth;
            }
            return count;
        }else {
            return count;
        }

    }

    public String getMaxSameString(String str1,String str2){
        if (str1 != null && str2 != null){
            String maxStr = str1.length() >= str2.length() ? str1 : str2;
            String minStr = str1.length() < str2.length() ? str1 : str2;
            String subStr;
            int length = minStr.length();

            for (int i = 0; i < length;i++){
                for (int x = 0,y = length-i;y <= length;x++,y++){
                    subStr = minStr.substring(x,y);
                    // 长的字符串不动，让短的字符串不断的做变化，去和长的字符串做匹配
                    if (maxStr.contains(subStr)){
                        return subStr;
                    }
                }
            }

        }
        return null;
    }


    public static void main(String[] args) {
        Test521 test521 = new Test521();
        String mainStr = "abdabdedingidabdeab";  // 四个ab
        String subStr = "abdet";
        int count = test521.getCount(mainStr, subStr);
        System.out.println("字符串个数："+count);

        String sameStr = test521.getMaxSameString(mainStr,subStr);
        System.out.println("最大相同字符串:"+sameStr);

    }

}
