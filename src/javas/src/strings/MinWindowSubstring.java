package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        if(end - begin < maxLen){
          maxLen = end - begin;
          res = s.substring(begin, end);
        }

        c = s.charAt(begin);
        if(table.containsKey(c))
          if(table.put(c, table.get(c) + 1) == 0) 
            counter++;

        begin++;
      }
    }

    return res;
  }
  public List<Integer> allAnagrams(String s, String p){
    List<Integer> res = new ArrayList<>(s.length());
    HashMap<Character, Integer> table = new HashMap<>(p.length());
    
    for(char c : p.toCharArray()){
      Integer v = table.get(c);
      if(v == null)
        table.put(c, 1);
      else
        table.put(c, v+1);
    }

    int begin = 0, end = 0, counter = table.size();

    while(end < s.length()){
      char c = s.charAt(end);
      Integer v = table.get(c);
      if(v != null){
        table.put(c, v - 1);
        if(v-1 == 0)
          counter--;
      }

      end++;

      while(counter == 0){
        c = s.charAt(begin);
        v = table.get(c);
        if(v!=null){
          table.put(c, v + 1);
          if(v+1 > 0){
            counter++;
            if(end - begin == p.length())
              res.add(begin);
          }
        }

        begin++;
      }
    }

    return res;
  }
  public static void main(String[] args) {
    MinWindowSubstring m = new MinWindowSubstring();
    String s = "baab";
    String t = "ab";

    System.out.println("S: " + s);
    System.out.println("T: " + t);
    System.out.println("Min: " + m.allAnagrams(s, t));
  }
}