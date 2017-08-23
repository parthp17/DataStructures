package Utilities;

class MaxTime {
	public static void main(String args[]) {
		System.out.println(findTime(5,0,2,4));
	}

	public static String findTime(int a, int b, int c1, int d) {
		
		String s = ""+a+b+c1+d;
		char[] carray = s.toCharArray();
		java.util.Arrays.sort(carray);
		if( carray.length  > 4 || Integer.parseInt(String.valueOf(carray)) > 2359)
			return "NOT POSSIBLE";
		StringBuffer output = new StringBuffer(); 
		if(s.indexOf('2') > -1)
		{
			s = s.substring(0,s.indexOf('2')) + s.substring(s.indexOf('2') +1, s.length());
			output.append('2');
			System.out.println(s);
			for(int i = 3; i >= 0; i--)
			{
				if(s.indexOf(String.valueOf(i)) < 0) continue;
				
				s = s.substring(0,s.indexOf(String.valueOf(i))) + s.substring(s.indexOf(String.valueOf(i)) +1, s.length());
				System.out.println(s);
				output.append(i);
				break;
			}
			System.out.println(output.toString());
		}
		else
		{
			if(s.indexOf('1') > -1)
			{
				s = s.substring(0,s.indexOf('1')) + s.substring(s.indexOf('1') +1, s.length());
				output.append('1');
			}
			else
			{
				s = s.substring(0,s.indexOf('0')) + s.substring(s.indexOf('0') +1, s.length());
				output.append('0');
			}

			char c = carray[carray.length - 1];
			output.append(c);
			if(s.indexOf(c) > -1)
				s = s.substring(0,s.indexOf(c)) + s.substring(s.indexOf(c) +1, s.length());
		}

		output.append(":");
		for(int i = 5; i >= 0; i--)
		{
			if(s.indexOf(String.valueOf(i)) < 0) continue;
			s = s.substring(0,s.indexOf(String.valueOf(i))) + s.substring(s.indexOf(String.valueOf(i)) +1, s.length());
			System.out.println(s);
			output.append(i);
			break;
		}

		output.append(s);
		return output.toString();
	}
}