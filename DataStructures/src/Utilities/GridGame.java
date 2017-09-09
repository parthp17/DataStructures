package Utilities;

public class GridGame {

	static long countX(String[] s)
	{
		int minR = 1000000, minC = 1000000;
		for(String s1 : s)
		{
			String[] arr = s1.split(" ");
			if(arr.length ==2 && arr[0] != null && !arr[0].isEmpty() && arr[1] != null && !arr[1].isEmpty())
			{
				minR = Math.min(minR, Integer.parseInt(arr[0]));
				minC = Math.min(minC, Integer.parseInt(arr[1]));
			}
		}
		return minR*minC;
		
		
	}
	public static void main(String[] args) {
		
		System.out.println(countX(new String[]{"2 3","3 7","4 1"}));
		//System.out.println(countX(new String[]{"4 3", "1 2", "1 3", "1 4", "5 6", "2 10", "3 10", "4 10", "2 11", "3 12", "4 11", "1 12", "3 12"}));
		
	}
	
}
