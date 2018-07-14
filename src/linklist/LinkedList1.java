package linklist;

public class LinkedList1 {

    public static ListNode insertionSortList(ListNode head) {
        if (head == null)
            return head;

        ListNode current = head.next;
        ListNode pre = head;
        ListNode voidNode = new ListNode(-1);
        voidNode.next = head;

        while (current != null) {
            ListNode sortCurrent = voidNode.next;
            ListNode sortPre = voidNode;
            ListNode tmp = null;
            while (current != sortCurrent) {
                if (sortCurrent.val <= current.val) {
                    sortPre = sortCurrent;
                    sortCurrent = sortCurrent.next;
                    tmp = sortCurrent.next;
                } else {
                    tmp = current.next;
                    current.next = sortCurrent;
                    sortPre.next = current;
                    pre.next = tmp;
                    break;
                }
            }
            pre = current;
            current = tmp;
        }

        return voidNode.next;
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head = new ListNode(-1);
        ListNode pointer = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pointer.next = list1;
                list1 = list1.next;
            } else {
                pointer.next = list2;
                list2 = list2.next;
            }
            pointer = pointer.next;
        }

        while (list1 != null) {
            pointer.next = list1;
            list1 = list1.next;
            pointer = pointer.next;
        }

        while (list2 != null) {
            pointer.next = list2;
            list2 = list2.next;
            pointer = pointer.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        //4,19,14,5,-3,1,8,5,11,15
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(19);
        ListNode l3 = new ListNode(14);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(-3);
        ListNode l6 = new ListNode(1);
        ListNode l7 = new ListNode(8);
        ListNode l8 = new ListNode(5);
        ListNode l9 = new ListNode(11);
        ListNode l10 = new ListNode(15);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l10;
        ListNode aa = l1;
        while (aa != null) {
            System.out.print(aa.val + " ");
            aa = aa.next;
        }
        System.out.println("");

        ListNode head = LinkedList1.insertionSortList(l1);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

}
