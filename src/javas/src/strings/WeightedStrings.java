package strings;

import java.util.*;

public class WeightedStrings {

  public String calc(Long target){
    return solve(target, ""); 
  }

  private String solve(Long target, String res){
    if(target == 0) return res;
    
    Character c = weights().get(target);
    if(c!=null) return c.toString() + res;

    Long i = target;
    while(c == null){
      i--; c = weights().get(i);
    }
      
    return solve(target - i, c.toString() + res);
  }
  private HashMap<Long, Character> internalWeights;
  public HashMap<Long, Character> weights(){
    if(internalWeights == null){
      internalWeights = new HashMap<Long, Character>(26);

      internalWeights.put(Long.valueOf(1), (char)65);
      long prev = 1;
      for(int i=2; i<= 26;i++){
        long current = i*prev + prev;
  
        Character c = (char)(65 + i-1);
        internalWeights.put(current, c);
  
        prev = current;
        // System.out.println(c + " -> " + current);
      }
    }

    return internalWeights;
  }

  public static void main(String[] args) {
    WeightedStrings ws = new WeightedStrings();
    Long target = Long.valueOf(20);
    System.out.print("Target: " + target + " = " + ws.calc(target));
  }
}