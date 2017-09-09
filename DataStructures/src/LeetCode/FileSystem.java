package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class FileSystem {

	//private static FileSystem fs =null;
	private Directory root;
	public static final String NAME_REGEX = "/[0-9a-zA-Z.]";
	/*private InMemoryFileSystem()
	{
		if(fs == null)
		{
			synchronized (InMemoryFileSystem.class) {
				if(fs == null)
				{
					fs = new InMemoryFileSystem();
					this.root= new Directory("/",null);
				}
			}
		}
	}*/
	
	public FileSystem ()
	{
		this.root= new Directory("/",null);
	}
	
	abstract class Entry{	
		Directory parent;
		long created;
		long lastAccessed;
		long lastModified;
		String name;
		Entry(String name, Directory parent)
		{
			this.name = name;
			this.parent = parent;
			this.created = System.currentTimeMillis();
			this.lastAccessed = this.created;
			this.lastModified = this.lastModified;
		}
		
		
		@Override
		public int hashCode() {
			return this.name.hashCode();
		}
		abstract int size();
	}
	
	class Directory extends Entry{

		Map<String,Entry> map;
		Directory(String name, Directory parent)
		{
			super(name, parent);
			map = new TreeMap<String,Entry>();
		}
		
		@Override
		int size() {
			return map.values().stream().mapToInt(f -> f.size()).sum();
			//return list.stream().map(f -> f.size()).collect(Collectors.summingInt(Integer::intValue));
		}
		@Override
		public boolean equals(Object obj) {
			return obj instanceof Directory && this.name.equals(((Directory)obj).name);
		}
		
		public Entry createDirectory(String dName)
		{
			this.lastModified = System.currentTimeMillis();
			Directory d = new Directory(dName, this);
			map.put(dName, d);
			return d;
		}
		
		public Entry createFile(String fName, String content){
			this.lastModified = System.currentTimeMillis();
			File f = null;
			if(map.containsKey(fName))
				f = (File) map.get(fName);
			
			f = new File(fName, this);
			f.append(content);
			
			
			return f;
		}	
	}
	
	class File extends Entry{		
		StringBuffer content = null;
		File(String name, Directory parent) {
			super(name, parent);
			content = new StringBuffer(); 
		}
		public void append(String content)
		{
			this.lastAccessed = System.currentTimeMillis();
			this.lastModified = this.lastAccessed;  
			this.content.append(content);
		}
		public String readFile()
		{
			this.lastAccessed = System.currentTimeMillis();
			return this.content.toString();
		}
		int size()
		{
			return this.content.length();
		}
	}
	
	public List<String> ls(String path) {
		String[] dirs = path.split("/");
		Directory dir = this.root;
		Entry temp = null;
		for(String d : dirs)
		{
			if(d != null && !d.isEmpty())
			{
				temp = dir.map.get(d);
				if(temp instanceof Directory)
					dir = (Directory) temp;
				else
					return Arrays.asList(new String[]{temp.name});
			}
			if(dir == null)
				return null;
		}
		return new ArrayList<String>(dir.map.keySet());
    }
    
    public void mkdir(String path) {
        
    	String[] dirs = path.split("/");
		Entry dir = this.root;
		Directory temp = null;
		for(int i = 1; i < dirs.length ; i++)
		{
			if(dirs[i] != null && !dirs[i].isEmpty() && dir instanceof Directory)
			{
				temp = (Directory) dir;
				dir = ((Directory) dir).map.get(dirs[i]);
			}
			if(dir == null)
			{
				temp.map.put(dirs[i],dir  = new Directory(dirs[i], temp));
			}
		}
    	
    }
    
    public void addContentToFile(String filePath, String content) {
        
    	String[] dirs = filePath.split("/");
		Entry dir = this.root;
		Directory temp = null;
		for(int i = 1; i < dirs.length - 1; i++)
		{
			if(dirs[i] != null && !dirs[i].isEmpty() && dir instanceof Directory)
			{
				temp = (Directory) dir;
				dir = ((Directory) dir).map.get(dirs[i]);
			}
			if(dir == null)
			{
				temp.map.put(dirs[i],dir = new Directory(dirs[i], temp));
			}
		}
    	if(dir instanceof Directory && ((Directory)dir).map.containsKey(dirs[dirs.length -1]))
    		dir = ((Directory)dir).map.get(dirs[dirs.length -1]);
    	else
    		((Directory)dir).map.put(dirs[dirs.length -1],dir =  new File(dirs[dirs.length -1],(Directory)dir));
    		
    	((File)dir).append(content);
    }
    
    public String readContentFromFile(String filePath) {
        
    	String[] dirs = filePath.split("/");
		Entry dir = this.root;
		for(int i = 1; i < dirs.length ; i++)
		{
			if(dirs[i] != null && !dirs[i].isEmpty() && dir instanceof Directory)
			{
				dir = ((Directory) dir).map.get(dirs[i]);
			}
			if(dir == null)
				return null;
		}
    	if(dir instanceof File)
    		return ((File)dir).readFile();
    	return null;
    }
    
    public static void main(String[] args) {		
    	FileSystem fs = new FileSystem();
    	fs.mkdir("/m");
    	System.out.println(fs.ls("/m").toString());
    	//System.out.println(fs.ls("/").toString());
    	fs.mkdir("/w");
    	System.out.println(fs.ls("/").toString());
    	System.out.println(fs.ls("/w").toString());
    	System.out.println(fs.ls("/").toString());
    	fs.addContentToFile("/dycete", "emer");
    	System.out.println(fs.ls("/w").toString());
    	System.out.println(fs.ls("/").toString());
    	System.out.println(fs.ls("/dycete").toString());

    	//fs.mkdir("/a/b/c/d");
    	//fs.addContentToFile("/a/b/c/d", "test message");
    	//System.out.println(fs.ls("/").toString());
    	//System.out.println(fs.readContentFromFile("/a/b/c/d"));
    	
	}
}