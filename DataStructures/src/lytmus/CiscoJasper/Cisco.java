package lytmus.CiscoJasper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Cisco {

	public static void main(String[] args) {
		
		File f = new File("C:\\Users\\Parth\\workspace\\DataStructures ( old)\\DataStructures\\src\\input.txt");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(f));
			String s = null;
			s = br.readLine();
			String[] endPoints = s.split(" "); 
			Map<String, List<String>> edges = new HashMap<String,List<String>>();
			String[] line  =null;
			while((s = br.readLine()) != null) {
				line = s.split(":");
				String[] tokens = line[1].split(" ");
				List<String> ls = new ArrayList<String>();
				
				for(String stemp : Arrays.asList(tokens))
					if(!stemp.isEmpty())
						ls.add(stemp.trim());
				edges.put(line[0].trim(),ls);		
			}
			List<String> path = new ArrayList<String>();
			String start = endPoints[0];
			String end = endPoints[1];
			List<String> interm = new ArrayList<String>();
			for(int i =2;i<endPoints.length;i++) {
				interm.add(endPoints[i]);
			}
			
			doDFS(start,end, edges, path, interm,new StringBuilder());
			
			StringBuilder sb1 = new StringBuilder();
			for(String s3 : path)
				sb1.append(s3 + "," );
			
			
			
			File output = new File("output.txt");
			FileWriter fr = new FileWriter(output);
			BufferedWriter bw = new BufferedWriter(fr);
			
			bw.write(sb1.substring(0, sb1.length() - 1).toString());
			bw.flush();
			bw.close();
			fr.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void doDFS(String start, String end, Map<String, List<String>> edges, List<String> path,
			List<String> interm, StringBuilder sb) {
		
		if(start.equals(end)){
			sb.append(end);
			if(interm.isEmpty()){
				path.add(sb.toString());
			}
			else
			{
				for(String s : interm){
					if(sb.indexOf(s) > -1)
					{
						path.add(sb.toString());
						break;
					}
				}
			}
			sb.setLength(sb.length() -1);
		}
		else
		{
			
			List<String> ls= edges.get(start);
			sb.append(start);
			for(String s : ls)
			{
				doDFS(s, end, edges, path, interm, sb);
			}
			sb.setLength(sb.length() -1);
		}
	}
 }
