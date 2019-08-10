package arrays;

public class MergeArrays {
  public int[] merge(int[] arr1, int m, int[] arr2, int n) {
    return merge(arr1, m, arr2, n, 0, 0);
  }

  private int[] merge(int[] a1, int m, int[] a2, int n, int i1, int i2) {
    if (i2 >= n)
      return a1;

    if (a1[i1] > a2[i2]) {
      for (int i = (m + i2 - 1); i >= i1; i--)
        a1[i + 1] = a1[i];

      a1[i1] = a2[i2++];
    } else if (a1.length - i1 <= n - i2)
      a1[i1++] = a2[i2++];
    else
      i1++;

    return merge(a1, m, a2, n, i1, i2);
  }

  public static void main(String[] args) {
    int[] a1 = new int[] { -1, 0, 0, 3, 3, 3, 0, 0, 0 };
    int[] a2 = new int[] { 1, 2, 2, };
    int[] r = new MergeArrays().merge(a1, 6, a2, 3);
    for (int i = 0; i < r.length; i++)
      System.out.print(r[i] + " ");
  }
}