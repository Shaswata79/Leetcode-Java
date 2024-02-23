
public class MergeList {

    private static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null){
            return list1;
        }else if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }

        ListNode head = list2;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                ListNode temp = list1.next;
                head = list1;
                list1.next = list2;
                list2 = head;
                list1 = temp;
            }else{
                if(list1.val >= list2.val && list2.next == null){
                    list2.next = list1;
                    break;
                }else if(list1.val == list2.val || (list1.val > list2.val && list1.val < list2.next.val)) {
                    ListNode temp = list1.next;
                    list1.next = list2.next;
                    list2.next = list1;
                    list1 = temp;
                }
                list2 = list2.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-9);
        l1.next = new ListNode(3);
        //l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(7);
        //l2.next.next = new ListNode(4);

        ListNode l3 = mergeTwoLists(l1, l2);
        while (l3 != null){
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }
}
