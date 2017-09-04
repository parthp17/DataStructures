package LeetCode;

public class BurstBallon {

	class Tuple2{
		int val;
		int index;
	}
	public int maxBurstValue(int[] arr)
	{
		if(arr == null || arr.length == 0) return 0;
		Tuple2[][] matrix = new Tuple2[arr.length][arr.length];
		for(int l = 1; l <= matrix[0].length; l++) // different sub arrays of length 1 to max
		{
			for(int i = 0; i <= matrix[0].length - l ; i++ ) // for subarrays of given length, i points to row as well as start of subarray
			{
				int j = i+l-1; // i is starting of subarray and j is ending index of subarray
				for(int k=i;k <= j; k++)
				{
					int before = k == i ? 0 : matrix[i][k-1].val;
					int after = k == j ? 0 : matrix[k+1][j].val;
					matrix[i][j] = matrix[i][j] == null ? new Tuple2() : matrix[i][j];
					int lBoundary = i == 0? 1 : arr[i-1];
					int rBoundary = j == (arr.length-1) ?1 : arr[j+1];
					int val = after + before +  (lBoundary * rBoundary * arr[k]);
					matrix[i][j].val = Math.max(val,  matrix[i][j].val);
					matrix[i][j].index = matrix[i][j].val == val ? k : matrix[i][j].index; 
				}
			}
		}
		return matrix[0][arr.length-1].val;
	}
	
	public static void main(String[] args) {
		BurstBallon bb = new BurstBallon();
		System.out.println(bb.maxBurstValue(new int[]{3,1,5,8}));
	}
}
