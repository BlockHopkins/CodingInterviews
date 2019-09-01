package RandomListNodeClone;

import java.util.HashMap;

/**
 * 复杂链表的复制
 * 时间限制：1秒 空间限制：32768K 热度指数：285714
 * 本题知识点： 链表
 * 
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Solution {
    public RandomListNode Clone(RandomListNode pHead){
    	if(pHead==null){
    		return null;
    	}
        RandomListNode resultNode = new RandomListNode(pHead.label);
        HashMap<Integer,RandomListNode> cacheMap = new HashMap<Integer,RandomListNode>();

        RandomListNode temp = pHead;
        RandomListNode resultTemp = resultNode;
        
        while(temp.next!=null){
        	//设定当前节点的next;
        	if(cacheMap.containsKey(temp.next.label)){
        		resultTemp.next = cacheMap.get(temp.next.label);
        	}else{
	        	resultTemp.next = new RandomListNode(temp.next.label);
	        	cacheMap.put(temp.next.label, resultTemp.next);
        	}
        	//设定当前节点的random
        	if(temp.random!=null){
	        	if(cacheMap.containsKey(temp.random.label)){
	        		resultTemp.random = cacheMap.get(temp.random.label);
	        	}else{
	        		resultTemp.random = new RandomListNode(temp.random.label);
	        		cacheMap.put(temp.random.label, resultTemp.random);
	        	}
        	}
        	temp = temp.next;
        	resultTemp = resultTemp.next;
        }
        return resultNode;
    }
    
    /**
     * 测试链表输入
     * @param array 链表元素
     * @param random 每一位链表元素的random指针，-1表示空
     * @return
     */
    private static RandomListNode inputList(int[] array, int[]random){
    	if(array.length==0){
    		return null;
    	}
    	RandomListNode pHead = new RandomListNode(array[0]);
    	RandomListNode temp = pHead;
    	HashMap<Integer,RandomListNode> cacheMap = new HashMap<Integer,RandomListNode>();
    	for(int i=1;i<array.length;i++){
    		temp.next = new RandomListNode(array[i]);
        	cacheMap.put(array[i], temp.next);
        	temp = temp.next;
        }
    	temp = pHead;
    	for(int i=0;i<random.length;i++){
    		if(random[i]!=-1 && cacheMap.containsKey(random[i])){
    			temp.random = cacheMap.get(random[i]);
    		}
    		temp = temp.next;
    	}
    	return pHead;
    }
    
    public static void main(String[] args) {
		new Solution().Clone(inputList(new int[]{1,2,3,4,5}, new int[]{3,5,-1,2,-1}));
	}
    
//    其他人更好的解法
//    链接：https://www.nowcoder.com/questionTerminal/f836b2c43afc4b35ad6adc41ec941dba
//		/*
//	        1、复制每个节点，如：复制节点A得到A1，将A1插入节点A后面
//	        2、遍历链表，A1->random = A->random->next;
//	        3、将链表拆分成原链表和复制后的链表
//	    */
//	     
//	    RandomListNode* Clone(RandomListNode* pHead)
//	    {
//	        if(!pHead) return NULL;
//	        RandomListNode *currNode = pHead;
//	        while(currNode){
//	            RandomListNode *node = new RandomListNode(currNode->label);
//	            node->next = currNode->next;
//	            currNode->next = node;
//	            currNode = node->next;
//	        }
//	        currNode = pHead;
//	        while(currNode){
//	            RandomListNode *node = currNode->next;
//	            if(currNode->random){               
//	                node->random = currNode->random->next;
//	            }
//	            currNode = node->next;
//	        }
//	        //拆分
//	        RandomListNode *pCloneHead = pHead->next;
//	        RandomListNode *tmp;
//	        currNode = pHead;
//	        while(currNode->next){
//	            tmp = currNode->next;
//	            currNode->next =tmp->next;
//	            currNode = tmp;
//	        }
//	        return pCloneHead;
//	    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}