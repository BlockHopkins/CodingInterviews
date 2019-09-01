package findKthToTail;

import java.util.ArrayList;

/**
 * 链表中倒数第k个结点
 * 时间限制：1秒 空间限制：32768K 热度指数：536838
 * 本题知识点： 链表
 * 
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
    	if(head==null || k==0){
    		return null;
    	}
    	ArrayList<ListNode> arrayList = new ArrayList<ListNode>();
    	ListNode temp = head;
    	arrayList.add(temp);
    	while(temp.next!=null){
    		temp = temp.next;
    		arrayList.add(temp);
    	}
    	if(k>arrayList.size()){
    		return null;
    	}else{
    		return arrayList.get(arrayList.size()-k);
    	}
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

//链接：https://www.nowcoder.com/questionTerminal/529d3ae5a407492994ad2a246518148a
//优秀代码思路：
//两个指针，先让第一个指针和第二个指针都指向头结点，然后再让第一个指正走(k-1)步，到达第k个节点。
//然后两个指针同时往后移动，当第一个结点到达末尾的时候，第二个结点所在位置就是倒数第k个节点了。。
//    public ListNode FindKthToTail(ListNode head,int k) {
//        if(head==null||k<=0){
//            return null;
//        }
//        ListNode pre=head;
//        ListNode last=head;       
//        for(int i=1;i<k;i++){
//            if(pre.next!=null){
//                pre=pre.next;
//            }else{
//                return null;
//            }
//        }
//        while(pre.next!=null){
//            pre = pre.next;
//            last=last.next;
//        }
//        return last;
//    }