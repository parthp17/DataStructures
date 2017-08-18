package BitManipulation;

public class BitManipulation {

	public static int count1s(int num)
	{
		int count = 0;
		while(num > 0)
		{
			count++;
			num = num & num-1;
		}
		return count;
	}
	
	public static boolean isOdd(int num)
	{
		return ((num & -num) == 1);
	}
	
	public static boolean isEven(int num)
	{
		return ((num & -num) == 0);
	}
	
	public static boolean equals(int i1,int i2)
	{
		return (i1^i2) == 0;
	}
	
	public static int multipleBy2(int num)
	{
		return num << 1;
	}
	
	public static boolean isKthBitSet(int num , int k)
	{
		//return ((num >> (k-1)) & 1) == 1;
		return (1 << k & num) == 1;
	}
	
	public static int setKthBit(int num, int k)
	{
		return (1 << (k)) | num;
	}
	
	public static int clearkthBit(int num , int k)
	{
		return (~( 1 << (k))) & num;
	}
	
	public static int toggleKthBit(int num, int k)
	{
		return num^(1 << (k));
	}
	
	public static int togglerRightMostBit(int num)
	{
		return num & num -1;
	}
	
	public static int findRightMostBitSet(int num)
	{
		int count =0;
		while((num & 1) != 1)
		{
			count++;
			num = num >> 1;
		}
		return count;	
	}
	
	public static int findRightMostClearedBit(int num)
	{
		int count = 0;
		
		while((num & 1) != 0)
		{
			count++;
			num = num >> 1;	
		}
		return count;
	}
	
	public static int swapOddEvenBits(int num)
	{
		int oddPart = num & 0x55;
		int evenPart = num & 0xAA;
		
		evenPart >>=1;
		oddPart <<= 1;
		return oddPart | evenPart;
		
	}
	
	public static void main(String[] args)
	{
		System.out.println(count1s(3));
	}
}
