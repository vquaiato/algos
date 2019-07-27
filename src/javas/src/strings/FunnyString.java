package strings;

public class FunnyString {
  public String funnyString(String s) {
    int[] totalA = new int[s.length()];
    int[] totalB = new int[s.length()];

    char[] chars = s.toCharArray();
    for (int i = 0, j = s.length() - 1; i < s.length(); i++, j--) {
      totalA[i] = (int) chars[i];
      totalB[i] = (int) chars[j];
    }

    for (int i = 0, j = i + 1; i < totalA.length - 1; i++, j++) {
      if (Math.abs(totalA[i] - totalA[j]) != Math.abs(totalB[i] - totalB[j]))
        return "Not Funny";
    }

    return "Funny";
  }

  public static void main(String[] args) {
    System.out.println(new FunnyString().funnyString("ivvkx"));
  }
}