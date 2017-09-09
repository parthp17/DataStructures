package Utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindSubstring {

	static int firstOccurrence(String s, String x) {

		x = x.replace("*", ".");
		Matcher m = Pattern.compile(x).matcher(s);
		if(m.find())
		{
			return m.start();
		}
		return -1;
		
    }
	
	public static void main(String[] args) {
		
		System.out.println(firstOccurrence("juliasamanthantjulia", "ant"));
	}
}
