//https://www.hackerrank.com/challenges/beautiful-binary-string/

package strings;

public class BeautifulBinaryString {
  public int beautifulBinaryString(String s) {
    if (s == null || s.isEmpty())
      return 0;

    int i = 0, j = i + 1, k = j + 1;
    int changes = 0;
    while (k < s.length()) {
      if (s.charAt(i) == '0' && s.charAt(j) == '1' && s.charAt(k) == '0') {
        changes++;
        i = k + 1;
        j = i + 1;
        k = j + 1;
      } else {
        i++;
        j++;
        k++;
      }
    }

    return changes;
  }
}