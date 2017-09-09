package Utilities;

import java.util.Arrays;

public class ReducedFractionSums {

	static String[] reducedFractionSums(String[] expressions)
	{
		if(expressions == null) return null;
		String[] sarr = new String[expressions.length];
		for(int i = 0; i < expressions.length; i++)
		{
			String[] arr = expressions[i].split("[+/]");
			int n0= Integer.parseInt(arr[0]);
			int n1= Integer.parseInt(arr[1]);
			int n2= Integer.parseInt(arr[2]);
			int n3 = Integer.parseInt(arr[3]);
			int lcm = ( n1 > n3)? n1 : n3;
			while(true)
			{
				if( lcm % n1 == 0 && lcm % n3 == 0)break;
				lcm++;
			}
			long n = n0 * (lcm / n1) + n2 * (lcm / n3);
			long hcf = 1;
            
            for(long j=Math.min(n,lcm); j >= 1; j--)
            {
                if(n%j == 0 && lcm%j == 0)
                {
                    hcf = j;
                    break;
                }
            }        
            sarr[i] = "" + (n/hcf) + "/" + (lcm/hcf);
		}
		return sarr;
	}
	
	public static void main(String[] args) {
		
		String[] exp = new String[]{
				"722/148+360/176"
				,"978/1212+183/183"
				,"358/472+301/417"
				,"780/309+684/988"
				,"258/840+854/686"
		};
		String[] sarr = reducedFractionSums(exp);
		Arrays.stream(sarr).forEach(System.out::println);
	}
	
}
