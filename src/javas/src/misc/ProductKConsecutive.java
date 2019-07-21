package misc;

public class ProductKConsecutive {
  public int[] product(int[] nums, int k){
    if(nums == null || nums.length < k) return nums;

    int[] res =  new int[nums.length];
    int t = k;
    for (int i = 0; i < nums.length; i++){
      int p = nums[i];
      t = k;
      while(t > 0 && (i+t) < nums.length){
        p *= nums[ i + t];
        t--;
      }
      res[i] = p;
    }
    
    return res;
  }

  public static void main(String[] args) {
    int[] r = new ProductKConsecutive().product(new int[] { 1, 2,3,4,5 }, 2);
    for (int p : r)
      System.out.print(p + " ");
  }
}