package fibonacci;

/**
 * 斐波那契数列
 *
 * 时间限制：1秒 空间限制：32768K 热度指数：433939
 *
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class Solution {
	/**
	 * 循环解法
	 * @param n
	 * @return
	 */
    public int Fibonacci(int n) {
        int a = 0; 
        int b = 1;
        int result = 0;
        while(n-->0){
            if(result==0){
               a = a + b;
            }else{
               b = a + b;
            }
            result = result ^ 1;
        }
        if(result==0){
            return a;
        }else{
            return b;
        }
    }
    
    /**
     * 递归解法
     * @param n
     * @return
     */
    public int Fibonacci2(int n) {
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }else{
            return Fibonacci(n-2)+Fibonacci(n-1);
        }
    }
    
    
//    public static void main(String[] args) {
//		System.out.println(new Solution().Fibonacci(6));
//		System.out.println(new Solution().Fibonacci2(6));
//	}
    
}