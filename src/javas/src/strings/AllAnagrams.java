package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AllAnagrams {
  public List<Integer> allAnagrams(String s, String p) {
    List<Integer> res = new ArrayList<>(s.length());
    HashMap<Character, Integer> table = new HashMap<>(p.length());

    for (char c : p.toCharArray())
      table.put(c, table.getOrDefault(c, 0) + 1);

    int begin = 0, end = 0, counter = table.size();

    while (end < s.length()) {
      char c = s.charAt(end);
      Integer v = table.get(c);
      if (v != null) {
        table.put(c, v - 1);
        if (v - 1 == 0)
          counter--;
      }

      end++;

      while (counter == 0) {
        c = s.charAt(begin);
        v = table.get(c);
        if (v != null) {
          table.put(c, v + 1);
          if (v + 1 > 0) {
            counter++;
            if (end - begin == p.length())
              res.add(begin);
          }
        }

        begin++;
      }
    }

    return res;
  }

  public static void main(String[] args) {
    String s = "baab";
    String t = "ab";

    System.out.println("S: " + s);
    System.out.println("T: " + t);
    System.out.println("Min: " + new AllAnagrams().allAnagrams(s, t));
  }
}