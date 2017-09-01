package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

	public boolean isWordSplitInDictionary(String s, List<String> wordDict)
	{
		Set<String> set = new HashSet<String>(wordDict);
		int maxLen = 0;
		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;
		for(String s1 : set) maxLen = maxLen < s1.length() ? s1.length() : maxLen;
		for(int i = 1 ; i <= s.length(); i++)
		{
			/*
			 *  i =3 at a,l = 1,2,3 left = 2,1,0 - sub = m, am ,iam
			 */
			for(int l = 1 ; l <= maxLen && l <= i ;l++)
			{
				int left = i-l;
				dp[i] = dp[left] && set.contains(s.substring(left, i));
				if(dp[i])break;
			}
		}
        return dp[dp.length-1];
	}

	public static void main(String[] args) {
		List<String> ls = new ArrayList<String>();
		ls.add("I");
		ls.add("am");
		ls.add("ace");
		ls.add("a");
		ls.add("ya");
		System.out.println(new WordBreak().isWordSplitInDictionary("Iamace", ls));
	}
}
