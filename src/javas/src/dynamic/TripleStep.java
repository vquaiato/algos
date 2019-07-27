package dynamic;

import java.util.Arrays;

// From Cracking The Code Interview 8.1

// Triple Step: A child is running up a staircase with n steps
// and can hop either 1, 2 or 3 steps at a time.
// Implement a method to count how many possible ways
// the child can run up the stairs.

public class TripleStep {
  public int count(int stairSize) {
    int[] memo = new int[stairSize];
    Arrays.fill(memo, -1);
    memo[0] = 1;
    if (stairSize > 1)
      memo[1] = 2;
    if (stairSize > 2)
      memo[2] = 4;
    return count(stairSize, memo);
  }

  private int count(int stairSize, int[] memo) {
    if (stairSize == 1 || stairSize == 2 || stairSize == 3)
      return memo[stairSize - 1];

    if (memo[stairSize - 1] < 0)
      memo[stairSize - 1] = count(stairSize - 1, memo) + count(stairSize - 2, memo) + count(stairSize - 3, memo);

    return memo[stairSize - 1];
  }

  public static void main(String[] args) {
    int[] inputs = { 3, 4, 5, 6, 7, 8, 9, 10 };

    for (int n : inputs)
      System.out.println("n: " + n + " -> " + new TripleStep().count(n));
  }
}