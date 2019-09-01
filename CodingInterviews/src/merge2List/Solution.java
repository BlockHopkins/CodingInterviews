package merge2List;

/**
 * 合并两个排序的链表
 * 时间限制：1秒 空间限制：32768K 热度指数：372404
 * 本题知识点： 链表
 * 
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
    	ListNode result = list1;//默认以链表1为主链表
    	ListNode list1Cur = list1;//当前处理的节点
        ListNode list1Pre = null;//已处理的最后一个链表节点
        while(list1Cur!=null && list2!=null){
        	if(list1Cur.val<=list2.val){
        		//如果是当前链表数值较小，继续走
        		list1Pre = list1Cur;
        		list1Cur = list1Cur.next;
        	}else{
        		//如果另一个链表数值小，交换当前处理链表剩下的链表到list2，把另一个链表接到已处理链表上。
        		list1Pre.next = list2;
        		list2 = list1Cur;
        		list1Cur = list1Pre.next;
        		//走一步
        		list1Pre = list1Cur;
        		list1Cur = list1Cur.next;
        	}
        }
        //如果剩下的链表还有数据，接到末尾
        if(list2!=null){
        	list1Pre.next=list2;
        }
        return result;
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}