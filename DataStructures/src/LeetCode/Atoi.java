package LeetCode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Atoi {

	//number's ASCII is 48 to 57
	
	/*public int myAtoi(String s)
	{
		if(s == null || s.isEmpty())return 0;
		s = s.trim();
		if(s.isEmpty()) return 0;
		String regex = "^[+-]?\\d+";

		Matcher matcher = Pattern.compile(regex).matcher(s); 
		if(matcher.find())
		{
			s = s.substring(matcher.start(), matcher.end());
			int len = s.length();
			 char flag = '+';
		     int i = 0;
		     if (s.charAt(0) == '-') {
		         flag = '-';
		         i++;
		     } else if (s.charAt(0) == '+') {
		         i++;
		     }
		     int val = 0;
		     int max = Integer.MAX_VALUE/10;
		     int mod = Integer.MAX_VALUE%10;
		     while(i < len)
		     {
		    	 if(max < val || (max == val && mod < (s.charAt(i) - '0')))
		    	 {
		    		 return flag == '+' ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		    	 }
		    	 val = val*10 + (s.charAt(i) - '0');
		    	 i++;
		     }
		     if(flag == '-') val *= -1;
		     return val;
		}
		else
		{
			System.out.println("not a regex match");
			return 0;
		}
	}*/

	public int myAtoi(String str) {
	       
	      if (str == null || str.length() < 1)
	          return 0;
	   
	      
	      str = str.trim();
	   
	      char flag = '+';
	   
	     // check negative or positive
	     int i = 0;
	     if (str.charAt(0) == '-') {
	         flag = '-';
	         i++;
	     } else if (str.charAt(0) == '+') {
	         i++;
	     }
	    
	     int result = 0;
	  
	     // calculate value
	     while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
	         if(Integer.MAX_VALUE/10 < result || (Integer.MAX_VALUE/10 == result && Integer.MAX_VALUE%10 < (str.charAt(i) - '0'))) 
	             return flag == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
	             
	         result = result * 10 + (str.charAt(i) - '0');
	         i++;
	     }
	  
	     if (flag == '-')
	         result = -result;
	  
	     return result;
	    }
	
	public static void main(String args[])
	{
		Atoi atoi = new Atoi();
		System.out.println(atoi.myAtoi("   -2147483649r4"));
	}
}
