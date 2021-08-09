package io.wkh.sockettest;

import com.sun.org.apache.bcel.internal.generic.IXOR;
import org.junit.Test;

import java.io.IOException;
import java.net.*;
import java.util.*;

/**
 * @author wkh
 * @create 2021-08-05 13:17
 */
public class UDPTest {

    @Test
    public void send() throws IOException {
        DatagramSocket socket = new DatagramSocket();


        String str = "我是UDP方式发送的导弹";
        byte[] data = str.getBytes();
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet = new DatagramPacket(data,0,data.length,inetAddress,8080);

        socket.send(packet);

        socket.close();

    }
    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(8080);

        byte[] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);
        socket.receive(packet);

        System.out.println(new String(packet.getData(),0,packet.getLength()));

        socket.close();


    }



    public boolean isPalindrome(int x) {

        String str = String.valueOf(x);
        StringBuilder builder = new StringBuilder(str);
        StringBuilder builder1 = builder.reverse();
        String reverseStr = builder1.toString();

        if (str.equals(reverseStr)){
            return true;
        }else{
            return false;
        }
    }

    @Test
    public void test1(){
        boolean palindrome = isPalindrome(1221);
        System.out.println(palindrome);
    }


    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int x = 0;
        int count = 0;
        if(nums.length > 0){
            x = nums[0];
        }
        for (int i = 1; i < (nums.length - count); ){
            if(x == nums[i]){

                for (int n = i+1; n < (nums.length - count); n++){
                    nums[n-1] = nums[n];
                }
                count++;
            }else {

                x = nums[i];
                i++;
            }
        }

        int size = nums.length - count;
//        System.out.print(size);
//        System.out.print(",nums = [");
//        for (int i = 0; i < size; i++){
//            if (i < (size-1))
//                System.out.print(nums[i]+",");
//            else
//                System.out.print(nums[i]);
//        }
//        System.out.println("]");
        return size;
    }

    @Test
    public void test2(){
        int[] ints = new int[5];
        ints[0] = 0;
        ints[1] = 1;
        ints[2] = 2;
        ints[3] = 2;
        ints[4] = 3;

        int size = removeDuplicates1(ints);
        for (int i = 0; i < size; i++){
            System.out.println(ints[i]);
        }
        System.out.println();


//        for (int i = 0; i < 4; i++){
//            ints[i] = ints[i+1];
//        }
    }

    public int removeDuplicates1(int[] nums) {

        if (nums.length == 0){
            return 0;
        }
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        int i = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            Integer integer = iterator.next();
            nums[i] = integer;
            i++;
        }

        System.out.println(nums[0]+","+nums[1]+","+nums[2]+","+nums[3]);
        System.out.println(set.size());

        return set.size();
    }







}
