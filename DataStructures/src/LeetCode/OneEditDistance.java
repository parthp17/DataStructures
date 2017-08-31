package LeetCode;

public class OneEditDistance {

public boolean isOneEditDistance(String s, String t) {
    
    if(s == null || t  == null || s.equals(t) || (Math.abs(s.length() - t.length()) > 1)) return false;
    int sLength = s.length();
    int tLength = t.length();
    int length = sLength > tLength ? tLength : sLength;
    String temp = sLength > tLength ? t : s;
    t = temp.equals(s)?t:s;
    
    for(int i= 0; i < length; i ++)
    {
    	if(temp.charAt(i) != t.charAt(i))
    	{
    		if(sLength == tLength) return temp.substring(i+1).equals(t.substring(i+1));
    		else return temp.substring(i).equals(t.substring(i+1));
    	}
    }
    return sLength != tLength;
	
    }
	public static void main(String[] args) {
		System.out.println(new OneEditDistance().isOneEditDistance("ba", "a"));
	}
}
