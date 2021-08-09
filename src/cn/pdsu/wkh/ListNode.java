package cn.pdsu.wkh;

/**
 * @author wkh
 * @create 2021-06-18 11:38
 */
public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
         ListNode head = this;
         StringBuilder sb = new StringBuilder();
         while (head != null){
             sb.append(head.val + " ");
             head = head.next;
         }
         return sb.toString();
    }
}
