package Graphs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class UndirectedWeightedGraph {

	ArrayList<VertexInt> vertices ;
	java.util.LinkedList<Edge>[] edges;
	
	public UndirectedWeightedGraph(int num)
	{
		this.vertices = new ArrayList<VertexInt>();
		this.edges = new java.util.LinkedList[num];
		for(int i =0; i < num ; i++)
		this.edges[i] = new java.util.LinkedList<Edge>();
	}
	
	public void addEdge(VertexInt v1, VertexInt v2, int weight)
	{
		Edge e1 = new Edge(v1, v2, weight);
		Edge e2 = new Edge(v2, v1, weight);
		int index = vertices.indexOf(v1);
		edges[index].add(e1);
		index = vertices.indexOf(v2);
		edges[index].add(e2);
	}
	
	public Edge getEdge(VertexInt v1, VertexInt v2)
	{
		int index = vertices.indexOf(v1);
		for(Edge e : edges[index])
		{
			if(e.endPoint2.equals(v2)) return e;
		}
		return null;
	}
	
	public java.util.LinkedList<Edge> getEdge(VertexInt v)
	{
		return edges[vertices.indexOf(v)];
	}
	public List<Edge> getAllEdges()
	{
		List<Edge> list = new ArrayList<Edge>();
		for(LinkedList<Edge> lle : edges)
		{
			Iterator<Edge> it = lle.iterator();
			while(it.hasNext())
			{
				Edge e = it.next();
				if(vertices.indexOf(e.endPoint1) > vertices.indexOf(e.endPoint2)) list.add(e);
			}
		}
		return list;
	}
}