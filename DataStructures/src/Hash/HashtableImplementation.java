package Hash;

public class HashtableImplementation {

	public static void main(String[] args)
	{
		HashTable<Integer, Integer> hTable= new HashTable<Integer,Integer>();
		//System.out.println(hTable.tsize);
		hTable.put(1, 1);
		hTable.put(1, 2);
		System.out.println(hTable.get(1));
		hTable.put(2, 3);
	}
}
