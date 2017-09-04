package LeetCode;

import java.util.Stack;

public class MaxRectangle {

	 public int maximalRectangle(char[][] mat) {
	        if(mat ==null || mat.length == 0) return 0;
	        int max = Integer.MIN_VALUE;
	        int[][] matrix = new int[mat.length][mat[0].length];
	        for(int i = 0 ; i < matrix.length;i++)
	            for(int j = 0 ; j < matrix[0].length; j++)
	                matrix[i][j] = mat[i][j]-48;
	        
	        int[] arr = new int[matrix[0].length];
	        for(int i = 0; i < matrix.length ; i++)
			{
	        	for(int j = 0; j < matrix[0].length ; j++)
				{
					if(matrix[i][j] != 0)
						arr[j] += matrix[i][j];
					else
						arr[j] = 0;
				}
				Stack<Integer> stack = new Stack<Integer>();
				int k = 0;
				int top;
				while(k < arr.length)
				{
					if(stack.isEmpty() || (arr[k] >= arr[stack.peek()])) 
						stack.push(k++);
					else
					{
						top = stack.pop();
						max = Math.max(max, arr[top]*(stack.isEmpty() ? k : k - stack.peek() -1));
					}
				}
				while(!stack.isEmpty())
				{
					top = stack.pop();
					max = Math.max(max, arr[top]*(stack.isEmpty() ? k : k - stack.peek() -1));
				}
			}
			
			return max;
	    }
	 
	 public static void main(String[] args) {
		 
		char[][] mat = new char[][]{{'1','0','1','0','0'},
									{'1','0','1','1','1'},
									{'1','1','1','1','1'},
									{'1','0','0','1','0'}};
		System.out.println(new MaxRectangle().maximalRectangle(mat));
	}
	
}
