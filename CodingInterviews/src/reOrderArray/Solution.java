package reOrderArray;

/**
 * 调整数组顺序使奇数位于偶数前面 
 * 时间限制：1秒 空间限制：32768K 热度指数：385031
 * 本题知识点： 数组
 * 
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Solution {
	public void reOrderArray(int [] array) {
        int evenIndex = -1;//记录第一个偶数的位置
		for(int i=0; i<array.length; i++){
			if(array[i]%2==0){//如果是偶数
	        	if(evenIndex ==-1){
	        		evenIndex = i;
	        		continue;
	        	}
			}else{//如果是奇数
				if(evenIndex !=-1){
					//如果有偶数，将当前奇数提到偶数前
					int temp = array[i];
					for(int j=i; j>evenIndex; j--){
						array[j]=array[j-1];
					}
					array[evenIndex++]=temp;
				}
			}
        }
    }
}
