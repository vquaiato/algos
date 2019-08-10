// https://leetcode.com/problems/reverse-words-in-a-string/

package strings;

import java.util.*;

public class ReverseWords {
  public String reverseWords(String s) {
    if (s == null || s.trim().length() == 0)
      return "";

    List<String> parts = Arrays.asList(s.trim().split(" "));
    Collections.reverse(parts);

    StringBuilder sb = new StringBuilder();
    for (String p : parts)
      if (!p.trim().equals("")) {
        sb.append(p);
        sb.append(" ");
      }

    return sb.toString().substring(0, sb.length() - 1);
  }
}