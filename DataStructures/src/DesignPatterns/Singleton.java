package DesignPatterns;

public class Singleton {

	/*
	 * Lazy initialization
	 */
	
	private static Singleton objSingleton;
	
	private Singleton(){};
	
	public static Singleton getSingleton()
	{
		if(objSingleton == null)
		{
			synchronized(Singleton.class)
			{
				if(objSingleton == null)
					objSingleton = new Singleton();
			}
		}
		return objSingleton;
	}
	
	/*
	 * Eager initialization
	 */
	/*private static final Singleton objSingleton2 = new Singleton();
	public static Singleton buildSingleton()
	{
		return objSingleton2;
	}*/
	
	
}
