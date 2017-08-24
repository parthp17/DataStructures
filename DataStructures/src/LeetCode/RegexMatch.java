package LeetCode;

public class RegexMatch {

	public boolean isMatch(String input, String regex)
	{
		
		if(regex == null || input == null) return false;
		/*if(regex.isEmpty() && !input.isEmpty()) return false;
		if(regex.isEmpty() && input.isEmpty()) return true;*/
		int inputLen = input.length();
		int regexLen =  regex.length();
		
		boolean[][] matrix = new boolean[inputLen+1][regexLen+1];
		matrix[0][0] = true;
		
		for(int i = 1; i <= regexLen; i++)
		{	
			if(regex.charAt(i-1) == '*') matrix[0][i] = matrix[0][i-2];
		}
		
		for(int i = 1 ; i <= inputLen ; i++)
		{
			for(int j = 1; j <= regexLen ; j++)
			{
				if(input.charAt(i-1) == regex.charAt(j-1) || regex.charAt(j-1) == '.')
					matrix[i][j] = matrix[i-1][j-1];
				else if(regex.charAt(j-1) == '*')
				{
					matrix[i][j] = matrix[i][j-2];
					if(!matrix[i][j] && (regex.charAt(j-2) == input.charAt(i-1) || regex.charAt(j-2) == '.'))
						matrix[i][j] = matrix[i-1][j];
				} 
				else
					matrix[i][j] = false;
			}
		}
		return matrix[inputLen][regexLen];
	}
	
	public static void main(String[] args) {
		
		RegexMatch rm = new RegexMatch();
		System.out.println(rm.isMatch("a", ""));
		//System.out.println(rm.matchRegex("ab".toCharArray(), ".*".toCharArray()));
	}
}
