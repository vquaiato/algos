// https://leetcode.com/problems/plus-one/

package misc.arrays;

public class PlusOne{
  public int[] plusOne(int[] digits){
    if(digits[digits.length-1] < 9)
    {
      digits[digits.length-1]++;
    }else
    {
      int carry = 1;
      digits[digits.length-1] = 0;

      for(int i=digits.length-2;i>=0;i--)
      {
        digits[i] = (digits[i]+carry)%10;
        carry = (carry == 1 && digits[i]==0) ? 1 : 0;
      }
      
      if(carry == 1)
      {
          int[] n = new int[digits.length + 1];
          n[0] = 1;
          for(int i=0,j=1;i<digits.length;i++,j++)
            n[j] = digits[i];
          
          digits = n;
      }
    }
    return digits;
  }

  public static void main(String[] args) {
    // int[] input = {1,2,3};
    // int[] input = {1,2,9};
    // int[] input = {1,9,9};
    // int[] input = {9,9,9};
    // int[] input = {9};
    // int[] input = {1};
    int[] input = {9,9};

    for(int i : new PlusOne().plusOne(input))
      System.out.print(i);
  }
}