package jumpFloor;

/**
 * 跳台阶
 * 时间限制：1秒 空间限制：32768K 热度指数：334309
 * 
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Solution {
    public int JumpFloor(int target) {
    	if(target==0){
    		return 0;//数据错误
    	}
    	if(target==1){
    		return 1;//只剩一级，只有[1]一种跳法
    	}else if(target==2){
    		return 2;//只剩二级，只有两种跳法：[2] 或者 [1,1]
    	}else{
    		//如果剩下大于两级，则有当前采用跳一级的跳法和采用跳两级的跳法
    		return JumpFloor(target-1)+JumpFloor(target-2);
    	}
    }
    
//    public static void main(String[] args) {
//		System.out.println(new Solution().JumpFloor(4));
//	}
}
