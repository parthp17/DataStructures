package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class LongestUncommonSubsequence2 {

	public boolean isSubsequence(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++)
            if (x.charAt(j) == y.charAt(i))
                j++;
        return j == x.length();
    }
	
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, new Comparator < String > () {
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        boolean flag = false;
        int result = strs[0].length(); 
        for(int i = 0, j; i < strs.length; i++) {
        	flag = false;
            for(j = i + 1; j < strs.length && !flag; j++) {
            	flag = isSubsequence(strs[j], strs[i]);
            }
            if (!flag && --j < strs.length)
                return strs[j].length();
        }
        return -1;
    }

    public static void main(String[] args) {
		LongestUncommonSubsequence2 l = new LongestUncommonSubsequence2();
		System.out.println(l.findLUSlength(new String[]{"aaa", "aaa","aa"}));
	}
}