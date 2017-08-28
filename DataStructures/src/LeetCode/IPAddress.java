package LeetCode;

import java.util.regex.Pattern;

public class IPAddress {

	enum TYPE{
		 IPv4,IPv6,Neither
	};
	
	public String validIPAddress(String IP) {
    
		if(IP ==null || IP.isEmpty()) return "Neither";
		if(IP.matches("(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])"))return "IPv4";
        if(IP.matches("(([0-9a-fA-F]{1,4}):){7}([0-9a-fA-F]{1,4})"))return "IPv6";
		return "Neither";
		
    }
	public static void main(String[] args) {
		System.out.println(new IPAddress().validIPAddress("2001:0db8:85a3:1:0:8A2E:0370:7334"));
		
	}
	
}
