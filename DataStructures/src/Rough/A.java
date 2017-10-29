package Rough;

import java.util.Arrays;
import java.util.Comparator;

public class A implements Comparator<A>{
	int val;
	
	A(){}
	A(int val)
	{
		this.val= val;
	}
	
	@Override
	public int compare(A o1, A o2) {
		return o2.val - o1.val;
	}
	
	public static void main(String[] args) {
		
		try{
			int x = 0;
			for(x = 1; x<4;x++);
			System.out.println(x);
		}finally{
			System.out.println("error");
		}
	}
	

}

class B extends A{
	
}

class C extends A{
	
}