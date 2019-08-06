// https://leetcode.com/problems/container-with-most-water

package arrays;

public class ContainerWithMostWater{
  public int maxArea(int[] h) {
    int max = 0;

    if(h == null || h.length < 2) return max;

    int i = 0, j=h.length - 1;

    while(i < j){
      max = Math.max(max, Math.min(h[i], h[j]) * (j - i));
      if(h[i] > h[j]) j--;
      else i++;
    }

    return max;
  }

  public static void main(String[] args) {
    // int[] input = {1,2,3,2,1,2};
    // int[] input = {1,8,6,2,5,4,8,3,7};
    // int[] input = {0,1,8,6,2,5,4,8,3,7};
    // int[] input = {1,8};
    // int[] input = {8,1};
    // int[] input = {8,7,9,8};
    // int[] input = {1,2,3,4,5,6,7,8,9,10};
    // int[] input = {10,9,8,7,6,5,4,3,2,1};
    // int[] input = {10,10,1,1,1,1,1,1,1,1,1,1,1,1};
    // int[] input = {10,10,1,1,1,1,1,1,1,1,100,100};
    // int[] input = {10,10,1,1,1,1,1,1,1,100,100};
    // int[] input = {10,10,50,100,100};
    // int[] input = {1,1,2,1,2,2};
    int[] input = {2,3,10,5,7,8,9};

    System.out.println(new ContainerWithMostWater().maxArea(input));
  }
}