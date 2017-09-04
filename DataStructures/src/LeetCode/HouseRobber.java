package LeetCode;

public class HouseRobber {

	public int rob(int num[])
	{
		int prevM = 0;
		int currM = 0;
		int temp = 0;
		for(int i : num)
		{
			temp = currM;
			currM = Math.max(prevM + i, currM );
			prevM = temp;
		}
		return currM;
	}
	
	public static void main(String[] args) {
		
		System.out.println(new HouseRobber().rob(new int[]{2,1,3,5,7,3,12,1,2}));
	}
}
