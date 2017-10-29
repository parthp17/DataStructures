package String;

import java.util.Arrays;

public class CountAndSay {

	public String countAndSay(int n) {
  
		StringBuilder sb1 = new StringBuilder("1");
		StringBuilder sb2 = new StringBuilder();
		StringBuilder current = sb2;
		StringBuilder prev = sb1;
		for(int i= 1; i < n ; i++)
		{
			
			for(int j = 0; j < prev.length(); )
			{
				char c = prev.charAt(j);
				int count  = 0;
				while(j < prev.length() && c == prev.charAt(j))
				{
					count++;
					j++;
				}
				current.append(count).append(prev.charAt(j-1));
			}
			prev.setLength(0);
			current = current == sb2 ? sb1 :sb2;
			prev = prev == sb2 ? sb1 :sb2;
		}
		return prev.toString();
    }
	
	public static void main(String[] args) {
		
		CountAndSay cas = new CountAndSay();
		System.out.println(cas.countAndSay(4));
	}
}
