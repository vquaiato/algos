// https://leetcode.com/problems/compare-version-numbers/

package strings;

public class ComparingVersionNumbers {
  public int compareVersion(String version1, String version2) {
    String[] parts1 = version1.split("\\.");
    String[] parts2 = version2.split("\\.");
  
    for (int i = 0; i < Math.max(parts1.length, parts2.length); i++) {
      String p1 = i < parts1.length ? parts1[i] : "0";
      String p2 = i < parts2.length ? parts2[i] : "0";
  
      int j = 0, c1 = 0, c2 = 0;
      while (j< Math.max(p1.length(), p2.length())) {
        int k1 = j;
        while (k1 < p1.length())
          c1 += c1 * 10 + (p1.charAt(k1++) - '0');
  
        int k2 = j;
        while (k2 < p2.length())
          c2 += c2 * 10 + (p2.charAt(k2++) - '0');
          
        j = Math.max(k1,k2);
          
        if (c1 != c2)
          return c1 > c2 ? 1 : -1;
      }
    }
  
    return 0;
  }

  public static void main(String[] args) {
    // String v1 = "1.2";
    // String v2 = "1.10";

    // String v1 = "1.1";
    // String v2 = "1.10";

    // String v1 = "0.1";
    // String v2 = "1.1";

    // String v1 = "1.01";
    // String v2 = "1.1";

    String v1 = "1";
    String v2 = "1.1";

    // String v1 = "1.0";
    // String v2 = "1.0.0";

    // String v1 = "7.5.2.4";
    // String v2 = "7.5.3";

    // String v1 = "1.0.1";
    // String v2 = "1";

    System.out.println(new ComparingVersionNumbers().compareVersion(v1, v2));
  }
}