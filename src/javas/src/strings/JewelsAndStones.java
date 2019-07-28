// https://leetcode.com/problems/jewels-and-stones

package strings;

public class JewelsAndStones {
  public int numJewelsInStones(String J, String S) {
    int total = 0;
    
    if(J == null || J.isEmpty()) return total;
    if(S == null || S.isEmpty()) return total;
    
    for(Character c : S.toCharArray())
      if(J.contains(c.toString()))
        total++;
    
    return total;
  }

  public static void main(String[] args) {
    String j = "aA";
    String s = "aAAbbbb";

    System.out.println(new JewelsAndStones().numJewelsInStones(j, s));
  }
}