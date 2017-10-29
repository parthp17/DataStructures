package String;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
	static Map<Character, Integer> values = new HashMap<>();
	public RomanToInt() {
		values.put('I', 1);
		values.put('V', 5);
		values.put('X', 10);
		values.put('L', 50);
		values.put('C', 100);
		values.put('D', 500);
		values.put('M', 1000);
	}
	
	public int romanToInt(String s){
		if(s == null || s.length() == 0) return 0;
		s = s.toUpperCase();
		
		values.put('I', 1);
		values.put('V', 5);
		values.put('X', 10);
		values.put('L', 50);
		values.put('C', 100);
		values.put('D', 500);
		values.put('M', 1000);
		
		int slen = s.length();
		
		char maxUntillNow = s.charAt(slen - 1);
		int val = values.get(maxUntillNow);
		if(slen > 1)
		{
			for(int i = slen -2 ; i >= 0; i--)
			{
				char c = s.charAt(i);
				char p = s.charAt(i+1);
				
				if(values.get(c) < values.get(p))
				{
					val -= values.get(c);
				}
				else{
					val += values.get(c);
				}
			}
		}
		
		return val;
	}
	
	public String intToRoman(int n)
	{
		if(n < 1) return "";
		int pow = 0;
		String rVal = "";
		while(n > 0)
		{
			int d = n%10;
			rVal = getToken(d, pow) + rVal;
			n /= 10;
		}
		return rVal;
	}
	
	private String getToken(int val, int pow)
	{
		if(values.containsKey(val*(Math.pow(10, pow))))
		{
			return values.get(val*(Math.pow(10, pow))).toString();
		}
		else if(values.containsKey((val + 1)*(Math.pow(10, pow))))
		{
			return values.get((int)Math.pow(10, pow)).toString() + values.get(val*(Math.pow(10, pow))).toString();
		}
		else
		{
			String r = "";
			if(val / 5 > 0)
			{
				r += values.get(5*(Math.pow(10, pow))); 
			}

			for(int i = 0; i < 3 ; i++)
				r += values.get(Math.pow(10, pow));
			return r;
		}
	}
	
	
	public static void main(String[] args) {
		
		RomanToInt rtoi = new RomanToInt();
//		System.out.println(rtoi.romanToInt("LXIX"));
		System.out.println(rtoi.intToRoman(59));
		
	}
	
	
}
