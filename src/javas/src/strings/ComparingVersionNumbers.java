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
      while (j >= 0) {
        int k1 = p1.length()-1;
        while (k1 >=0)
          c1 += (p1.charAt(k1) - '0') * Math.pow(10, p1.length() - k1-- - 1);
  
        int k2 = p2.length()-1;
        while (k2 >= 0)
          c2 += (p2.charAt(k2) - '0') * Math.pow(10, p2.length() - k2-- - 1);
          
        j = Math.max(k1,k2);
          
        if (c1 != c2)
          return c1 > c2 ? 1 : -1;
      }
    }
  
    return 0;
  }

  public static void main(String[] args) {
    String v1 = "1.2";
    String v2 = "1.10";

    // String v1 = "1.1";
    // String v2 = "1.10";

    // String v1 = "0.1";
    // String v2 = "1.1";

    // String v1 = "1.01";
    // String v2 = "1.1";

    // String v1 = "1";
    // String v2 = "1.1";

    // String v1 = "1.0";
    // String v2 = "1.0.0";

    // String v1 = "7.5.2.4";
    // String v2 = "7.5.3";

    // String v1 = "1.0.1";
    // String v2 = "1";

    System.out.println(new ComparingVersionNumbers().compareVersion(v1, v2));
  }
}