package LeetCode;

public class LongestPalindromicSubstring {

	public String LongestPalindromicSubstring(String s)
	{
		String sMax = "";
		int max = 0;
		int len = s.length();
		for(int i = 0; i < len ; i++)
		{
			int l1 = extend(s,i,i);
			int l2 = extend(s,i,i+1);
			int tempMax = l1 > l2 ? l1 : l2;
			if(tempMax  > max)
			{
				max = tempMax;
				if(max == l1)
					sMax = s.substring( i - max/2, i + max/2 + 1);
				else
					sMax = s.substring( i - max/2 + 1, i + max/2 + 1);
			}
		}
		System.out.println(max);
		return sMax;
	}
	
	private int extend(String s, int j, int k)
	{
		int len = s.length();
		while(j >= 0 && k < len && s.charAt(j)==s.charAt(k))
		{
			j--;
			k++;
		}
		return k-j-1;
	}
	
	public static void main(String[] args) {
		
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		System.out.println(lps.LongestPalindromicSubstring("forgeeksskeegrof"));
	}
	
}
