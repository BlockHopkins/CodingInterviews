package printListFromTailToHead;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 时间限制：1秒 空间限制：32768K 热度指数：710942
 * 本题知识点： 链表
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * @author Administrator
 */
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        if(listNode!=null){
	    	Stack<Integer> stack = new Stack<Integer>();
	    	ListNode tempNode = listNode;
	    	stack.push(tempNode.val);
	    	while(tempNode.next!=null){
	    		tempNode = tempNode.next;
	    		stack.push(tempNode.val);
	    	}
	        while(!stack.isEmpty()){
	        	resultList.add(stack.pop());
	        }
        }
    	return resultList;
    }
}

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}