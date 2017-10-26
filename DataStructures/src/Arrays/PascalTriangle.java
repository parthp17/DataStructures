package Arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public List<List<Integer>> generate(int numRows) {
        
		List<List<Integer>> container = new ArrayList<>();
		List<Integer> ls = new ArrayList<>();
		if(numRows < 1) return container;
		ls.add(1);
		container.add(ls);
		for(int i = 1; i < numRows; i++)
		{
			ls = new ArrayList<>();
			ls.add(container.get(i-1).get(0));
			for(int j = 0 ; j < i-1; j++ )
			{
				ls.add(container.get(i-1).get(j) + container.get(i-1).get(j+1));
			}
			ls.add(container.get(i-1).get(container.get(i-1).size()-1));
			container.add(ls);
		}
		return container;
    }
	
	public static void main(String[] args) {
		
		PascalTriangle pt = new PascalTriangle();
		
		pt.generate(5).forEach(System.out::println);
	}
}