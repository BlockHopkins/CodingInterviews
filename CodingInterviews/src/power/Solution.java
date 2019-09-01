package power;

/**
 * 数值的整数次方
 * 时间限制：1秒 空间限制：32768K 热度指数：330443
 * 
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Solution {
    public double Power(double base, int exponent) {
        if(exponent==0){
            return 1;
        }else if(exponent<0 && base!=0){
        	return Power(1/base, (-1)*exponent);
        }else{
            return Power(base, exponent-1) * base;
        }
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().Power(2, -4));
	}
}