package Utilities;

import java.util.ArrayList;
import java.util.List;

public class FormatString {


	public String formaString(String input, String[] arr)
	{
		
		if(input == null || arr == null || input.length() == 0 || arr.length == 0) return "";
		
		
		String[] sarr = input.split(" ");
		StringBuilder sb = new StringBuilder();
		for(String s : sarr )
		{
			if(s.contains("{") && s.contains("}"))
			{
				int index = Integer.parseInt(s.substring(1, s.length()-1));
				if(index > arr.length-1) new RuntimeException();
				sb.append(arr[index]);
				sb.append(" ");
			}
			else
			{
				sb.append(s);
				sb.append(" ");
			}
		}
		
		sb.setLength(sb.length()-1);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		FormatString s = new FormatString();
		s.fibo();
		//System.out.println(s.formaString("{0} and {2} or {1}", new String[]{"A","B","C"}));
	}
	
	public void fibo()
	{
		List<Integer> ls = new ArrayList<>();
		ls.add(1);
		ls.add(1);
		System.out.println(ls.get(0));
		System.out.println(ls.get(1));
		
		fibo(1,ls);
	}
	
	private void fibo(int i, List<Integer> ls)
	{
		if(ls.get(i) + ls.get(i-1) < 1000 )
		{
			int val = ls.get(i) + ls.get(i-1);
			ls.add(val);
			System.out.println(val);
			fibo(i+1,ls);
		}
	}
	
}
