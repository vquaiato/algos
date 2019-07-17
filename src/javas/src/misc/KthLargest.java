package misc;

import java.util.PriorityQueue;

public class KthLargest{
  public int kthLargest(int[] nums, int k){
    if(nums == null || nums.length == 0) return -1;
    if(nums.length == 1) return nums[0];

    PriorityQueue<Integer> heap = new PriorityQueue<>(k, (a, b) -> a > b ? 1 : -1);
    
    for(int n : nums){
      if(heap.size() < k)
        heap.add(n);
      else if(n > heap.peek()){
        heap.poll();
        heap.add(n);
      }
    }

    return heap.poll();
  }

  public static void main(String[] args) {
    int[] nums = new int[]{10,9,8,7,6,5,4,3,2,1};
    System.out.println(new KthLargest().kthLargest(nums, 3));
  }
}