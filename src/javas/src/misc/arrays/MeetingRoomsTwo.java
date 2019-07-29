//https://leetcode.com/problems/meeting-rooms-ii/

package misc.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import javafx.util.Pair;

public class MeetingRoomsTwo{
  public int minMeetingRooms(int[][] intervals) {
    if(intervals == null || intervals.length == 0) return 0;

    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    int ini = 0, end = 1;

    PriorityQueue<Integer> rooms = new PriorityQueue<>(intervals.length, (a, b) -> a < b ? -1 : 1);
    rooms.add(intervals[0][end]);
    for(int i=1;i<intervals.length;i++){
      if(intervals[i][ini] >= rooms.peek())
        rooms.poll();

      rooms.add(intervals[i][end]);
    }

    return rooms.size();
  }

  public static void main(String[] args) {

    List<Pair<int[][], Integer>> inputs = List.of(
      new Pair<int[][],Integer>(new int[][]{{0,30},{15,20},{7,10}},2),
      new Pair<int[][],Integer>(new int[][]{{7,10},{2,4}},1),
      new Pair<int[][],Integer>(new int[][]{{0,30},{20, 22},{23, 25}},2),
      new Pair<int[][],Integer>(new int[][]{{9,10},{4,9},{4,17}},2),
      new Pair<int[][],Integer>(new int[][]{{1,2},{2,3},{3,4}},1),
      new Pair<int[][],Integer>(new int[][]{{1,2},{2,3},{3,4},{3,5}},2),
      new Pair<int[][],Integer>(new int[][]{{2,11},{6,16},{11,16}},2)
    );

  for(Pair<int[][], Integer> input : inputs)
    System.out.println(new MeetingRoomsTwo().minMeetingRooms(input.getKey()) + " should be -> " + input.getValue());
  }
}