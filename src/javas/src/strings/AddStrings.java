package strings;

public class AddStrings {

  public String addStrings(String num1, String num2) {
    if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty())
      return "";

    int carry = 0;
    int i = num1.length(), j = num2.length();
    int[] result = new int[Math.max(i, j)];

    while (Math.max(i, j) > 0) {
      int n1 = Character.getNumericValue((i > 0) ? num1.charAt(i - 1) : '0');
      int n2 = Character.getNumericValue((j > 0) ? num2.charAt(j - 1) : '0');
      int n = (n1 + n2 + carry);

      result[Math.max(i, j)-1] = n % 10;
      carry = n > 9 ? 1 : 0;

      i--; j--;
    }
    StringBuffer resString = new StringBuffer(result.length + carry);
    if (carry > 0) resString.append(1);

    for (i = 0; i < result.length; i++)
      resString.append(result[i]);

    return resString.toString();
  }

  public static void main(String[] args) {
    AddStrings a = new AddStrings();
    System.out.println(a.addStrings("999", "1"));
  }
}