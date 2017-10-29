package String;

public class StringMultiplication {

	public String multiple(String s1, String s2)
	{
		int l1 = s1.length();
		int l2  = s2.length();
		int[] arr = new int[l1+l2];
		
		for(int i = l1 -1; i >= 0; i--)
		{
			for(int j = l2 -1 ; j >= 0; j--)
			{
				
				int p1 = i + j;
				int  p2 = i+j+1;
				int mul = (s1.charAt(i)-'0') * (s2.charAt(j)-'0');
				int sum = mul + arr[p2];
				
				arr[p2] = sum%10;
				arr[p1] += sum/10; 
			}
		}
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while(i < arr.length && arr[i] == 0)i++;
		for(; i < arr.length; )
			sb.append(arr[i++]);
		
		
		return sb.toString().equals("") ? "0" : sb.toString();
	}
	
	public static void main(String[] args) {
		
		StringMultiplication sm = new StringMultiplication();
		System.out.println(sm.multiple("0", "0"));
	}
}
