package SearchigAlgorithm;

public class Smallestand2ndSmallest {

	public static int[] find(int[] arr)
	{
		if(arr == null || arr.length < 2) return null;
		
		int smallest = Integer.MAX_VALUE;
		int secondSmallest = Integer.MAX_VALUE;
		
		for(int i : arr)
		{
			if(i < smallest)
			{
				secondSmallest = smallest;
				smallest = i;
				
			}
			else if(i < secondSmallest) secondSmallest = i;
		}
		
		return new int[]{smallest,secondSmallest};
		
	}
	
}
