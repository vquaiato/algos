// https://leetcode.com/problems/valid-anagram/

package strings;

public class ValidAnagram{
  public boolean isAnagram(String s, String t) {
    if(s == null || t == null) return false;
    if(s.length() != t.length()) return false;

    char[] chars = new char[26];
    int missing = s.length();

    for(char c : s.toCharArray())
      chars[c-97]++;

    for(char c: t.toCharArray())
    {
      if(chars[c-97] == 0) return false;
      else{
        chars[c-97]--;
        missing--;
      }
    }
    
    return missing == 0;
  }
}