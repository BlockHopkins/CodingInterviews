package FindPath;

import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 * 时间限制：1秒 空间限制：32768K 热度指数：286801
 * 
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Solution {
	private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        //深度优先
    	ArrayList<Integer> path = new ArrayList<Integer>();
    	DFS(path, root, target, 0);
    	return result;
    }
    
    private void DFS(ArrayList<Integer> path, TreeNode node, int target, int sum){
    	if(node==null){
    		return;
    	}
    	path.add(node.val);
    	sum = sum + node.val;
    	if(sum<target){
    		//如果当前路径节点值小于目标值，继续遍历左右节点
    		if(node.left!=null){
    			if(node.right!=null){
    				//如果有右节点，则搜索左子树需要新建一个新链表，原链表给右子树用，避免添加节点时互相影响
    				ArrayList<Integer> path2 = new ArrayList<Integer>();
    				path2.addAll(path);
    				DFS(path2, node.left, target, sum);
    			}else{
    				DFS(path, node.left, target, sum);
    			}
    		}
    		if(node.right!=null){
    			DFS(path, node.right, target, sum);
    		}
    	}else if(sum==target && node.left==null && node.right==null){
    		result.add(path);
    		return;
    	}else{
    		//如果节点都为正数，则下面节点之后让sum增大，可以不用继续搜索了
    		return;
    	}
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