package Rough;

import java.util.regex.Pattern;

public class RoughWork {

	public static void main(String[] args) {
		//System.out.println(reverseWords("ssdsdsd"));
        int a = 2437;
        int b = 875;
        int x = a;
        int y = b;

        while(true)
        {
            if(x > y){
                x = x-y;
            }
            else if (x < y){
                y = y-x;
            }
            else break;
        }

        System.out.println(x + " " + y);

	}
	
	public static boolean func(String args)
	{
		/*System.out.println(args.length());
		System.out.println(args.toCharArray().length);
		System.out.println("Pக¾r�");
		for(int i = 0; i < "Pக¾r�".length(); i++)
		{
			System.out.println((long)args.charAt(i));
			if( args.charAt(i) < 0 || args.charAt(i) > 65536) return false;
		}
		return true;*/
		
		return Pattern.compile("([\\p{N}\\p{P}\\p{Z}\\p{L}\\p{M}*]+){1,100}").matcher("Nice work!".toString()).matches();




	}
	
		static public String reverseWords(String s) {
        if(s == null || s.length() == 0 || s.length() == 1) return s;
        s= "    ";
        String[] arr = s.split("\\s");
        if(arr.length == 0) return s;
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length-1 ; i >= 0;i--)
        {
            System.out.println(arr[i]+ i);
            sb.append(arr[i]+ " ");
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }
}
