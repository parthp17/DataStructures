package LeetCode;

public class PalindromeNumber {

	public boolean isPalindrome(int num)
	{
		if(num < 0 || (num!= 0 && num%10 == 0)) return false;
		
		int reverse = 0;
		while(num > reverse)
		{
			reverse = reverse*10 + num%10;
			num /= 10;
		}
		
		return num == reverse || num == reverse/10;
	}
	public static void main(String[] args) {
		
		PalindromeNumber pn  = new PalindromeNumber();
				System.out.println(pn.isPalindrome(1751));
	}
}
