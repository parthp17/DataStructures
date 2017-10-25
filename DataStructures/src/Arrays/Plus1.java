package Arrays;

public class Plus1 {

	public int[] plus1(int[] digits)
	{
		 int carry = 1;
	        int i = digits.length-1;
	        do{
	            
	            digits[i] += carry;
	            carry = digits[i]/10;
	            digits[i] %= 10;
	            i--;
	            
	        }while(i >= 0 && carry == 1);
	        
	        if(carry == 1 && i < 0)
	        {
	            digits = new int[digits.length + 1];
	            digits[0] = 1;
	        }   
	        
	        return digits;
	}
}
