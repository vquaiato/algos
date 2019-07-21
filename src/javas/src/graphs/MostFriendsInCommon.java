package graphs;

import java.util.*;

public class MostFriendsInCommon {
public int find(List<int[]> friends, int id){
  if(friends == null || friends.isEmpty()) return -1;

  Set<Integer> friendsOf = new HashSet<>(friends.size());
  HashMap<Integer, Integer> friendsOfCount = new HashMap<>(friends.size());

  int maxFriendsCount = Integer.MIN_VALUE, maxFriend = Integer.MIN_VALUE;
  for(int[] friend : friends)
  {
    if(friend[0] == id) friendsOf.add(friend[1]);
    else if(friend[1] == id) friendsOf.add(friend[0]);
  }

  int f = Integer.MIN_VALUE;
  Integer v;
  for(int[] friend : friends){
    if(friend[0] == id || friend[1] == id) continue;

    if(friendsOf.contains(friend[0]))
      f = friend[1];
    else if(friendsOf.contains(friend[1]))
      f = friend[0];

    v = friendsOfCount.put(f, friendsOfCount.getOrDefault(f, 0) + 1);
    if((v == null ? 0 : v) +1 > maxFriendsCount)
    {
      maxFriendsCount = (v == null ? 0 : v) +1;
      maxFriend = f;
    }
  }

  return maxFriend;
}

  public static void main(String[] args) {
    MostFriendsInCommon mfic = new MostFriendsInCommon();
    List<int[]> friends = Arrays.asList(new int[][]{{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 4}, {3,5}, {7,5},{8,5}, {1,7}});
    System.out.println(mfic.find(friends, 1));
  }
}