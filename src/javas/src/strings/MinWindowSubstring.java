package strings;

import java.util.HashMap;

public class MinWindowSubstring{
  public String minWindow(String s, String t){
    HashMap<Character, Integer> table = new HashMap<>();
    
    for(char c : t.toCharArray())
      table.put(c, table.getOrDefault(c, 0) + 1);
    
    String res = "";
    int begin=0, end=0;
    int counter = table.size();
    int maxLen = Integer.MAX_VALUE;

    while(end < s.length()){
      char c = s.charAt(end);

      if(table.containsKey(c))
        if(table.put(c, table.get(c) - 1) == 1) 
          counter--;

      end++;

      while(counter == 0){
        maxLen = Math.max(maxLen, end - begin);
        res = s.substring(begin, end);

        c = s.charAt(begin);
        if(table.containsKey(c))
          if(table.put(c, table.get(c) + 1) == 0) 
            counter++;

        begin++;
      }
    }

    return res;
  }
  
  public static void main(String[] args) {
    MinWindowSubstring m = new MinWindowSubstring();
    String s = "ADOBECODEBANC";
    String t = "ABC";

    System.out.println("Min: " + m.minWindow(s, t));
  }
}