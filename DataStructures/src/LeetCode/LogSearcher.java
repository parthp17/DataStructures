package LeetCode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LogSearcher {

	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);
		// final String fileName = System.getenv("OUTPUT_PATH");
		// BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
		LocalTime startDate = LocalTime.parse(in.nextLine(), formatter);
		LocalTime endDate = LocalTime.parse(in.nextLine(), formatter);
		final int numberOfLogLines = Integer.parseInt(in.nextLine());
		Collection<String> logLines = new ArrayList<String>();
		for (int i = 0; i < numberOfLogLines; i++) {
			logLines.add(in.nextLine());
		}
		in.close();
		Collection<String> res = new LogSearcher().search(logLines, startDate, endDate);
		/*
		 * for (String logLine : res) { bw.write(logLine); bw.newLine(); }
		 */
		// bw.close();
		res.forEach(System.out::println);
	}

	private String getSameHourMinute(int sm, int em) {

		if (sm == em) {
			return "[" + "]:";
		} else if (sm < em) {

		} else {

		}
		return "";
	}

	private Collection<String> search(Collection<String> logLines, LocalTime startDate, LocalTime endDate) {
		String criteria = "";
		int sh = startDate.getHour();
		int shh = sh / 10;
		int shl = sh % 10;
		int eh = endDate.getHour();
		int ehh = eh / 10;
		int ehl = eh % 10;
		int sm = startDate.getMinute();
		int smh = sm / 10;
		int sml = sm % 10;
		int em = endDate.getMinute();
		int emh = em / 10;
		int eml = em % 10;
		int ss = startDate.getSecond();
		int ssh = ss / 10;
		int ssl = ss % 10;
		int es = endDate.getSecond();
		int esh = es / 10;
		int esl = es % 10;
		if (sh == eh) {
			criteria += "" + shh + shl+ ":";
			if (sm == em) {
				criteria +=  sm + ":";
				if (ssh == esh)
					criteria += "(" + ssh + "[" + ssl + "-" + esl + "]" + ")";
				else {
					criteria += "(" + ssh + "[" + ssl + "-9]";
					while (++ssh != esh)
						criteria += "|" +ssh + "[0-9]";
					criteria += "|"+esh + "[0-" + esl + "])";
				}
			} else {
					 criteria += "((" + sm +":(" +ssh +"["+ssl+"-9]";
					 while (++ssh != 6)
						criteria += "|" +ssh + "[0-9]";
					 criteria += "))|";
					 criteria += "(" + em + ":(" + esh + "[0-"+esl + "]";
					 while(--esh != -1)
						 criteria += "|" +esh + "[0-9]";
					 criteria += "))";
					 if(smh == emh)
					 {
						 if(eml - ++sml > 0)
							 criteria += "|(" + smh + "[" + sml + "-" + (eml -1) + "]:[0-5][0-9])";
					 }
					 else
					 {
						 criteria += "|((";
						 criteria += smh + "[" + (sml + 1) +"-9]";
						 while(++smh < emh)
						 {
							 criteria += "|" +smh + "[0-9]";
						 }
						 criteria += "|" +emh + "[0-" + (eml - 1) +"]):";
						 criteria +="[0-5][0-9]"; 
						 criteria += ")";
					 }
					 criteria += ")";
			}
		} else {
			criteria += "((" + shh + shl + ":((" + sm + ":(" + ssh + "[" + ssl + "-9]";
			int tempshh = shh;
			while(++ssh != 6)
				criteria += "|"+ ssh + "[0-9]";
			criteria += "))";
			criteria += "|((" + smh + "[" + (sml + 1) + "-9]";
			while(++smh != 6)
				criteria += "|" + smh + "[0-9]";
			criteria += "):[0-5][0-9])))";
			criteria += "|(" + ehh +ehl + ":((" + em + ":(" + esh + "[0-" + esl +"]";
			while(--esh > -1) 
				criteria += "|" + esh + "[0-9]";
			criteria += "))";
			criteria += "|((" + emh + "[0-" + (eml - 1) + "]";
			while(--emh > -1)
				criteria += "|" + emh + "[0-9]";
			criteria += "):[0-5][0-9])))";
			if(eh - sh > 1)
			{
				criteria += "|(";
				
				if(shh != ehh) {
					criteria += tempshh + "[" + (shl + 1) + "-9]";
					if(ehh - shh > 1)
						criteria += "|1[0-9]";
					criteria += "|" + ehh +"[0-" + (ehl - 1) + "]";
				}
				else
				{
					criteria += shh + "[" + (shl + 1) + "-" + (ehl - 1)+ "]";
				}
				criteria += "):[0-5][0-9]:[0-5][0-9])";
			}
			else
			{
				criteria += ")";
			}
		}
		
		String regex = "(\\d{4}-\\d{2}-\\d{2}T" +criteria+"Z[\\t\\s\\na-zA-Z.]+)";
		return logLines.stream().parallel().filter(x -> x.matches(regex))
				.collect(Collectors.toCollection(ArrayList::new));
	}
}
