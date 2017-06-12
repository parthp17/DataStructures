package Graphs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimsMST {
	
//undirectedweightedgraph
//map
//PrimsBMH
	
	HashMap<VertexInt,Edge> resultMap;
	PrimsBMH minHeap;
	
	public PrimsMST()
	{
		resultMap = new HashMap<VertexInt,Edge>();
		minHeap = new PrimsBMH();
	}
	
	public List<Edge> minSpanTree(UndirectedWeightedGraph uwg)
	{
		List<Edge> mst = new ArrayList<Edge>();
		
		for(VertexInt v : uwg.vertices)
		{
			minHeap.add(v,Integer.MAX_VALUE);
		}
		
		VertexInt startingVertex = uwg.vertices.iterator().next();
		
		minHeap.decrease(startingVertex, 0);
		
		while(!minHeap.isEmpty())
		{
			VertexInt current = minHeap.extractMin().key;
			Edge mstEdge = resultMap.get(current);
			if(mstEdge != null)
			{
				mst.add(mstEdge);
			}
			
			for(Edge e : uwg.getEdge(current))
			{
				VertexInt remote = getVertexForEdge(current, e);
				if(minHeap.contains(remote) && minHeap.getWeight(remote) > e.weight)
				{
					minHeap.decrease(remote,e.weight);
					resultMap.put(remote, e);
				}
			}
		}
		return mst;
	}
	
	private VertexInt getVertexForEdge(VertexInt v , Edge e)
	{
		return e.endPoint1 == v? e.endPoint2 : e.endPoint1;
	}
	
	public static void main(String[] args)
	{
		UndirectedWeightedGraph uwg = new UndirectedWeightedGraph(6);
		
		VertexInt v1 = new VertexInt(1);
		VertexInt v2 = new VertexInt(2);
		VertexInt v3 = new VertexInt(3);
		VertexInt v4 = new VertexInt(4);
		VertexInt v5 = new VertexInt(5);
		VertexInt v6 = new VertexInt(6);
		
		uwg.vertices.add(v1);
		uwg.vertices.add(v2);
		uwg.vertices.add(v3);
		uwg.vertices.add(v4);
		uwg.vertices.add(v5);
		uwg.vertices.add(v6);
		
		uwg.addEdge(v1, v2, 3);
		uwg.addEdge(v1, v4, 1);
		uwg.addEdge(v2, v3, 1);
		uwg.addEdge(v2, v4, 3);
		uwg.addEdge(v3, v4, 1);
		uwg.addEdge(v3, v5, 5);
        uwg.addEdge(v3, v6, 4);
		uwg.addEdge(v4, v5, 6);
        uwg.addEdge(v5, v6, 2);
        
        
        PrimsMST objPrimsMst = new PrimsMST();
        List<Edge> edges = objPrimsMst.minSpanTree(uwg);
        for(Edge e : edges)
        {
        	System.out.println(e.endPoint1.value + "->" + e.weight+ "->"+e.endPoint2.value);
        }
        
	}
}
