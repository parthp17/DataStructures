package LeetCode;

public class ReverseInteger {

public static int reverse(int x) {
        
        int result = 0;
        
        while(x != 0)
        {
        	int newResult = result*10 + x%10;
            if ((newResult - x%10) / 10 != result)
            { return 0; }
            result = newResult;
            x /=10;
        }
        return result;
    }

public static void main(String[] args) {
	
	System.out.println(reverse(123456789));
	
}

}
