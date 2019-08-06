// https://leetcode.com/problems/two-sum

package arrays;

import java.util.Hashtable;

public class TwoSum {
  public int[] twoSum(int[] nums, int target) {
    Hashtable<Integer, Integer> seen = new Hashtable<Integer,Integer>();
    
    int[] res = new int[2];
    
    for(int i=0; i<nums.length;i++){
        Integer seenIx = seen.get(target - nums[i]);
        
        if(seenIx!=null)
        {
            res[0] = (int)seenIx;
            res[1] = i;
        }
        else
            seen.put(nums[i], i);
    }
    
    return res;
  }

  public static void main(String[] args) {
    int[] input = {1,5,6,3,9,10};
    int target = 9;
    int[] res = new TwoSum().twoSum(input, target);

    System.out.println("[" + res[0] + "," + res[1] + "]");
  }
}