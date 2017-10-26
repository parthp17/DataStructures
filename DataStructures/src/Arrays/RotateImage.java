package Arrays;

public class RotateImage {

	public void rotate(int[][] matrix) {
        
        int temp =0;
        for(int i = 0; i < matrix.length/2; i++)
        {
            for(int j = i; j < matrix[0].length - i -1; j++)
            {
                temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - j - 1][i];
                matrix[matrix.length - j - 1][i] = matrix[matrix.length - i - 1][matrix.length - j - 1];
                matrix[matrix.length - i - 1][matrix.length - j - 1] = matrix[j][matrix.length - i - 1];
                matrix[j][matrix.length - i - 1] = temp;
            }
        }
    }
	
	public static void main(String[] args) {
		RotateImage ri = new RotateImage();
		ri.rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
	}
}
