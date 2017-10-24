package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class KruskalsMST {

	public List<Edge> getMST(UndirectedWeightedGraph uwg)
	{
		
		List<Edge> allEdges = uwg.getAllEdges();
		
		Collections.sort(allEdges, (e1,e2) -> {return e1.weight - e2.weight;});
		DisJointSet ds = new DisJointSet();
		
		for(VertexInt v : uwg.vertices)
			ds.makeSet(v.value);
		
		List<Edge> result= new ArrayList<Edge>();
		
		for(Edge e : allEdges)
		{
			int parent1 = ds.findSet(e.endPoint1.value);
			int parent2 = ds.findSet(e.endPoint2.value);
			
			if(parent1 == parent2)
			{
				continue;
			}
			else
			{
				result.add(e);
				ds.union(e.endPoint1.value, e.endPoint2.value);
			}
		}
		
		return result;
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
        
        
        KruskalsMST objPrimsMst = new KruskalsMST();
        List<Edge> edges = objPrimsMst.getMST(uwg);
        for(Edge e : edges)
        {
        	System.out.println(e.endPoint1.value + "->" + e.weight+ "->"+e.endPoint2.value);
        }
	}
}