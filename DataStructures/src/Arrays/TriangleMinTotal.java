package Arrays;

import java.util.List;

public class TriangleMinTotal {

	public int minimumTotal(List<List<Integer>> triangle) {
        
        int rows = triangle.size();
        
        for(int i = rows -2 ; i >= 0; i--)
        {
            for(int j = 0; j <= i; j++)
            {
                int val = triangle.get(i).get(j);
                val += Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
                triangle.get(i).set(j,val);
            }
        }
        return triangle.get(0).get(0);
    }
}
