// https://leetcode.com/problems/merge-intervals/
package misc;

import java.util.*;

public class MergeRanges {
  public int[][] merge(int[][] intervals){
    if(intervals == null || intervals.length == 0) return new int[0][0];

    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    List<int[]> result = new ArrayList<int[]>();
    int[] nextRange = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};

    for(int[] interval : intervals){
      if(nextRange[0] == Integer.MIN_VALUE && nextRange[1] == Integer.MIN_VALUE)
        nextRange = interval;
      else{
        if(interval[0] <= nextRange[0]){
          if(interval[1] >= nextRange[1])
            nextRange = interval;
          else
            nextRange[0] = interval[0];
        }
        else{
          if(interval[0] <= nextRange[1]){
            if(interval[1] >= nextRange[1])
              nextRange[1] = interval[1];
          }
          else{
            result.add(nextRange);
            nextRange = interval;
          }
        }
      }
    }
    result.add(nextRange);
    int[][] r = new int[result.size()][2];
    return result.toArray(r);
  }

  public static void main(String[] args) {
    // int[][] input = new int[][]{{1,3},{2,6},{8,10}};
    // int[][] input = new int[][]{{1,4},{0,0}};
    // int[][] input = new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}};
    // int[][] input = new int[][]{{1,4},{5,6}};
    int[][] input = new int[][]{{2,3},{5,5},{2,2},{3,4},{3,4}};

    int[][] result = new MergeRanges().merge(input);

    for(var r : result)
      System.out.print("{" + r[0] + "," + r[1] + "}");
  }
}