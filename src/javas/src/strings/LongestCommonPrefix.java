// https://leetcode.com/problems/longest-common-prefix/

package strings;

public class LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {
    String prefix = "";
    if (strs == null || strs.length == 0)
      return prefix;

    int i = 0;
    while (true) {
      char c = '\0';
      for (String w : strs) {
        if (i >= w.length())
          return prefix;
        if (c == '\0')
          c = w.charAt(i);
        else if (c != w.charAt(i))
          return prefix;
      }
      prefix = prefix + c;
      i++;
    }
  }

  public static void main(String[] args) {
    // String[] input = {"flower", "flow", "flight"};
    String[] input = { "dog", "racecar", "car" };
    System.out.println(new LongestCommonPrefix().longestCommonPrefix(input));
  }
}