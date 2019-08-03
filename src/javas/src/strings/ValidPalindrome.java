// https://leetcode.com/problems/valid-palindrome/

package strings;

public class ValidPalindrome{
  public boolean isPalindrome(String s){
    if(s==null || s.isEmpty()) return true;

    int i=0,j=s.length()-1;
    while(i<j){
      if(!Character.isLetter(s.charAt(i)) && !Character.isDigit(s.charAt(i))) i++;
      else if(!Character.isLetter(s.charAt(j)) && !Character.isDigit(s.charAt(j))) j--;
      else
      {
        if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
        i++;j--;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    String input = "A man, a plan, a canal: Panama";
    // String input = "race a car";
    // String input = "0P";
    System.out.println(new ValidPalindrome().isPalindrome(input));
  }
}