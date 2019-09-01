package queueBy2Stack;

import java.util.Stack;

/**
 * 两个栈实现一个队列
 * 
 * 时间限制：1秒 空间限制：32768K 热度指数：332560
 * 本题知识点： 队列 栈
 *
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();//用来存数据，栈顶为队列入口
    Stack<Integer> stack2 = new Stack<Integer>();//用来弹数据，栈顶为队列出口
    
    public void push(int node) {
    	//入队：将stack2中的元素全部倒回到stack1中，使上一个最后入队的元素出现在stack1栈顶，然后在stack1栈顶加入元素
    	while(!stack2.empty()){
    		stack1.push(stack2.pop());
    	}
        stack1.push(node);
    }
    
    public int pop() {
    	//出队：将stack1中的元素全部倒到stack2中，使第一个加入stack1的元素暴露在stack2栈顶，然后弹出该元素。
    	while(!stack1.empty()){
    		stack2.push(stack1.pop());
    	}
    	return stack2.pop();
    }
}