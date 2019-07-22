package misc.arrays;

import java.util.*;

public class FruitIntoBasket{
  public int totalFruit(int[] trees){
    int i=0, j=i+1, max = 1, count=1;
    if(trees == null || trees.length == 0) return max;

    Map<Integer, Integer> hash = new HashMap<>(3);
    hash.put(trees[i], 1);
    
    while(i < trees.length && j < trees.length){
      hash.put(trees[j], hash.getOrDefault(trees[j], 0) + 1);
      
      while(hash.size() > 2){
        count = j - i - 1;
        hash.put(trees[i], hash.getOrDefault(trees[i], 0) - 1);
        hash.remove(trees[i],0);
        i++;
      }

      max = Math.max(++count, max);
      j++;
    }

    return max;
  }

  public static void main(String[] args) {
    // int[] trees = new int[]{1,2,1};
    // int[] trees = new int[]{0,1,2,2};
    // int[] trees = new int[]{1,2,3,2,2};
    // int[] trees = new int[]{3,3,3,1,2,1,1,2,3,3,4};
    // int[] trees = new int[]{0};    
    int[] trees = new int[]{0,1,6,6,4,4,6};
    System.out.println(new FruitIntoBasket().totalFruit(trees));
  }
}