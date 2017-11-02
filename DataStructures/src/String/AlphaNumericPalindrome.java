package String;

public class AlphaNumericPalindrome {

	public boolean isPalindrome(String s) {
	     
        int i = 0 ;
        int j = s.length()-1;
        
        while(i < j)
        {
            while(i < s.length() && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while(j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if(i < j && (s.substring(i,i+1).equalsIgnoreCase(s.substring(j,j+1))))
            {
                i++;
                j--;
                continue;
            }
            else if(i >= j) return true;
            else
            return false;
        }
        return true;
    }
}
