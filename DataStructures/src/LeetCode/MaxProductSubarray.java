package LeetCode;

public class MaxProductSubarray {

	public int maxProduct(int[] arr)
	{
		int maxProd = Integer.MIN_VALUE;
		int max = arr[0];
		int min = arr[0];
		for(int i = 1 ; i < arr.length; i++)
		{
			int temp = max;
			max = Math.max(max * arr[i] , min * arr[i]);
			max = Math.max(max, arr[i]);
			min = Math.min(temp* arr[i], min* arr[i]);
			min = Math.min(min, arr[i]);
			if(maxProd < max) maxProd = max;
		}
		return maxProd;
	}

	public static void main(String[] args) {
		System.out.println(new MaxProductSubarray().maxProduct(new int[]{-2,0,-1}));
	}
}
