package strings;

//https://leetcode.com/problems/detect-capital/

public class DetectCapital{
  public boolean detectCapitalUse(String word){
    if(word == null || word.isEmpty()) return true;

    boolean firstIsCapital = Character.isUpperCase(word.charAt(0));
    boolean hadLowerCase = !firstIsCapital;
    boolean hadUpperCase = false;

    for(int i=1;i<word.length();i++) {
      if(Character.isUpperCase(word.charAt(i))) {
        hadUpperCase = true;
        if(!firstIsCapital || hadLowerCase) return false;
      }
      else {
        if(hadUpperCase) return false;
        hadLowerCase = true;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    String[] words = new String[]{"USA", "leetcode", "Google", "GooGle", "googlE", "googlEE", "googlEEe", "GOOGLe", "GOOGLeE"};
    for(String w : words)
      System.out.println(w + " : " + new DetectCapital().detectCapitalUse(w));
  }
}