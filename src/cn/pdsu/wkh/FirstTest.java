package cn.pdsu.wkh;

/**
 * @author wkh
 * @create 2021-05-13 18:24
 */
public class FirstTest {

    // 字母反转，如：abcdefj-->abfedcj

    public static String reverse(String str,int startIndex,int endIndex){

        if (str != null){

          //  StringBuilder builder = new StringBuilder(str);

            StringBuilder stringBuilder = new StringBuilder(str.length());

            stringBuilder.append(str.substring(0,startIndex));

            for (int i=endIndex;i>=startIndex;i--){
                stringBuilder.append(str.charAt(i));
            }

            stringBuilder.append(str.substring(endIndex+1));

            return stringBuilder.toString();

        }

        return null;
    }


    public static void main(String[] args) {
        System.out.println("12321");

        String reverseString = reverse("12345678", 3, 6);

        System.out.println(reverseString);
    }
}
