// https://www.hackerrank.com/challenges/gem-stones
package strings;

import java.util.*;

public class Gemstones {
  public int gemstones(String[] arr) {
    if (arr == null || arr.length == 0)
      return 0;
    if (arr.length == 1)
      return arr[0].length();

    Set<Character> s = new HashSet<Character>(arr[0].length());
    for (int i = 0; i < arr[0].length(); i++)
      s.add(arr[0].charAt(i));

    for (int i = 1; i < arr.length; i++) {
      String st = arr[i];
      Set<Character> ts = new HashSet<Character>(s.size());
      for (int j = 0; j < st.length(); j++) {
        if (s.contains(st.charAt(j)))
          ts.add(st.charAt(j));
      }
      s = ts;
    }

    return s.size();
  }

  public static void main(String[] args) {
    String[] input = new String[] { "abcdde", "baccd", "eeabg" };
    System.out.println(new Gemstones().gemstones(input));
  }
}