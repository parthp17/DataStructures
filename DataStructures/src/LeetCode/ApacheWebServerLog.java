package LeetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import LeetCode.ApacheWebServerLog.Triplet;

public class ApacheWebServerLog {
	
	static List<Triplet> ls = new ArrayList<>();
	static SimpleDateFormat sdfInput = new SimpleDateFormat("dd/MMM/yyyy:hh:mm");
	static SimpleDateFormat sdfOutput = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
	
	static class Triplet {
		public Date timestamp;
		public String uri;
		public int code;
		
		public String getUri() {
			return uri;
		}
		public void setUri(String uri) {
			this.uri = uri;
		}
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}
		public Date getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(Date timestamp) {
			this.timestamp = timestamp;
		}
		public Triplet(Date timestamp, String uri, int code) {
			super();
			this.timestamp = timestamp;
			this.uri = uri;
			this.code = code;
		}
	}

	public static void tokenizeLog(String s)
	{
		if(s != null && !s.isEmpty())
		{
			Pattern p = Pattern.compile("^([\\d.]+) (\\S+) (\\S+) \\[([\\w:/]+)(\\s[+\\-]\\d{4})\\] \"(\\S+) (/[^?]+).* (\\S+)\" (\\d{3}) .*");
			Matcher m = p.matcher(s);
			if (m.matches()) {
				String timestamp = m.group(4);
				Date d = null;
				try {
					d = sdfInput.parse(timestamp);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String uri = m.group(7);
				int code = m.group(9).equals("500")?0:100;
				ls.add(new Triplet(d, uri, code));
			}
		}
	}
	
	public static void main(String[] args) throws ParseException, IOException {
		
		ArrayList<String> logs = new ArrayList<>();
		String s;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		while((s = br.readLine()) != null && !s.isEmpty())
			logs.add(s);
		logs.stream().forEach(log -> {tokenizeLog(log);});
		Map<Date, Map<String, Double>> map = ls.parallelStream().collect(Collectors.groupingBy(Triplet::getTimestamp,TreeMap::new ,Collectors.groupingBy(Triplet::getUri,TreeMap::new, Collectors.averagingDouble(Triplet::getCode))));
		StringBuilder sb;
		for(Date key : map.keySet())
		{
			Map<String, Double> submap = map.get(key);
			String output = sdfOutput.format(key);
			for(String subKey : submap.keySet())
			{
				sb = new StringBuilder().append(output).append(" ").append(subKey).append(" ").append(String.format("%.2f", submap.get(subKey))); 
				System.out.println(sb.toString());
			}
		}
	}
}
