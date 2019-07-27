// https://leetcode.com/problems/climbing-stairs/
//You are climbing a stair case. It takes n steps to reach to the top.
// Each time you can either climb 1 or 2 steps. 
// In how many distinct ways can you climb to the top?

// A follow up problem could be: Triple Step
// From Cracking The Code Interview 8.1

// Triple Step: A child is running up a staircase with n steps
// and can hop either 1, 2 or 3 steps at a time.
// Implement a method to count how many possible ways
// the child can run up the stairs.

package dynamic;

import java.util.*;

public class ClimbStairs {
  public int climbStairsMemo(int n) {
    int[] memo = new int[n+1];
    Arrays.fill(memo, -1);
    
    memo[0] = 1;
    if(n>0) memo[1] = 1;
    if(n>1) memo[2] = 2;

    for(int i = 3;i<=n;i++)
      memo[i] = memo[i-1] + memo[i-2];

    return memo[n];
  }
  public int climbStairsFib(int n) {
    int a = 1, b=2;

    if(n==0 || n==1) return a;
    if(n==2) return b;

    for(int i = 3;i<=n;i++){
      int c = b;
      b = a + b;
      a=c;
    }

    return b;
  }
}