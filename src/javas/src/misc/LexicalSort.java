package misc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


// give N lists of strings
// keep the order of lists that contains only digits from second chunk
// for the other lists, sort them lexically

public class LexicalSort {
  private boolean isPrimeOrder(List<String> order){
    for (Character c : order.get(1).toCharArray())
      if(!Character.isDigit(c))
        return true;

    return false;
  }
  public List<List<String>> Sort(List<List<String>> orders){
    Stack<List<String>> nonPrimes = new Stack<>();
    List<List<String>> primes = new LinkedList<>();
    
    for (List<String> o : orders) {
      if(isPrimeOrder(o)) primes.add(o);
      else nonPrimes.add(o);
    }

    Comparator<List<String>> comparator = (a, b) -> {
        for(int i = 0; i < a.size();i++){
          if(b.size() == i) return 1;
          int diffResult = a.get(i).compareTo(b.get(i));
          if(diffResult != 0)
            return diffResult;
        }

        if(b.size() > a.size()) return -1;
        else return 0;
      };
    primes.sort(comparator);

    for(List<String> n : nonPrimes)
      primes.add(n);

    return primes;
  }

  public static void main(String[] args){
    List<List<String>> orders = Arrays.asList(
      Arrays.asList(new String[]{"ab1", "123"}), 
      Arrays.asList(new String[]{"ab0", "999"}),
      Arrays.asList(new String[]{"ab0", "zzz"}),
      Arrays.asList(new String[]{"ab3", "aaa", "xyz"}),
      Arrays.asList(new String[]{"ab3", "aaa"}));
    
    for (List<String> sorted : new LexicalSort().Sort(orders)) {
      System.out.println(sorted.toString());
    }
  }
}