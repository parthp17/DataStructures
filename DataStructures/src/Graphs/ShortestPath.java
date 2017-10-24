package Graphs;
import java.util.HashMap;
import java.util.Map;


//O(Log(E+V)) O(ELogV)
public class ShortestPath {

	Map<VertexInt, VertexInt> neighbour;
	Map<VertexInt, Integer> distance;
	PrimsBMH minHeap;
	
	public ShortestPath()
	{
		neighbour = new HashMap<VertexInt, VertexInt>();
		distance = new HashMap<VertexInt, Integer>();
		minHeap = new PrimsBMH();
	}
	
	public int findPath(UndirectedWeightedGraph uwg, VertexInt src, VertexInt des)
	{
		for(VertexInt v: uwg.vertices)
			this.minHeap.add(v, Integer.MAX_VALUE);

		this.minHeap.decrease(src, 0);
		this.distance.put(src, 0);
		this.neighbour.put(src, null);
		VertexInt current, adjacent = null;
		while(!this.minHeap.isEmpty())
		{
			PrimsBMH.Node n = this.minHeap.extractMin();
			current = n.key;
			this.distance.put(current, n.weight);
			
			for(Edge e : uwg.getEdge(current))
			{
				adjacent = getVertexForEdge(current, e);
				if(minHeap.contains(adjacent) && (e.weight + n.weight ) < minHeap.getWeight(adjacent))
				{
					minHeap.decrease(adjacent, (e.weight + n.weight));
					neighbour.put(adjacent, current);
				}
			}
		}
		
		return distance.get(des);
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
        
        ShortestPath sp = new ShortestPath();
        System.out.println(sp.findPath(uwg, v1, v5));
	}
}
