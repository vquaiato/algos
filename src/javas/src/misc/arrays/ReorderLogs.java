// https://leetcode.com/problems/reorder-log-files/

package misc.arrays;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReorderLogs {
  private boolean isNumberLog(String log) {
    int spc = log.indexOf(' ');
    return Character.isDigit(log.charAt(spc + 1));
  }

  class Lex implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
      int spc1 = s1.indexOf(' ');
      int spc2 = s2.indexOf(' ');

      return s1.substring(spc1 + 1, s1.length()).compareToIgnoreCase(s2.substring(spc2 + 1, s2.length())) == 0
          ? s1.substring(0, spc1 - 1).compareToIgnoreCase(s2.substring(0, spc2 - 1))
          : s1.substring(spc1 + 1, s1.length()).compareToIgnoreCase(s2.substring(spc2 + 1, s2.length()));
    }
  }

  public String[] reorderLogFiles(String[] logs) {
    if (logs == null || logs.length < 2)
      return logs;

    Queue<String> numberLogs = new LinkedList<>();
    PriorityQueue<String> letterLogs = new PriorityQueue<>(new Lex());

    for (String log : logs) {
      if (isNumberLog(log))
        numberLogs.add(log);
      else
        letterLogs.add(log);
    }

    String[] res = new String[numberLogs.size() + letterLogs.size()];
    int i = 0;
    while (!letterLogs.isEmpty())
      res[i++] = letterLogs.poll();

    while (!numberLogs.isEmpty())
      res[i++] = numberLogs.poll();

    return res;
  }

  public static void main(String[] args) {
    String[] input = { "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo" };
    var res = new ReorderLogs().reorderLogFiles(input);

    for (var l : res)
      System.out.println(l);
  }
}