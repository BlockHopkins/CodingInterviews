package twoDimensionalFind;

/**
 * 时间限制：1秒 空间限制：32768K 热度指数：914193
 * 本题知识点： 查找
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution {
    public boolean Find(int target, int [][] array) {
        for(int i=0; i<array.length; i++){
            if(binarySearch(target, array[i])!=-1){
                return true;
            }
        }
        return false;
    }
    
    /**
     * 二分法查找
     * @param val
     * @param array
     * @return
     */
    private int binarySearch(int val, int[] array){
    	if(array.length==0){
    		return -1;
    	}
        int head = 0;
        int tail = array.length-1;
        int mid = (head+tail)/2;
        while(array[mid]!=val && head<tail){
            if(val>array[mid]){
                head = mid+1;
            }else if(val<array[mid]){
                tail = mid-1;
            }
            mid = (head+tail)/2;
        }
        if(array[mid]==val){
            return mid;
        }else{
            return -1;
        }
    }
    
//    public static void main(String[] args) {
//		System.out.println(new Solution().Find(15,new int[][]{{4,7,10,13},{6,8,11,15}}));
//	}
    
    
    
    /**
     * 其他人的好解法：
     * 从左下角来看，向上数字递减，向右数字递增，
     * 因此从左下角开始查找，当要查找数字比左下角数字大时。右移
     * 要查找数字比左下角数字小时，上移
     * 链接：https://www.nowcoder.com/questionTerminal/abc3fe2ce8e146608e868a70efebf62e
     * 来源：牛客网
     * 
     * 实例代码(C语言)
     */
//    class Solution {
//    	public:
//		    bool Find(vector<vector<int> > array,int target) {
//		        int rowCount = array.size();
//		        int colCount = array[0].size();
//		        int i,j;
//		        for(i=rowCount-1,j=0;i>=0&&j<colCount;)
//		        {
//		            if(target == array[i][j])
//		                return true;
//		            if(target < array[i][j])
//		            {
//		                i--;
//		                continue;
//		            }
//		            if(target > array[i][j])
//		            {
//		                j++;
//		                continue;
//		            }
//		        }
//		        return false;
//		   }
//	};
}
