package Arrays;

import java.util.Comparator;
import java.util.TreeSet;

public class MyCalendar {

	class Event implements Comparable<Event>{
		int start;
		int end;
		
		Event(int start, int end)
		{
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Event e) {
			
			if((this.end > e.start && this.start <= e.start) 
					|| (this.start < e.end && this.end > e.end)
					|| (this.start <= e.start && this.end >= e.end)
					|| (this.start >= e.start && this.end <= e.end))
				return 0;
			else
			{
				return this.start - e.start;
			}
		}
		
		
		
	}
	
	TreeSet<Event> calender = null;
	public MyCalendar() {
        calender = new TreeSet<>();
    }
    
    public boolean book(int start, int end) {
    	
    	Event event = new Event(start, end);
    	return calender.add(event);
    }
    
    public static void main(String[] args) {
		
    	MyCalendar cal = new MyCalendar();
    	
    	System.out.println(cal.book(20, 29));
    	System.out.println(cal.book(13, 22));
    	System.out.println(cal.book(44, 50));
    	System.out.println(cal.book(1, 7));
    	System.out.println(cal.book(2, 10));
    	System.out.println(cal.book(14, 20));
    	System.out.println(cal.book(19, 25));
    	System.out.println(cal.book(36, 42));
    	System.out.println(cal.book(45, 50));
    	System.out.println(cal.book(47, 50));
    	System.out.println(cal.book(39, 45));
	}
}
