public class MyPalindrome {
  public static Boolean check(String toCheck) {
    char[] toCheckCharArray = toCheck.toCharArray();
    int i, j, len = toCheckCharArray.length;

    for (i = 0, j = len - 1; i < j; i++, j--) {
      if (toCheckCharArray[i] != toCheckCharArray[j])
        return false;
    }

    return true;
  }
}