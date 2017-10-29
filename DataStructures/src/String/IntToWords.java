package String;

public class IntToWords {

	 private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	    private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	    private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	    
	    public String numberToWords(int num) {
	        if (num == 0) return "Zero";
	        StringBuilder sb = new StringBuilder();
	        helper(num,sb);
	        return sb.toString().trim();
	    }
	    
	    private void helper(int num, StringBuilder sb) {
	        
	        if (num < 10) sb.append(belowTen[num]);
	        else if (num < 20) sb.append(belowTwenty[num -10]);
	        else if (num < 100) 
	        {
	        	sb.append(belowHundred[num/10] + " ");
	        	helper(num % 10,sb);
	        }
	        else if (num < 1000) {
	        	helper(num/100,sb); 
	        	if(sb.charAt(sb.length()-1) != ' ') sb.append(" ");
	        	sb.append("Hundred ");helper(num % 100,sb);
	        }
	        else if (num < 1000000) {
	        	helper(num/1000,sb);
	        	if(sb.charAt(sb.length()-1) != ' ') sb.append(" ");
	        	sb.append("Thousand ");  helper(num % 1000,sb);
	        }
	        else if (num < 1000000000) {
	        	helper(num/1000000,sb); 
	        	if(sb.charAt(sb.length()-1) != ' ') sb.append(" ");
	        	sb.append("Million ");   helper(num % 1000000,sb);
	        }
	        else {
	        	helper(num/1000000000,sb); 
	        	if(sb.charAt(sb.length()-1) != ' ') sb.append(" ");
	        	sb.append("Billion "); helper(num % 1000000000,sb);
	        }
	        
	    }
	    public static void main(String[] args) {
			
	    	IntToWords itw = new IntToWords();
	    	System.out.println(itw.numberToWords(53));
		}
	    
}
