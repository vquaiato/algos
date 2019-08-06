// https://leetcode.com/problems/single-element-in-a-sorted-array/

// at first I solved in O(n) using a single while loop to check the pairs
// then I realised it should be solved in O(logn)
// the idea I used was to "binary search" the elements

package arrays;

import java.util.*;

public class SingleElement {
  public int singleNonDuplicate(int[] nums) {
    int size = nums.length;
    if (size == 1)
      return nums[0];

    int pivot = size / 2;
    if (nums[pivot] != nums[pivot + 1] && nums[pivot] != nums[pivot - 1])
      return nums[pivot];

    int ini = 0, end = size;
    if (nums[pivot] == nums[pivot - 1]) {
      if (pivot % 2 == 0)
        end = pivot + 1;
      else
        ini = pivot + 1;
    } else {
      if ((size - pivot) % 2 != 0)
        ini = pivot;
      else
        end = pivot;
    }
    return singleNonDuplicate(Arrays.copyOfRange(nums, ini, end));
  }

  public static void main(String[] args) {
    // int[] input = {1,1,2,3,3,4,4,8,8};
    // int[] input = {3,3,7,7,10,11,11};
    int[] input = { 3, 3, 7, 7, 4, 4, 5, 5, 8, 8, 13, 11, 11 };
    System.out.println(new SingleElement().singleNonDuplicate(input));
  }
}