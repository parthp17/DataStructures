package Rough;

import java.util.regex.Pattern;

public class RoughWork {

	public static void main(String[] args) {
		System.out.println(func(args[0]));
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
}
