package strings;

public class ProgrammerString {
  private char[] programmer() { return "programmer".toCharArray(); }

  public int findDistance(String s){ return findDistance(s, 0); }
  private int indexOf(char[] a, char k){
    for(int i=0;i<a.length;i++)
      if(a[i] == k)
        return i;  
    
    return -1;
  }
  private int findDistance(String s, int lettersFound) {
    char[] check = programmer();

    for (var i = 0; i < s.length(); i++) {
      int index = indexOf(check, s.charAt(i));

      if (index > -1) {
        check[index] = '0';
        lettersFound++;

        if (lettersFound == 10)
          return findDistance(new StringBuffer(s.substring(i+1)).reverse().toString(), lettersFound);
        else if (lettersFound == 20)
          return s.length() - i - 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    String input = "adsdssprogrammerproghfghfhfhfhfhfhhfgfghrammer";
    System.out.println("Input: " + input + " -> " + new ProgrammerString().findDistance(input));
  }
}