package linklist;

public class CycleList {
  public static ListNode detectCycle(ListNode head) {
    if (head == null) {
      return head;
    }

    if (head.next == null)
      return null;

    ListNode front = head.next;

    ListNode behind = head;

    int cycleSize = 0;
    //如果有环，front一定会追上behind
    while (front != behind) {
      if (behind.next == null) {
        return null;
      }
      //behind 一次走一步
      behind = behind.next;

      if (front.next == null || front.next.next == null) {
        return null;

      }
      //front 一次走两步
      front = front.next.next;
      cycleSize++;
    }
    cycleSize++;


    while (true) {
      ListNode node = head;
      int temp = cycleSize;
      while (temp > 0) {
        node = node.next;
        temp--;
      }
      if (node == head)
        return head;
      head = head.next;
    }
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(1);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(3);
    ListNode l4 = new ListNode(4);
    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    l4.next = l2;
    System.out.println(detectCycle(l1).val);
  }

}
