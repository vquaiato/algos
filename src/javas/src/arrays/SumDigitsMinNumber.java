package arrays;

public class SumDigitsMinNumber{
  public int sum(int[] numbers){
    if(numbers == null || numbers.length == 0) return 0;
    
    int min = Integer.MAX_VALUE;
    for(int n : numbers)
      if(n < min) min = n;

    int sum = 0;
    while(min > 0){
      sum += min%10;
      min/=10;
    }

    return sum % 2 == 0 ? 1 : 0;
  }

  public static void main(String[] args) {
    System.out.println(new SumDigitsMinNumber().sum(new int[]{999,1000}));
  }
}