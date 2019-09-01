package PrintFromTopToBottom;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上往下打印二叉树
 * 时间限制：1秒 空间限制：32768K 热度指数：282962
 * 
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    	//思路：广度优先遍历
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if(root==null){
    		return result;
    	}
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode temp = null;
        while(!queue.isEmpty()){
        	temp = queue.poll();
        	result.add(temp.val);//打印结果
        	//左右节点添加至队列
        	if(temp.left!=null){
        		queue.offer(temp.left);
        	}
        	if(temp.right!=null){
        		queue.offer(temp.right);
        	}
        }
        return result;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
