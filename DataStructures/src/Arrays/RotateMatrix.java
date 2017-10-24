package Arrays;

public class RotateMatrix {

	
	public void rotateRight(int[][] matrix) {
		int temp;
		for(int i = 0; i < matrix.length/2 ; i++)
		{
			for(int j = i; j < matrix[0].length -i -1; j++){
			
				temp = matrix[i][j];
				matrix[i][j] = matrix[matrix.length - 1 - j][i];
				matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
				matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - i];
				matrix[j][matrix.length - 1 - i] = temp;
			}
		}
    }
	
	public static void main(String[] args) {
		
		RotateMatrix rm = new RotateMatrix();
		int[][] matrix = new int[][]{
	        {1, 2, 3, 4},
	        {5, 6, 7, 8},
	        {9, 10, 11, 12},
	        {13, 14, 15, 16}
	    };
		rm.rotateRight(matrix);
		for(int[] arr : matrix)
		{
			System.out.println("");
			for(int i : arr)
				System.out.print(" " + i);
		}
	}
}
