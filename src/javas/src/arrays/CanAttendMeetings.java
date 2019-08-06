// https://leetcode.com/problems/meeting-rooms

package arrays;

import java.util.Arrays;

public class CanAttendMeetings {
  public boolean canAttendMeetings(int[][] intervals) {
    if (intervals == null || intervals.length < 2)
      return true;

    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    int ini = 0, end = 1;

    for (int i = 1; i < intervals.length; i++)
      if (intervals[i][ini] < intervals[i-1][end])
        return false;

    return true;
  }
}