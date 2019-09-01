package minNumberInRotateArray;

import java.util.ArrayList;

/**
 * 旋转数组的最小数字
 * 时间限制：3秒 空间限制：32768K 热度指数：460085
 * 本题知识点： 查找
 * 
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Solution {
    public int minNumberInRotateArray(int [] array) {
    	for(int i=0;i+1<array.length;i++){
    		if(array[i]>array[i+1]){
    			return array[i+1];
    		}
    	}
    	if(array.length==0){
    		return 0;
    	}else{
    		return array[0];
    	}
    }
    
//    public static void main(String[] args) {
//		System.out.println(new Solution().minNumberInRotateArray(new int[]{3,4,1,1,2}));
//		System.out.println(new Solution().minNumberInRotateArray(new int[]{}));
//		System.out.println(new Solution().minNumberInRotateArray(new int[]{5}));
//	}
}