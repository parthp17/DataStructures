package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

public class TravellingSalesmanHeldKarp {

	private static class Index
	{
		VertexInt currentVertex;
		Set<VertexInt> vertexSet;
		
		Index()
		{
			//vertexSet = new HashSet<VertexInt>();
		}
		Index(VertexInt v,Set<VertexInt> vertexSet)
		{
			this.currentVertex = v;
			this.vertexSet = vertexSet;
		}
		
		public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Index index = (Index) o;

            if (currentVertex != index.currentVertex) return false;
            return !(vertexSet != null ? !vertexSet.equals(index.vertexSet) : index.vertexSet != null);
        }
		public int hashCode() {
            int result = currentVertex.value;
            result = 31 * result + (vertexSet != null ? vertexSet.hashCode() : 0);
            return result;
        }
		
	}
	private static class SetSizeComparator implements Comparator<Set<VertexInt>>{
        @Override
        public int compare(Set<VertexInt> o1, Set<VertexInt> o2) {
            return o1.size() - o2.size();
        }
    }
	
	public int[][] graphMatrix(DirectedWeightedGraph dwg)
	{
		int[][] adjMatrix = new int[dwg.vertices.size()][dwg.vertices.size()];
		for(int i = 0 ; i < dwg.vertices.size(); i++)
		{
			int ptr = 0;
			for(int j = 0; j < dwg.vertices.size(); j++)
			{
				if(j==i)
				{
					adjMatrix[i][j] = Integer.MAX_VALUE;
					continue;
				}
				if(dwg.edges[i].get(ptr) != null && dwg.edges[i].get(ptr).endPoint2.equals(dwg.vertices.get(j)))
				{
					adjMatrix[i][j] = dwg.edges[i].get(ptr).weight;
					ptr++;
				}
				else
				{
					adjMatrix[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		
		return adjMatrix;
	}
	public int minCostPath(int[][] adjMatrix, DirectedWeightedGraph dwg)
	{
		Map<Index,Integer> minCostDp = new HashMap<Index,Integer>();
		Map<Index,VertexInt> parent = new HashMap<Index,VertexInt>();
		
		List<Set<VertexInt>> allSets = generateCombination(dwg.vertices.size(),dwg);
		Collections.sort(allSets,new SetSizeComparator());
		
		for(Set<VertexInt> setv : allSets)
		{
			for (int curVert = 1; curVert < adjMatrix.length; curVert++) 
			{
				if (setv.contains(dwg.vertices.get(curVert)))
					continue;

				Index index = new Index();
				index.currentVertex = dwg.vertices.get(curVert);
				index.vertexSet = setv;
				int minCost = Integer.MAX_VALUE;
				VertexInt minPrevVertex = null;

				Set<VertexInt> copySet = new HashSet<VertexInt>(setv);
				for (VertexInt vint : setv) 
				{
					int cost = adjMatrix[dwg.vertices.indexOf(vint)][curVert] + getCost(copySet, vint, minCostDp);

					if(cost < minCost)
					{
						minCost = cost;
						minPrevVertex = vint;
					}
				}
				if(setv.size() == 0)
				{
					minCost = adjMatrix[0][curVert]; 
				}
				minCostDp.put(index, minCost);
				parent.put(index, minPrevVertex);
			}
		}
		Set<VertexInt> newSet = new HashSet<VertexInt>();
		for(int i = 1; i < adjMatrix.length; i++)
		{
			newSet.add(dwg.vertices.get(i));
		}
		int min = Integer.MAX_VALUE;
		VertexInt prevVertex = null;
		
		Set<VertexInt> copySet = new HashSet<VertexInt>(newSet);
		for(VertexInt vert : newSet)
		{
			int cost = adjMatrix[dwg.vertices.indexOf(vert)][0] + getCost(copySet, vert, minCostDp);
			if(cost < min)
			{
				min = cost;
				prevVertex = vert;
			}
		}
		Index key = new Index();
		key.currentVertex = dwg.vertices.get(0);
		key.vertexSet = newSet;
		parent.put(key, prevVertex);

		java.util.Stack<VertexInt> stack = new java.util.Stack<VertexInt>();
		Set<VertexInt> tempSet = new HashSet<>();
		for(int i = 0; i <dwg.vertices.size();i++)
			tempSet.add(dwg.vertices.get(i));
		
		VertexInt vtemp = dwg.vertices.get(0);
		//StringBuilder sb = new StringBuilder();
		while(true)
		{
			//sb.append(vtemp.value);
			stack.push(vtemp);
			tempSet.remove(vtemp);
			Index in = new Index();
			in.currentVertex = vtemp;
			in.vertexSet = tempSet;
			vtemp = parent.get(in);
			if(vtemp == null)
				break;
			
		}
		//System.out.println(sb.toString());
		StringJoiner sj = new StringJoiner("<-");
		stack.forEach(v -> sj.add(String.valueOf(v.value)));
		System.out.println(sj.toString());
		return min;
	}
	
    private int getCost(Set<VertexInt> set, VertexInt prevVertex, Map<Index, Integer> minCostDP) {
        set.remove(prevVertex);
        Index index = new Index();
        index.currentVertex = prevVertex;
        index.vertexSet=  set;
        Integer cost = minCostDP.get(index);
        set.add(prevVertex);
        if(cost == null) return 0;
        return (int)cost;
    }
	private List<Set<VertexInt>> generateCombination(int n,DirectedWeightedGraph dwg) {
		VertexInt input[] = new VertexInt[n];
        for(int i = 0; i < input.length; i++) {
            input[i] = dwg.vertices.get(i);
        }
        List<Set<VertexInt>> allSets = new ArrayList<>();
        VertexInt result[] = new VertexInt[input.length];
        generateCombination(input, 0, 0, allSets, result);
        return allSets;
    }

    private void generateCombination(VertexInt input[], int start, int pos, List<Set<VertexInt>> allSets, VertexInt result[]) {
        if(pos == input.length) {
            return;
        }
        Set<VertexInt> set = createSet(result, pos);
        allSets.add(set);
        for(int i=start; i < input.length; i++) {
            result[pos] = input[i];
            generateCombination(input, i+1, pos+1, allSets, result);
        }
    }

    private static Set<VertexInt> createSet(VertexInt input[], int pos) {
        if(pos == 0) {
            return new HashSet<>();
        }
        Set<VertexInt> set = new HashSet<VertexInt>();
        for(int i = 0; i < pos; i++) {
            set.add(input[i]);
        }
        return set;
    }
	public static void main(String[] args)
	{
		DirectedWeightedGraph dwg = new DirectedWeightedGraph(5);
		
		VertexInt v1 = new VertexInt(0);
		VertexInt v2 = new VertexInt(1);
		VertexInt v3 = new VertexInt(2);
		VertexInt v4 = new VertexInt(3);
		//VertexInt v5 = new VertexInt(5);
		
		dwg.vertices.add(v1);
		dwg.vertices.add(v2);
		dwg.vertices.add(v3);
		dwg.vertices.add(v4);
		//dwg.vertices.add(v5);
		
		dwg.addEdge(v1, v2, 1);
		dwg.addEdge(v1, v3, 15);
		dwg.addEdge(v1, v4, 6);
		dwg.addEdge(v2, v1, 2);
		dwg.addEdge(v2, v3, 7);
		dwg.addEdge(v2, v4, 3);
		dwg.addEdge(v3, v1, 9);
		dwg.addEdge(v3, v2, 6);
		dwg.addEdge(v3, v4, 12);
		dwg.addEdge(v4, v1, 10);
		dwg.addEdge(v4, v2, 4);
		dwg.addEdge(v4, v3, 8);
		
		/*dwg.addEdge(v1, v2, 10);
		dwg.addEdge(v1, v3, 8);
		dwg.addEdge(v1, v4, 9);
		dwg.addEdge(v1, v5, 7);
		dwg.addEdge(v2, v1, 10);
		dwg.addEdge(v2, v3, 10);
		dwg.addEdge(v2, v4, 5);
		dwg.addEdge(v2, v5, 6);
		dwg.addEdge(v3, v1, 8);
		dwg.addEdge(v3, v2, 10);
		dwg.addEdge(v3, v4, 8);
		dwg.addEdge(v3, v5, 9);
		dwg.addEdge(v4, v1, 9);
		dwg.addEdge(v4, v2, 5);
		dwg.addEdge(v4, v3, 8);
		dwg.addEdge(v4, v5, 6);
		dwg.addEdge(v5, v1, 7);
		dwg.addEdge(v5, v2, 6);
		dwg.addEdge(v5, v3, 9);
		dwg.addEdge(v5, v4, 6);*/
		
		TravellingSalesmanHeldKarp trvlsls = new TravellingSalesmanHeldKarp();
		System.out.println(trvlsls.minCostPath(trvlsls.graphMatrix(dwg), dwg));
	}
}
