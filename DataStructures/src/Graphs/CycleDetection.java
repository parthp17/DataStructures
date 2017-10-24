package Graphs;

import java.util.List;

public class CycleDetection {

	/*
	 * Cycle detection by Depth First Search
	 */
	public boolean isCyclic(UndirectedWeightedGraph uwg){
		boolean bVal = false;
		VertexInt v = uwg.vertices.get(0);
		v.visited = true;
		return isCyclic(uwg,v, null);
	}
	
	private boolean isCyclic(UndirectedWeightedGraph uwg, VertexInt v, VertexInt parent){
		v.visited = true;
		List<Edge> ls= uwg.getEdge(v);
		boolean bVal = false;
		for(Edge e : ls)
		{
			VertexInt v1 = e.endPoint1 == v ? e.endPoint2 : e.endPoint1;
			if(v1 == parent) continue;
			if(v1.visited == false && !bVal)
			{
				bVal = isCyclic(uwg, v1, v);
			}
			else
			{
				return true;
			}
		}
		return bVal;
	}
	
	/*
	 * Cycle detection by DisJoint Sets
	 */
	
	public boolean hasCycle(UndirectedWeightedGraph uwg)
	{
		DisJointSet djs = new DisJointSet();
		for(VertexInt v : uwg.vertices) djs.makeSet(v.value);
		for(Edge e : uwg.getAllEdges())
		{
			VertexInt v1 = e.endPoint1;
			VertexInt v2 = e.endPoint2;
			
			if(djs.findSet(v1.value) == djs.findSet(v2.value))return true;
			else
				djs.union(v1.value, v2.value);
		}
		return false;
	}
}
