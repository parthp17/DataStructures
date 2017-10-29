
package String;

public class LongestPalindromicSubstring {

	 public String longestPalindrome(String s) {
	    if(s == null || s.length() == 0 || s.length() == 1) return s;
		int  maxLen = 0;
		int a = 0;
		int b  = 0;
		String s1 = "";
		for(int i = 0; i < s.length() ; i++)
		{
			a = extend(s, i, i);
			b = extend(s, i, i+1);
			
			if(a > maxLen)
			{
				maxLen = a;
				s1 = s.substring(i - maxLen/2, i + maxLen/2+ 1);
			}
			if(b > maxLen)
			{
				maxLen = b;
				s1 = s.substring(i - maxLen/2+1, i + maxLen/2+1);
			}
		}
		return s1;
	 }
	 
	 private int extend(String s, int j , int k)
	 {
		while(j >=0 && k < s.length() && s.charAt(k) == s.charAt(j))
		{
			j--;
			k++;
		}
		 return k -j - 1;
	 }
	 
	 public static void main(String[] args) {
		
		 LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		 System.out.println(lps.longestPalindrome("sdsdpaapsdss"));
	}
}
