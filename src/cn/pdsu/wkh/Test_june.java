package cn.pdsu.wkh;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author wkh
 * @create 2021-06-17 18:28
 */
public class Test_june {

    public String reverseLeftWord(String str,int n){
        return str.substring(n,str.length())+str.substring(0,n);
    }

    public int romanToInt(String s){
        int sum = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++){
            if (i<chars.length-1&&map.get(chars[i])<map.get(chars[i+1])){
                sum -= map.get(chars[i]);
            }else {
                sum += map.get(chars[i]);
            }
        }
        return sum;

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1!=null && l2!=null){
            if (l1.val<l2.val){
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            }else {
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 != null) head.next = l1;
        if (l2 != null) head.next = l2;
        return dummy.next;
    }

    public static void main(String[] args) {
        Test_june tj = new Test_june();
        String str1 = tj.reverseLeftWord("abcdef", 3);
        System.out.println(str1);

        int num = tj.romanToInt("VII");
        System.out.println(num);

        ListNode l1 = new ListNode(-1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode listNode = tj.mergeTwoLists(l1, l2);
        System.out.println(listNode);


    }

}
