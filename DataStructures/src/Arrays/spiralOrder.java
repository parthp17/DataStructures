package Arrays;

import java.util.ArrayList;
import java.util.List;

public class spiralOrder {

	public List<Integer> spiralOrder(int[][] matrix) {
        
		List<Integer> ls = new ArrayList<>();
        if(matrix==null || matrix.length == 0) return ls;
        int c1 = 0, c2 = matrix[0].length-1;
        int r1 = 0, r2 = matrix.length-1;
        
        
        while(r1 <= r2 && c1 <= c2)
        {
            int i = r1, j = c1 ;
        	for(j = c1; j <= c2;j++)
        		ls.add(matrix[i][j]);
        	for(i = r1+1, j--; i <= r2; i++ )
        		ls.add(matrix[i][j]);
        	for(j--, i--; j > c1 && i > r1; j--)
        		ls.add(matrix[i][j]);
        	for(; i > r1 && j >= c1; i--)
        		ls.add(matrix[i][j]);
        	
        	r1++;
        	r2--;
        	c1++;
        	c2--;
        }
        return ls;
        
    }
	
public int[][] fillSpiralOrder(int n) {
       
	 
    int[][] matrix = new int[n][n];
    if(n < 1) return matrix;
	
	
    int c1 = 0, c2 = n-1;
    int r1 = 0, r2 = n-1;
    int val = 0;
    
    while(r1 <= r2 && c1 <= c2)
    {
        int i = r1, j = c1 ;
    	for(j = c1; j <= c2;j++)
    		matrix[i][j] = ++val;
    	for(i = r1+1, j--; i <= r2; i++ )
    		matrix[i][j] = ++val;
    	for(j--, i--; j > c1 && i > r1; j--)
    		matrix[i][j] = ++val;
    	for(; i > r1 && j >= c1; i--)
    		matrix[i][j] = ++val;
    	
    	r1++;
    	r2--;
    	c1++;
    	c2--;
    }
    return matrix;
        
    }
	
	public static void main(String[] args) {
		
		spiralOrder so =  new spiralOrder();
		int[][] matrix =  new int[][]{{ 1,2,3}}; 
		so.spiralOrder(matrix).forEach(i -> System.out.println(i));
	}
}
