package String;

public class DistinctSubsequence {

	public int numDistinct(String s, String t) {
    
		/*if(s == null || t == null || s.length() < t.length()) return -1;
		int[] count = new int[1];
		numDistinct(s, t, 0, 0, count);
		return count[0];*/
		if(s == null || t == null || s.length() < t.length()) return 0;
		int[][] matrix = new int[s.length()+1][t.length()+1];
		for(int i = 0 ;i <matrix.length ; i++ )
			matrix[i][0] = 1;
		for(int i = 1; i < matrix.length; i++)
		{
			for(int j = 1; j< matrix[0].length; j++)
			{
				matrix[i][j] = matrix[i-1][j];
				if(s.charAt(i-1) == t.charAt(j-1))
					matrix[i][j] += matrix[i-1][j-1];
			}
		}
		return matrix[matrix.length-1][matrix[0].length-1];
    }
	
	private void numDistinct(String s, String t, int i, int j, int[] count)
	{
		if( j == t.length())
		{
			count[0]++;
			return;
		}
		if( i == s.length())
			return;
		if(s.charAt(i) == t.charAt(j))
			numDistinct(s, t, i+1, j+1, count);
		
		numDistinct(s, t, i+1, j, count);
		
	}
	
	public static void main(String[] args) {
		
		DistinctSubsequence ds= new DistinctSubsequence();
		System.out.println(ds.numDistinct("rabbbit", "rabbit"));
	}
}
