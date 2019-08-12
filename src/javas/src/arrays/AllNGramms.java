package arrays;

import java.util.*;

public class AllNGramms {
  public List<List<String>> nGramms(String[] input, int n) {
    List<List<String>> result = new ArrayList<>();
    List<String> partial = new ArrayList<>();

    int len = input.length;
    int k = 0;

    while(k < n){
      for(int i = 0; i < len - k; i++){
        for(int j = i; j <= k+i; j++){
          partial.add(input[j]);
        }

        result.add(partial);
        partial = new ArrayList<>();
      }
      k++;
    }
    return result;
  }

  public static void main(String[] args) {
    String[] input = {"a", "b", "c", "d"};
    List<List<String>> res = new AllNGramms().nGramms(input, 4);

    for(List<String> l : res)
      System.out.println(l);
  }
}