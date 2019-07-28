// https://leetcode.com/problems/subdomain-visit-count/
package misc.arrays;

import java.util.*;

public class SubdomainVisitCount {
  public List<String> subdomainVisits(String[] domains) {
    List<String> result = new ArrayList<>();
    if(domains == null || domains.length == 0) return result;

    HashMap<String, Integer> map = new HashMap<>(domains.length * 3);
    String[] aux, subdomains;
    int visits;
    String currentDomain;

    for(String item : domains){
      aux = item.split(" ");
      visits = Integer.parseInt(aux[0]);
      subdomains = aux[1].split("\\.");

      currentDomain = "";
      for(int i=subdomains.length-1;i>=0;i--){
        currentDomain = subdomains[i] + (currentDomain.isEmpty() ? "" : ".") + currentDomain;
        map.put(currentDomain, map.getOrDefault(currentDomain, 0) + visits);
      }
    }

    for(Map.Entry<String, Integer> entry : map.entrySet())
      result.add(entry.getValue() + " " + entry.getKey());

    return result;
  }


  public static void main(String[] args) {
    // String[] input = {"1 google.com", "1 mail.google.com"};
    String[] input = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
    List<String> res = new SubdomainVisitCount().subdomainVisits(input);

    for(var r : res)
      System.out.println(r);
  }
}