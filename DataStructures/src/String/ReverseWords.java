package String;

public class ReverseWords {

	public String reverseWords(String s) {
        if(s == null || s.length() == 0) return "";
        
        String[] arr = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length-1 ; i >= 0;i--)
        {
            if(!arr[i].equals(""))
                sb.append(arr[i]+ " ");
        }
        if(sb.length() > 0)
            return sb.substring(0, sb.length()-1);
        else
            return "";
    }
}
