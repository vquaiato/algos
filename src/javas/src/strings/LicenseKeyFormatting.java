package strings;

public class LicenseKeyFormatting{
  public String format(String key, int k){
    int j = k;
    StringBuilder res = new StringBuilder();

    for(int i=key.length()-1;i>=0;i--){
      char c = key.charAt(i);
      if(c == '-') continue;

        if(j == 0)
        {
          res.append("-");
          j = k;
        }

        res.append(Character.toUpperCase(c));
        j--;
    }

    return res.reverse().toString();
  }

  public static void main(String[] args) {
    String key = "2-5g-3-j";
    System.out.println(new LicenseKeyFormatting().format(key, 2));
  }
}