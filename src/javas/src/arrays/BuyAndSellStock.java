// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

package arrays;

public class BuyAndSellStock {
  public int maxProfit(int[] prices) {
    int min = Integer.MAX_VALUE;
    int spread = 0;

    for (int i = 0; i < prices.length; i++) {
      int p = prices[i];
      min = Math.min(min, p);

      spread = Math.max(spread, p - min);
    }

    return spread;
  }
}