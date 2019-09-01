package jumpFloorII;

/**
 * 变态跳台阶
 * 时间限制：1秒 空间限制：32768K 热度指数：264840
 * 
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Solution {
    public int JumpFloorII(int target) {
    	if(target==0){
    		return 1;
    	}else{
    		int sum = 0;
    		for(int i=1;i<=target;i++){
    		  sum += JumpFloorII(target-i);
    		}
    		return sum;
    	}
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().JumpFloorII(3));
	}
}