package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindCommonCharacters{
  public List<String> commonChars(String[] words) {
    List<String> res = new ArrayList<>();
    if(words == null || words.length == 0) return res;

    HashMap<Character, Integer> map = new HashMap<>(26);
    for(char c : words[0].toCharArray())
      map.put(c, map.getOrDefault(c, 0) + 1);

    HashMap<Character, Integer> tempMap;
    for(int i=1;i<words.length;i++){
      tempMap = new HashMap<>(map.size());

      for(char c : words[i].toCharArray()){
        if(map.containsKey(c)){
          tempMap.put(c, tempMap.getOrDefault(c, 0) + 1);
          map.put(c, map.getOrDefault(c, 0) - 1);
          map.remove(c,0);
        }
      }
      map = tempMap;
      tempMap = null;
    }

    for(char c : map.keySet())
      for(int i=0;i<map.get(c);i++)
        res.add(Character.toString(c));

    return res;
  }

  public static void main(String[] args) {
    // var input = new String[]{"bella", "label", "roller"};
    // var input = new String[]{"cool", "lock", "cook"};
    // var input = new String[]{"cool"};
    var input = new String[]{"cool", "looc"};
    // var input = new String[]{"cool", "looca"};
    // var input = new String[]{"aaaaa", "aaaa", "aaaaaaaaa"};
    System.out.println(new FindCommonCharacters().commonChars(input));
  }
}