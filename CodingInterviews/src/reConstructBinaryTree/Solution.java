package reConstructBinaryTree;

/**
 * 重建二叉树
 * 时间限制：1秒 空间限制：32768K 热度指数：499375
 * 
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Solution {
	/**
	 * 思路：逐一遍历前序序列，在中序遍历序列中找到该元素，切分出左子树元素和右子树元素，在对左子树元素和右子树递归处理。
	 * @param pre
	 * @param in
	 * @return
	 */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length==0 || in.length==0)
            return null;
        int preIndex = 0;
        TreeNode root = new TreeNode(pre[preIndex]);//
        
        preIndex = rebuildBinaryTree(pre, in, root, preIndex, 0, in.length-1);
        return root;
    }
    
    /**
     * 对前序序列中的第n个节点，构建以该节点为根节点的子二叉树
     * @param pre 前序遍历序列
     * @param in 中序遍历序列
     * @param node 当前节点
     * @param preIndex 当前正在使用的前序序列位置
     * @param inBegin 当前处理的中序遍历序列起点
     * @param inEnd 当前处理的中序遍历序列终点
     * @return
     */
    private int rebuildBinaryTree(int [] pre, int [] in, TreeNode node, int preIndex, int inBegin, int inEnd){
        int pos = searchInMid(in, inBegin, inEnd, pre[preIndex]);//得到前序第preIndex节点在中序中的位置，用来切割左子树元素和右子树元素。
        int preIndexNew = preIndex+1;//下一个要使用的前序序列元素下标（还未构建树节点的前序序列元素）
        //如果在中序序列中左边还有元素，构建左子树
        if(pos>inBegin){
            TreeNode leftNode = new TreeNode(pre[preIndexNew]);
            preIndexNew = rebuildBinaryTree(pre, in, leftNode, preIndexNew, inBegin, pos-1);
            node.left = leftNode;
        }
        //如果在中序序列中右边还有元素，构建右子树
        if(pos<inEnd){
            TreeNode rightNode = new TreeNode(pre[preIndexNew]);
            preIndexNew = rebuildBinaryTree(pre, in, rightNode, preIndexNew, pos+1,inEnd);
            node.right = rightNode;
        }
        //返回下一个要处理的前序序列元素下标
        return preIndexNew;
    }
    
    /**
     * 在中序遍历序列中查找某元素
     * @param array 待查找序列
     * @param begin 待查找子序列的第一个元素下标
     * @param end 待查找子序列的最后一个元素下标
     * @param val 查找的数值
     * @return
     */
    private int searchInMid(int[] array, int begin, int end, int val){
        for(int i=begin; i<=end; i++){
            if(val==array[i]){
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Definition for binary tree
     */
     class TreeNode {
     	int val;
     	TreeNode left;
     	TreeNode right;
     	TreeNode(int x) { val = x; }
     }
}