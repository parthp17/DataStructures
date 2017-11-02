package String;

public class MinInsertionShortestPalindrome {

	public String shortestPalindrome(String s) {
    
		//KMP 
		
		StringBuilder sb = new StringBuilder(s);
		String s1 = s + '#' + sb.reverse().toString();
		int[] values = new int[s1.length()];
		values[0] = 0;
		
		for(int j =0 , i = 1 ; i < s1.length(); i++)
		{
			do{
				if(s1.charAt(i) == s1.charAt(j))
				{
					values[i] = j+1;
					j += 1;
					break;
				}
				else
				{
					if(j-1 > 0 )
						j = values[j-1];
					else if (j == 0) j--;
					else
						j =0;
				}
			}
			while(j >= 0);
			if(j < 0) j = 0;
		}
		
		return s1.substring(s.length()+1,s1.length()-values[s1.length()-1])+s;
		
    }
	
	private boolean isPalindrome(String s, int start, int end)
	{
		
		while(start < end)
		{
			if(s.charAt(start++) != s.charAt(end--)) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(new MinInsertionShortestPalindrome().shortestPalindrome("babbbabbaba"));
	}
}
