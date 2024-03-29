package isPopOrder;

import java.util.ArrayList;

/**
 * 栈的压入、弹出序列
 * 时间限制：1秒 空间限制：32768K 热度指数：269783
 * 本题知识点： 栈
 * 
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
    	if(pushA.length==0 || popA.length==0){
    		return true;
    	}
    	ArrayList<Integer> stack = new ArrayList<Integer>();
    	int ipop = 0;
    	//入栈
    	for(int i=0;i<pushA.length;i++){
    		if(pushA[i] == popA[ipop]){
    			//如果相等则直接先弹出
    			ipop++;
    		}else{
    			//不相等则入栈
    			stack.add(pushA[i]);
    		}
    	}
    	//出栈，比较弹出的数据和stack中数组的倒序相不相同，不相同则为false
    	int ipush = stack.size()-1;
    	for(int i=ipop;i<popA.length&&ipush>=0;i++,ipush--){
    		if(popA[i]!=stack.get(ipush)){
    			return false;
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().IsPopOrder(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
		System.out.println(new Solution().IsPopOrder(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
	}
}
