// https://leetcode.com/problems/move-zeroes/

package misc.arrays;

public class MoveZeroes{
  public void moveZeroes(int[] nums){
    if(nums == null || nums.length == 0) return;

    int s = 0, f = s;
    while(f < nums.length-1){
      if(nums[s] == 0){
        while(nums[f] == 0 && f < nums.length - 1) f++;
        
        if(f >= nums.length) break;

        nums[s] = nums[f];
        nums[f] = 0;
      }
      else
        if(++s > f) f = s;
    }
  }

  public static void main(String[] args) {
    int[] input = {0,1,0,3,12};
    // int[] input = {0,0,0,1,2,3};
    // int[] input = {0,1};
    // int[] input = {0};
    // int[] input = {1,0,0,0,4};
    // int[] input = {0,0};
    // int[] input = {1,1};
    new MoveZeroes().moveZeroes(input);

    for(int n : input)
      System.out.print(n + ",");
  }
}