package replaceSpace;

/**
 * 时间限制：1秒 空间限制：32768K 热度指数：795549
 * 本题知识点： 字符串
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Solution {
    public String replaceSpace(StringBuffer str) {
    	final char patten = ' ';
    	final String target = "%20";
    	for(int i=0;i<str.length();i++){
    		if(str.charAt(i)==patten){
    			str = str.replace(i, i+1, target);
    			i=i+2;
    		}
    	}
    	return str.toString();
    }
}
