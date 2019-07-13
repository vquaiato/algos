package strings;

import java.math.BigInteger;

public class WeightedStrings {
  private BigInteger[] internalWeights;
  private BigInteger[] weights(){
    if(internalWeights == null){
      internalWeights = new BigInteger[27];
      internalWeights[0] = new BigInteger(Integer.toString(Integer.MIN_VALUE));

      internalWeights[1] = BigInteger.valueOf(Long.valueOf(1));
      for(int i=2; i<= 26;i++)
        internalWeights[i] = BigInteger.valueOf(Long.valueOf(i))
                                        .multiply(internalWeights[i-1])
                                        .add(internalWeights[i-1]);
    }

    return internalWeights;
  }

  public WeightedStrings() {
    weights();
  }

  public String calc(BigInteger target) {
    return solve(target, 1, ""); 
  }

  private String solve(BigInteger target, int lastPos, String res) {
    if(target.compareTo(new BigInteger("0")) == 0) return res;
    
    if(weights()[lastPos] == target)
      return Character.valueOf((char)(64 + lastPos)) + res;

    while(lastPos < (weights().length - 1) && weights()[lastPos].compareTo(target) <= 0)
      lastPos++;

    while(weights()[lastPos].compareTo(target) > 0 && lastPos > 0)
      lastPos--;
    
    return solve(target.subtract(weights()[lastPos]), lastPos, Character.valueOf((char)(64 + lastPos)) + res);
  }
  public static void main(String[] args) {
    WeightedStrings ws = new WeightedStrings();
    BigInteger target = new BigInteger("2520");
    System.out.print("Target: " + target + " = " + ws.calc(target));
  }
}