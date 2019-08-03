package strings;

public class SuperReduced {
  public static String superReducedString(String original, String actual) {
    StringBuffer res = new StringBuffer();
    int i = 0;
    char[] input = (actual == null ? original : actual).toCharArray();

    while (i < input.length) {
      if (i == (input.length - 1) || input[i] != input[i + 1]) {
        res.append(input[i]);
        i++;
      } else
        i += 2;
    }

    String result = "";
    if (res.length() == 0)
      return "Empty String";
    else
      result = res.toString();

    if (actual != null && result.equals(actual))
      return actual;
    else
      return superReducedString(original, result);
  }

  public static String superReducedString(String s) {
    return superReducedString(s, null);
  }

  public static void main(String[] args) {
    String r = SuperReduced.superReducedString("aaabccddd");
    System.out.println(r);
  }
}