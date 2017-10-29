package String;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
	    /*if(strs == null || strs.length == 0)    return "";
	    String pre = strs[0];
	    int i = 1;
	    while(i < strs.length){
	        while(strs[i].indexOf(pre) != 0)
	            pre = pre.substring(0,pre.length()-1);
	        i++;
	    }
	    return pre;*/
		
		
		if(strs == null || strs.length == 0) return "";
        for(int i = 0; i < strs[0].length(); i++)
        {
        	char c = strs[0].charAt(i);
        	for(int j = 1 ; j < strs.length;j++)
        		if( i == strs[j].length() || strs[j].charAt(i) != c)
        			return strs[0].substring(0, i);
        }
        return strs[0];
	}
	
	
	public static void main(String[] args) {
		
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		
		System.out.println(lcp.longestCommonPrefix(new String[]{"leetcode", "leet","leeds","leets"}));
	}
}