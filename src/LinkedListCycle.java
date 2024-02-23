import java.util.HashMap;

public class LinkedListCycle {

    private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public boolean hasCycle(ListNode head) {
        HashMap<ListNode, Integer> listMap = new HashMap<>();
        while (head != null){
            if(!listMap.containsKey(head)){
                listMap.put(head, head.val);
            }else {
                return true;
            }
            head = head.next;
        }
        return false;
    }

}
