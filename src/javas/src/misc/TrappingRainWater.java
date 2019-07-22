package misc;

import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater {
  public int trap(int[] h) {
    if (h.length < 3) return 0;

    Deque<Integer> s = new ArrayDeque<Integer>();
    int current = h[0];
    int total = 0;

    for (int i = 1; i < h.length; i++) {
      if (h[i] < current) {
        s.push(h[i]);
      } else {
        while (!s.isEmpty()) { total += (current - s.pop()); }
        current = h[i];
      }
    }
    
    if (!s.isEmpty()) {
        int ch = s.pop();
        if(ch < current)
          current = ch;

        while(!s.isEmpty()){
          ch = s.pop();
          if(current - ch > 0){ total += current - ch; }
          else { current = ch; }
        }
      }

    return total;
  }

  public static void main(String[] args) {
    TrappingRainWater t = new TrappingRainWater();
    //0, 1, 0, 2, 1, 0, 1, 1, 2, 1, 2, 1
    //3,0,0,1
    //3,0,1,0,3
    //0,1,2,3,4,5
    //5,4,3,2,1
    //5,4,3,2,1,5

    int r = t.trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    System.out.println(r);
  }
}