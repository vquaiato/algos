package linkedlists;

public class Merge {
  public ListNode mergeTwoListsNewList(ListNode l1, ListNode l2) {
    return mergeTwoListsNewList(l1, l2, null);
  }

  public ListNode mergeTwoListsNewList(ListNode l1, ListNode l2, ListNode res) {
    if (l1 == null && l2 == null)
      return res;

    if (l1 == null) {
      res = insert(l2, res);
      l2 = l2.next;
    } else if (l2 == null) {
      res = insert(l1, res);
      l1 = l1.next;
    } else {
      if ((int)l1.data >= (int)l2.data) {
        res = insert(l2, res);
        l2 = l2.next;
      } else {
        res = insert(l1, res);
        l1 = l1.next;
      }
    }

    return mergeTwoListsNewList(l1, l2, res);
  }

  private ListNode insert(ListNode o, ListNode dest) {
    ListNode n = new ListNode(o.data);
    if (dest == null)
      dest = n;
    else {
      ListNode l = dest;
      while (l.next != null)
        l = l.next;

      l.next = n;
    }

    return dest;
  }


  public ListNode mergeTwoLists(ListNode l1, ListNode l2){
    if(l1 == null) return l2;
    if(l2 == null) return l1;

    if((int)l1.data < (int)l2.data){
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    }
    else
    {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }
  }
  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(4);
    l1.next.next.next = new ListNode(5);
    l1.next.next.next.next = new ListNode(6);

    ListNode l2 = new ListNode(1);
    l2.next = new ListNode(3);
    l2.next.next = new ListNode(10);

    ListNode res = new Merge().mergeTwoLists(l1, l2);
    while (res != null) {
      System.out.println(res.data);
      res = res.next;
    }
  }
}