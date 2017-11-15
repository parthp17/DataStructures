package Arrays;

public class IslandArea {

	public int maxAreaOfIsland(int[][] grid) {
	     
        int max = 0;
        int[][] matrix = new int[grid.length][grid[0].length];
        matrix[0][0] = grid[0][0];
        max = matrix[0][0];
        for(int i =1; i< matrix.length;i++)
            if(grid[i][0] == 1)
            {
            	matrix[i][0] = matrix[i-1][0] + 1;
            	max = max >= matrix[i][0] ? max : matrix[i][0];
            }
        for(int i =1; i< matrix[0].length;i++)
        	if(grid[0][i] == 1)
        	{
        		matrix[0][i] = matrix[0][i-1] + 1;
        		max = max >= matrix[0][i] ? max : matrix[0][i];
        	}
        
        
        for(int i= 1;i < grid.length;i++)
        {
            for(int j=1; j<grid[0].length;j++)
            {
            	if(grid[i][j] == 1)
            	{
            		matrix[i][j] = matrix[i-1][j] + matrix[i][j-1] + 1;
            		if(grid[i-1][j-1] == 1 && grid[i-1][j] == 1 && grid[i][j-1] == 1) matrix[i][j]--;
                	max = max >= matrix[i][j] ? max : matrix[i][j];
            	}
            }
        }
        return max;
    }
	
	public static void main(String[] args) {
		
		IslandArea ia = new IslandArea();
		
		System.out.println(ia.maxAreaOfIsland(new int[][]{
			{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}
		}));
		;
	}
}
