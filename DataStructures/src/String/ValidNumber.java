package String;

import java.util.regex.Pattern;

public class ValidNumber {

	public boolean isNumber(String s) {
    
		s = s.trim();
		Pattern p = Pattern.compile("^(\\+|-)?(\\d+(\\.\\d*)?|\\.\\d+)|(e(\\+|-)?\\d+)?$");
		return p.matcher(s).matches();
    }
	
	public static void main(String[] args) {
		ValidNumber vn = new ValidNumber();
		
		System.out.println(vn.isNumber(".1"));
	}
}
