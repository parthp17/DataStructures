package String;

import java.util.ArrayList;
import java.util.List;

public class GenerateIP {

	public List<String> restoreIpAddresses(String s) {
     
		List<String> ips = new ArrayList<>();
		if(s.length() < 4 || s.length() > 12) return ips;
		
		for(int i = 1 ; i <= 3; i++ )
		{
			
			String s1 = s.substring(0,i);
			if(s1.startsWith("0") && s1.length() > 1) continue;
			int p1 = Integer.parseInt(s1);
			if(p1 < 256)
				restoreIpAddresses(s.substring(i), s1, ips, 1);
		}
		return ips;
    }
	
	public void restoreIpAddresses(String s, String t, List<String> ips, int level) {

		if( level > 4) return;
		if(level == 4 )
		{
			if(s.length() == 0)
			ips.add(t);
			else
				return;
		}
		
		for(int i = 1 ; i <= 3 && i <= s.length(); i++ )
		{
			
			String s1 = s.substring(0,i);
			if(s1.startsWith("0") && s1.length() > 1) continue;
			int p1 = Integer.parseInt(s1);
			if(p1 < 256)
				restoreIpAddresses(s.substring(i), t+"." + s1, ips, level + 1);
		}
    }
	
	public static void main(String[] args) {
		GenerateIP ips = new GenerateIP();
		ips.restoreIpAddresses("25525511135").stream().forEach(System.out::println);
	}
}
