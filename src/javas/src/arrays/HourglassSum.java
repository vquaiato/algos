// https://www.hackerrank.com/challenges/2d-array

package arrays;

public class HourglassSum {

  public int hourglassSum(int[][] arr) {
    int max = Integer.MIN_VALUE;
    for (int y = 0; y < 4; y++) {
      for (int x = 0; x < 4; x++) {
        int hourglass = arr[y][x] + arr[y][x + 1] + arr[y][x + 2] + 
                        arr[y + 1][x + 1] + 
                        arr[y + 2][x] + arr[y + 2][x + 1] + arr[y + 2][x + 2];

        max = Math.max(hourglass, max);
      }
    }

    return max;
  }
}