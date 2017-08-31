package Graphs;

public class GraphImplementation {

	public static void main(String[] args)
	{
		DirectedUnweightGraph g = new DirectedUnweightGraph(5);
		VertexInt v0 = new VertexInt(0);
		VertexInt v1 = new VertexInt(1);
		VertexInt v2 = new VertexInt(2);
		VertexInt v3 = new VertexInt(3);
		VertexInt v4 = new VertexInt(4);
		g.addVertex(v0);
		g.addVertex(v1);
		g.addVertex(v2);
		g.addVertex(v3);
		g.addVertex(v4);
		 g.addEdge(v0, v1);
	     g.addEdge(v0, v2);
	     g.addEdge(v1, v2);
	     //g.addEdge(v2, v0);
	     g.addEdge(v2, v3);
	     //g.addEdge(v3, v3);
	     g.addEdge(v4, v3);
	     
	     //System.out.println(g.doesRouteExsists(v0, v4));
	     //g.doDFS(v0);
	     //g.doBFS(v0);
	    // System.out.println(g.isCyclic());
	     //g.doTopologicalSort();
	}
	
	
}
