// https://www.hackerrank.com/challenges/alternating-characters/
package strings;

public class AlternatingCharacters{
  public int alternatingCharacters(String s){
    if(s == null || s.length() < 2) return 0;

    int deletions = 0;
    int i = 0;
    while(i < s.length()-1){
      int j = i+1;
      while(j < s.length() && s.charAt(i) == s.charAt(j)){
        deletions++; j++;
      }
      i = j;
    }

    return deletions;
  }

  public static void main(String[] args) {
    String[] input = {"AAAA", "BBBBB","ABABABAB","BABABA","AAABBB"};
    for(String s : input)
      System.out.println(s + " -> " + new AlternatingCharacters().alternatingCharacters(s));
  }
}