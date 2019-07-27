package strings;

import java.util.*;

public class Pangram {
  public String pangrams(String s) {
    if (s == null || s.length() < 26)
      return "not pangram";

    HashSet<Character> hash = new HashSet<>(26);
    for (int i = 97; i < 97 + 26; i++)
      hash.add((char) i);

    for (char c : s.toLowerCase().toCharArray())
      if (hash.remove(c) && hash.size() == 0)
          return "pangram";

    return "not pangram";
  }

  public static void main(String[] args) {
    System.out.println(new Pangram().pangrams("We promptly judged antique ivory buckles for the next prize"));
  }
}