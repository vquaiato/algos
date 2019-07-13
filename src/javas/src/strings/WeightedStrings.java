package strings;

public class WeightedStrings {

  private Long[] internalWeights;
  public Long[] weights(){
    if(internalWeights == null){
      internalWeights = new Long[27];
      internalWeights[0] = Long.MIN_VALUE;

      internalWeights[1] = Long.valueOf(1);
      for(int i=2; i<= 26;i++)
        internalWeights[i] =(i*internalWeights[i-1]) + internalWeights[i-1];
    }

    return internalWeights;
  }

  public String calc(Long target) {
    return solve(target, 1, ""); 
  }

  private String solve(Long target, int lastPos, String res) {
    if(target == 0) return res;
    
    if(weights()[lastPos] == target)
      return Character.valueOf((char)(64 + lastPos)) + res;

    while(weights()[lastPos] <= target && lastPos < weights().length)
      lastPos++;

    while(weights()[lastPos] > target && lastPos > 0)
      lastPos--;
    
    return solve(target - weights()[lastPos], lastPos, Character.valueOf((char)(64 + lastPos)) + res);
  }
  public static void main(String[] args) {
    WeightedStrings ws = new WeightedStrings();
    Long target = Long.valueOf(100);
    System.out.print("Target: " + target + " = " + ws.calc(target));
  }
}