package LeetCode;

public class ContainerWithMostWater {

	public int containWater(int [] arr)
	{
		int i = 0;
		int j = arr.length-1;
		int maxArea = 0;
		while(i < j)
		{
			int newArea;
			if(arr[i] > arr[j])
			{
				newArea = (j-i)*(arr[j]);
				j--;
			}
			else
			{
				newArea = (j-i)*(arr[i]);
				i++;
			}
			maxArea = maxArea > newArea ? maxArea : newArea; 
		}
		return maxArea;
	}
	
	public static void main(String[] args) {
		
		System.out.println(new ContainerWithMostWater().containWater(new int[]{}));
	}
}
