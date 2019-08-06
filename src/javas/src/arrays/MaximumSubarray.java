// https://leetcode.com/problems/maximum-subarray

package arrays;

public class MaximumSubarray {
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0)
      return 0;

    int max = nums[0];
    int current = nums[0];

    for(int i=1;i<nums.length;i++){
      current = Math.max(nums[i], current + nums[i]);
      max = Math.max(max, current);
    }

    return max;
  }

  public static void main(String[] args) {
    int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    // int[] input = {-2, -1};
    // int[] input = { -2, 1 };
    // int[] input = { 1,2 };
    System.out.println(new MaximumSubarray().maxSubArray(input));
  }
}