package Utilities;

public class BinaryMinMovesSAP {

	static int minMoves(int[] avg) {

    int len = avg.length;
    
    int zLeft = 0;
    int zRight =0;
    int left = 0, right = 0;
    for(int i =0 ;i < avg.length;i++)
    {
    	if(avg[i]==0)
    	{
    		zLeft++;
    	}
    	else
    	{
    		left += zLeft;
    	}
    	
    	if(avg[len -1-i] == 0)
    	{
    		zRight++; 
    	}
    	else
    	{
    		right += zRight;
    	}
    }
    return Math.min(left, right);
    }
	
	public static void main(String[] args) {
		
		System.out.println(BinaryMinMovesSAP.minMoves(new int[]{1,1,1,1,0,1,0,1}));
	}
}
