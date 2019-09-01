package printMatrix;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 * 时间限制：1秒 空间限制：32768K 热度指数：382705
 * 本题知识点： 数组
 * 
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵：
 *  1 2 3 4 
 *  5 6 7 8 
 *  9 10 11 12 
 *  13 14 15 16 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
       ArrayList<Integer> list = new ArrayList<Integer>();
       if(matrix.length==0){
    	   return list;
       }
       int top=1;
       int right=matrix[0].length-1;
       int bottom=matrix.length-1;
       int left=0;
       int direction = 0;//0右，1下，2左，3上
       int i=0;
       int j=0;
       while(true){
    	   list.add(matrix[i][j]);
    	   if(direction==0){//向右
    		   if(j<right){
    			   j++;
    		   }else if(i==bottom){
    			   break;
    		   }else{
    			   //到达右边距，改变方向向下，右边距减1
    			   i++;
    			   right--;
    			   direction++;
    		   }
    	   }else if(direction==1){//向下
    		   if(i<bottom){
    			   i++;
    		   }else if(j==left){
    			   break;
    		   }else{
    			   //到达底边距，改变方向向左，底边距减1
    			   j--;
    			   bottom--;
    			   direction++;
    		   }
    	   }else if(direction==2){//向左
    		   if(j>left){
    			   j--;
    		   }else if(i==top){
    			   break;
    		   }else{
    			   //到达左边距，改变方向向上，左边距减1
    			   i--;
    			   left++;
    			   direction++;
    		   }
    		   
    	   }else if(direction==3){//向上
    		   if(i>top){
    			   i--;
    		   }else if(j==right){
    			   break;
    		   }else{
    			   //到达上边距，改变方向向右，上边距减1
    			   j++;
    			   top++;
    			   direction = 0;
    		   }
    	   }
       }
       return list;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	solution.printArrayList(solution.printMatrix(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}));
	}
    
    /**
     * 打印测试数据
     * @param matrix
     */
    public void printArray(int [][] matrix){
    	for(int i=0;i<matrix.length;i++){
     	   for(int j=0;j<matrix[i].length;j++){
     		   System.out.print(matrix[i][j]+" ");
     	   }
     	   System.out.println();
        }
    }
    
	/**
	 * 打印ArrayList
	 * @param list
	 */
	public void printArrayList(ArrayList list){
		for(int i=0;i<list.size();i++){
			System.out.print(list.get(i)+" ");
		}
	}
}