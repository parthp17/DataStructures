package LeetCode;

public class ZigZagConvesion {

	public String zigZagConversion(String s, int row)
	{
		if(s == null ||s.isEmpty()) return s;
		StringBuilder[] sb = new StringBuilder[row];
		for(int i = 0 ; i < row; i++)
			sb[i] = new StringBuilder();
		int len = s.length();
		int ptr = 0;
		int i;
		while(ptr < len)
		{
			for(i = 0 ; i < row && ptr < len; i++, ptr++)
			{
				sb[i].append(s.charAt(ptr));
			}
			i-=2;
			for(;i > 0 && ptr < len; i--, ptr++)
			{
				sb[i].append(s.charAt(ptr));
			}
		}
		String result = "";
		for(StringBuilder sb1 : sb )
			result += sb1.toString();
		return result;
	}
	
	public static void main(String[] args) {
		ZigZagConvesion zzc = new ZigZagConvesion();
		System.out.println(zzc.zigZagConversion("PAYPALISHIRING", 3));
	}
}
