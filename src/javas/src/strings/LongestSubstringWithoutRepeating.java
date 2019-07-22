package strings;

import java.util.*;

public class LongestSubstringWithoutRepeating{
  public int lengthOfLongestSubstring(String s){
    int max = 0;
    if(s == null || s.isEmpty()) return max;

    int i=0, j=i+1;
    max=1;
    Map<Character, Integer> map = new HashMap<>(s.length());
    map.put(s.charAt(i), 0);

    while(j < s.length()){
      if(map.containsKey(s.charAt(j)))
        map.remove(s.charAt(i++));
      else{
        map.put(s.charAt(j), j++);
        max = Math.max(max, map.size());
      }
    }

    return max;
  }
  public static void main(String[] args) {
    String input = "abcabcbb";
    // String input = "pwwkew";
    // String input = "bbbbb";
    // String input = "aabbccc";
    // String input = "aabbcccefghabc";
    // String input = "fghabcaabbccce";
    System.out.println(new LongestSubstringWithoutRepeating().lengthOfLongestSubstring(input));
  }
}