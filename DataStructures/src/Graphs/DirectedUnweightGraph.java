package Graphs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class VertexInt{
	int value;
	boolean visited = false;
	public VertexInt(int val)
	{
		this.value = val;
	}
	public VertexInt()
	{
		
	}
}

class Edge{
	
	int weight;
	VertexInt endPoint1;
	VertexInt endPoint2;
	
	public Edge(VertexInt ep1, VertexInt ep2, int weight)
	{
		this.endPoint1 = ep1;
		this.endPoint2 = ep2;
		this.weight = weight;
	}
}

class EdgeComparator implements Comparator<Edge>
{

	@Override
	public int compare(Edge e1, Edge e2) {
			return e1.weight-e2.weight;
	}
}

/*class Edge<V>{
	Vertex<V> start, end;
	int weight;
	
	public Edge(Vertex<V> start, Vertex<V> end, int weight)
	{
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	
	public Vertex<V> getAdjacent(Vertex<V> v) {
		if(v == null)
			return null;
		else if(v == start)
			return end;
		else if(v == end)
			return start;
		else
			return null;
	}
}*/

public class DirectedUnweightGraph {

	/*
	 * Directed weighted graph(n(n-1)/2 edges)(space: n +3e, n^2)
	 * Directed unweighted graph(space: n +2e, n^2)
	 * Undirected weighted graph(symmetric across matrix diagonal) (n(n-1) edges)(space: n +6e, n^2)
	 * undirected unweighted graph (symmetric across matrix diagonal)(space: n +4e, n^2)
	 * 
	 * graph = vertices + edges
	 * 
	 * array of vertex
	 * edges - adjacency linkedList(sparse graph) or adjacency matrix(dense graph)
	 * 
	 * */
	
	ArrayList<VertexInt> nodes;
	java.util.LinkedList<VertexInt>[] edges;
	@SuppressWarnings("unchecked")
	public DirectedUnweightGraph(int num)
	{
		nodes = new ArrayList<VertexInt>();
		edges = new java.util.LinkedList[num];
		for(int i = 0; i < num; i++)
		{
			edges[i] = new LinkedList<VertexInt>();
		}
	}
	private void visit(VertexInt v)
	{
		System.out.println(v.value);
		v.visited = true;
	}
	public void addEdge(VertexInt src, VertexInt des)
	{
		//List<VertexInt> ls = Arrays.asList(this.nodes);
		int index = nodes.indexOf(src);
		if(edges[index].indexOf(des) < 0) edges[index].add(des);
	}
	
	public void doDFS(VertexInt v)
	{
		if(v == null) return;
		this.visit(v);
		for(VertexInt v1 : edges[nodes.indexOf(v)] )
		{
			if(v1 != null && v1.visited == false)
				doDFS(v1);
		}
	}
	
	public void doBFS(VertexInt v)
	{
		if(v == null) return;
		Queue<VertexInt> queue = new java.util.LinkedList<VertexInt>();
		queue.add(v);
		//List<VertexInt> ls =Arrays.asList(this.nodes); 
		while(!queue.isEmpty())
		{
			VertexInt vertex = queue.poll();
			this.visit(vertex);
			int index = nodes.indexOf(vertex);
			for(VertexInt v1 : edges[index])
			{
				if(v1 != null && v1.visited == false)
				{
					v1.visited = true;
					queue.add(v1);
				}
			}
		}
	}
	
	public boolean doesRouteExsists(VertexInt v1, VertexInt v2)
	{
		if(v1 == null || v2 == null) return false;
		if(v1.equals(v2) ) return true;
		
		v1.visited = true;
		Queue<VertexInt> queue = new LinkedList<VertexInt>();
		queue.add(v1);
		VertexInt temp;
		int index;
		while(!queue.isEmpty())
		{
			temp = queue.poll();
			index = nodes.indexOf(temp);
			for(VertexInt edge:edges[index])
			{
				if(edge == null)continue;
				else if(edge.equals(v2)) return true;
				else if(!edge.visited)
				{
					edge.visited = true;
					queue.add(edge);
				}
			}
		}
		return false;
	}
	
	public void addVertex(VertexInt v)
	{
		if(v != null && nodes.indexOf(v) < 0) nodes.add(v);
	}
	
	public boolean isCyclic()
	{
		Set<VertexInt> whiteSet = new HashSet<VertexInt>();
		Set<VertexInt> greySet = new HashSet<VertexInt>();
		Set<VertexInt> blackSet = new HashSet<VertexInt>();
		for(VertexInt v: nodes)
			whiteSet.add(v);
		while(whiteSet.size() > 0)
		{
			VertexInt current = whiteSet.iterator().next();
			if(dfs(current, whiteSet, greySet, blackSet))
			return true;
		}
		return false;
	}
	
	private boolean dfs(VertexInt v, Set<VertexInt> white, Set<VertexInt> grey, Set<VertexInt> black)
	{
		moveVertex(v,white,grey);
		for(VertexInt v1 : edges[nodes.indexOf(v)])
		{
			if(black.contains(v1)) continue;
			if(grey.contains(v1)) return true;
			if(dfs(v1,white,grey,black))return true;
		}
		moveVertex(v,grey,black);
		return false;
	}
	
	private void moveVertex(VertexInt v,Set<VertexInt> set1, Set<VertexInt> set2)
	{
		set1.remove(v);
		set2.add(v);
	}
	
	public void doTopologicalSort()
	{
		/*
		 * Directed acyclic graphs
		 * */
		Set<VertexInt> set = new HashSet<VertexInt>();
		Stack<VertexInt> stack = new Stack<VertexInt>();
		
		for(VertexInt v : nodes)
		{
			if(!set.contains(v)) doTopologicalSort(v, set, stack);
		}
		while(!stack.isEmpty())System.out.println(stack.pop().value);
	}
	private void doTopologicalSort(VertexInt v, Set<VertexInt> set, Stack<VertexInt> stack) {
		
		set.add(v);
		for(VertexInt v1 : edges[nodes.indexOf(v)])
		{
			if(!set.contains(v1))
				doTopologicalSort(v1, set, stack);
		}
		stack.push(v);
	}
}