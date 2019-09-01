package reverseList;

/**
 * 反转链表
 * 时间限制：1秒 空间限制：32768K 热度指数：390034
 * 本题知识点： 链表
 * 
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Solution {
    public ListNode ReverseList(ListNode head) {
    	if(head==null){
    		return null;
    	}
    	ListNode temp = head;
    	ListNode newHead = new ListNode(head.val);
    	while(temp.next!=null){
    		temp = temp.next;
    		ListNode newTemp = newHead;
    		newHead = new ListNode(temp.val);
    		newHead.next = newTemp;
    	}
    	return newHead;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}