package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreak2 {

	public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return new ArrayList<String>();
        }
        HashMap<String, List<String>> hm = new HashMap<>();
        return dfs(s, wordDict, hm);
    }
    
    private List<String> dfs(String s, List<String> wordDict, HashMap<String, List<String>> hm) {
        if (hm.containsKey(s)) {
            return hm.get(s);
        }
        List<String> res = new ArrayList<>();
		if (s.length() == 0) {
			res.add("");
			return res;
		}
		for (String word : wordDict) {
			if (s.startsWith(word)) {
				List<String> remainLists = dfs(s.substring(word.length()), wordDict, hm);
				for (String r : remainLists) {
					res.add(word + (r.length() == 0 ? "" : " ") + r);
				}
			}
		}
        hm.put(s, res);
        return res;
    }
    
    public static void main(String[] args) {
		WordBreak2 wb2 = new WordBreak2();
		List<String> ls = new ArrayList<>();
		ls.add("cats");
		ls.add("cat");
		ls.add("sand");
		ls.add("and");
		ls.add("dogs");
		ls = wb2.wordBreak("catsanddogs", ls);
		ls.forEach(System.out::println);
	}
}
