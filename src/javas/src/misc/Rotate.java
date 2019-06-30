package misc;

import java.util.LinkedList;
import java.util.Queue;

public class Rotate {
  public static int[] rotLeft(int[] a, int d) {
    int len = a.length;
    if (len == d)
      return a;

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < d; i++)
      q.add(a[i]);

    int diff = len - d;
    for (int i = d; i < len; i++) {
      int newPos = i + diff;
      if (newPos >= len)
        newPos = newPos - len;

      a[newPos] = a[i];
    }
    for (int i = (len - d); i < len; i++)
      a[i] = q.poll();

    return a;
  }
}