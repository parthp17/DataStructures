package Graphs;

import java.util.ArrayList;

public class DirectedWeightedGraph extends UndirectedWeightedGraph{

	public DirectedWeightedGraph(int num) {
		super(num);
	}
	
	public void addEdge(VertexInt v1, VertexInt v2, int weight)
	{
		Edge e1 = new Edge(v1, v2, weight);
		int index = vertices.indexOf(v1);
		edges[index].add(e1);
	}
}
