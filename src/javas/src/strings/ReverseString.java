// https://leetcode.com/problems/reverse-string/

package strings;

public class ReverseString{
  public void reverseString(char[] s) {
    if(s == null || s.length == 0) return;

    int i=0, j=s.length-1;
    while(j>i){
      char t = s[j];
      s[j--] = s[i];
      s[i++] = t;
    }
  }

  public static void main(String[] args) {
    // String input = "vinicius";
    String input = "impar";
    char[] s = input.toCharArray();

    new ReverseString().reverseString(s);
  }
}