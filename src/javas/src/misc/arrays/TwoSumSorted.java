// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

package misc.arrays;

public class TwoSumSorted{
  public int[] twoSum(int[] numbers, int target) {
    int[] res = new int[]{-1,-1};
    if(numbers == null || numbers.length == 0) return res;

    int i = 0, j = numbers.length - 1;
    while(i<j){
      int current = numbers[i] + numbers[j];
      if(current == target)
        return new int[]{i+1, j+1};
      else{
        if(current > target) j--;
        else i++;
      }
    }

    return res;
  }

  public static void main(String[] args) {
    int[] input = new int[]{2, 7, 11, 15};
    // int[] input = new int[]{0, 1, 2, 7, 11, 15, 16, 50, 55, 61};
    int target = 9;
    int[] res = new TwoSumSorted().twoSum(input, target);

    System.out.println("[" + res[0] + "," + res[1] + "]");
  }
}