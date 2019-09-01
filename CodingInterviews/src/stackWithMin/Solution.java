package stackWithMin;

import java.util.Stack;

/**
 * 包含min函数的栈
 * 时间限制：1秒 空间限制：32768K 热度指数：226639
 * 本题知识点： 栈
 * 
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */

public class Solution {
	Stack<Integer> stack = new Stack<Integer>();
	//根据栈先进后出的特性，如果一开始加入栈中的数值n比后面加入的所有数值小，那么在将n及之后的数值弹出前，当前栈的最小值不会变化。
	//只有当后面入栈的数值m比n更小，当前栈的最小值才会变成m，但m弹出后最小值恢复为n，且m必须比n先弹出
	//根据这种特性，可以再用一个栈来记录当前栈的最小值，栈顶表示当前栈的最小值，入栈时只有小于等于该栈顶元素的时候，才会入到这个最小值栈
	//（考虑入栈有相等元素，需要把相等元素也入栈，否则弹出的时候会忽略掉相等的元素）
	Stack<Integer> minStack = new Stack<Integer>();
    
    public void push(int node) {
        stack.push(node);
        if(minStack.isEmpty() || node<=minStack.peek()){
        	minStack.push(node);
        }
    }
    
    public void pop() {
    	if(!minStack.isEmpty() && !stack.isEmpty() && minStack.peek().equals(stack.peek())){
    		minStack.pop();
    	}
    	stack.pop();
    }
    
    public int top() {
    	if(!stack.isEmpty()){
    		stack.peek();
    	}
    	return 0;
    }
    
    public int min() {
        return minStack.peek();
    }
}