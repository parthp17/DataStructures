package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class StronglyConnectedComponent {

	/*
	 * Kosaraju's Algorithm
	 * time complexity - O(E+V)
	 * find strongly connected components -
	 * means each vertex from a component can be visited by all other vertex in that component 
	 * DFS graph -> reverse graph -> DFS reverse graph
	 * stack and set to be used 
	 */
	public List<Set<VertexInt>> findStronglyConnectedComponents(DirectedWeightedGraph dwg)
	{
		Stack <VertexInt> stack = new Stack<VertexInt>();
		HashSet<VertexInt> visitedSet = new HashSet<VertexInt>();
		List<Set<VertexInt>> stronglyConnectedComponents = new ArrayList<Set<VertexInt>>();
		for(VertexInt v : dwg.vertices)
		{
			if(!visitedSet.contains(v))
			{
				doDFS(stack,visitedSet,dwg,v);
			}
		}
		DirectedWeightedGraph reversedwg = reverseGraph(dwg);
		visitedSet.clear();
		HashSet<VertexInt> set = null;
		while(!stack.isEmpty())
		{
			VertexInt v = stack.pop();
			if(!visitedSet.contains(v))
			{
				set = new HashSet<VertexInt>();
				doDFS(stack, visitedSet, reversedwg, v,set);
				stronglyConnectedComponents.add(set);
			}
		}
		return stronglyConnectedComponents;
	}
	
	private DirectedWeightedGraph reverseGraph(DirectedWeightedGraph dwg) {
		
		DirectedWeightedGraph reversedwg = new DirectedWeightedGraph(dwg.vertices.size());
		for(VertexInt v : dwg.vertices)
		{
			reversedwg.vertices.add(v);
		}
		for(LinkedList<Edge> ls : dwg.edges)
		{
			for(Edge e : ls)
			{
				reversedwg.addEdge(e.endPoint2,e.endPoint1, e.weight);
			}
		}
		return reversedwg;
	}

	public void doDFS(Stack<VertexInt> stack, HashSet<VertexInt> visitedSet, DirectedWeightedGraph dwg, VertexInt v)
	{
		if(!visitedSet.contains(v))
		{
			visitedSet.add(v);
			List<Edge> ls = dwg.edges[dwg.vertices.indexOf(v)];
			for(Edge e : ls)
			{
				doDFS(stack,visitedSet,dwg,e.endPoint2);
			}
			stack.push(v);
		}
	}
	
	public void doDFS(Stack<VertexInt> stack, HashSet<VertexInt> visitedSet, DirectedWeightedGraph reversedwg, VertexInt v, HashSet<VertexInt> set)
	{
		if(!visitedSet.contains(v))
		{
			set.add(v);
			visitedSet.add(v);
			List<Edge> ls = reversedwg.edges[reversedwg.vertices.indexOf(v)];
			for(Edge e : ls)
			{
				doDFS(stack,visitedSet,reversedwg,e.endPoint2,set);
			}
		}
	}
	
	public static void main(String[] args)
	{
		DirectedWeightedGraph dwg = new DirectedWeightedGraph(11);
		VertexInt v0 = new VertexInt(0);
		VertexInt v1 = new VertexInt(1);
		VertexInt v2 = new VertexInt(2);
		VertexInt v3 = new VertexInt(3);
		VertexInt v4 = new VertexInt(4);
		VertexInt v5 = new VertexInt(5);
		VertexInt v6 = new VertexInt(6);
		VertexInt v7 = new VertexInt(7);
		VertexInt v8 = new VertexInt(8);
		VertexInt v9 = new VertexInt(9);
		VertexInt v10 = new VertexInt(10);
		
		dwg.vertices.add(v0);
		dwg.vertices.add(v1);
		dwg.vertices.add(v2);
		dwg.vertices.add(v3);
		dwg.vertices.add(v4);
		dwg.vertices.add(v5);
		dwg.vertices.add(v6);
		dwg.vertices.add(v7);
		dwg.vertices.add(v8);
		dwg.vertices.add(v9);
		dwg.vertices.add(v10);
		
		dwg.addEdge(v0, v1, 0);
		dwg.addEdge(v1, v2, 0);
		dwg.addEdge(v2, v0, 0);
		dwg.addEdge(v1, v3, 0);
		dwg.addEdge(v3, v4, 0);
		dwg.addEdge(v4, v5, 0);
		dwg.addEdge(v5, v3, 0);
		dwg.addEdge(v6, v7, 0);
		dwg.addEdge(v6, v5, 0);
		dwg.addEdge(v7, v8, 0);
		dwg.addEdge(v8, v9, 0);
		dwg.addEdge(v9, v6, 0);
		dwg.addEdge(v9, v10, 0);
		
		StronglyConnectedComponent scc= new StronglyConnectedComponent();
		List<Set<VertexInt>> ls = scc.findStronglyConnectedComponents(dwg);
		StringBuilder s;
		for(Set<VertexInt> set : ls)
		{
			s = new StringBuilder();
			for(VertexInt v : set)
				s.append(v.value + " ");
			System.out.println(s.toString());
		}
		/*ls.forEach(set -> {
			set.forEach(v -> System.out.println(v.value));
			System.out.println();
			});*/
		
	}
}