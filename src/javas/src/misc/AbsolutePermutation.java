package misc;

import java.util.HashSet;

public class AbsolutePermutation {
  static int[] absolutePermutation(int n, int k) {
    if(n == 1) return new int[]{1};
      if(n%2 != 0 && k != 0) return new int[] {-1};
      
      int[] res = new int[n];
      int i=0;

      if(k == 0){
        for(i=0;i<n;i++) res[i] = i+1;
        return res;
      }
      
      HashSet<Integer> seen = new HashSet<Integer>();
      while(i<n){
        if(seen.contains(i+1)){i++; continue;}

        int num = i+k+1;
        int dest = i+k;

        if(dest >= n) return new int[] {-1};

        res[i] = num; res[dest] = i+1;
        seen.add(i+1); seen.add(num);
        i++;
      }

      return res;
  }

  public static void main(String[] args){
    for(int i : absolutePermutation(10, 1))
      System.out.print(i + " ");
  }
}