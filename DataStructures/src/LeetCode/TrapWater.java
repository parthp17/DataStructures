package LeetCode;

public class TrapWater {

	public int trapWater(int[] arr)
	{
		int leftMax = arr[0];
		int rightMax = arr[arr.length-1];
		int i =0;
		int j = arr.length -1;
		int water = 0;
		while(i < j)
		{
			if(arr[i] <= arr[j])
			{
				leftMax = leftMax > arr[i] ? leftMax : arr[i];
				water += leftMax - arr[i];
				i++;
			}
			else
			{
				rightMax = rightMax > arr[j] ? rightMax : arr[j];
				water += rightMax - arr[j];
				j--;
			}
		}
		return water;
	}
	
	public static void main(String[] args) {
		
		System.out.println(new TrapWater().trapWater(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
	}
}
