package class_ques;

// Merge k Sorted Lists
// YOU ARE GIVEN A ARRAY WHICH ARE LINEKDLIST SORTED INDIVIDUALLY RETURN MERGED SORTED LINKED LIST


import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode () {}
    ListNode (int val) {
        this.val = val;
    }
    ListNode (int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class mergeKLinkedList {


    // UNOPTIMAL SOLUTION - USING ARRAYlIST

//    public ListNode mergeKLists (ListNode[] lists) {
//
//        ArrayList<Integer> arr = new ArrayList<>();
//
//        for(int i = 0; i < lists.length; i++) {
//
//            ListNode temp = lists[i];
//
//            while(temp != null){
//                arr.add(temp.val);
//                temp = temp.next;
//            }
//        }
//        Collections.sort(arr);
//
//        ListNode dummy = new ListNode(-1);
//        ListNode temp = dummy;
//
//        for (int i = 0; i < arr.size(); i++) {
//            ListNode newNode = new ListNode(arr.get(i));
//            temp.next = newNode;
//            temp = temp.next;
//        }
//        return dummy.next;
//
//    }


    // USE DIVIDE AND CONQUER APPROACH nlog(k)

//    public ListNode mergeKLists (ListNode []lists) {
//        if(lists == null || lists.length == 0) {
//            return null;
//        }
//        return merge (lists, 0, lists.length - 1);
//    }
//
//    public ListNode merge (ListNode []lists, int low, int high) {
//
//        if(low == high) {
//            return lists[low];
//        }
//
//        int mid = (low + high) / 2;
//
//        ListNode left = merge(lists, low, mid);
//        ListNode right = merge(lists, mid + 1, high);
//
//        return mergeTwo(left, right);
//    }
//
//    public ListNode mergeTwo (ListNode l1, ListNode l2) {
//
//        ListNode dummy = new ListNode(-1);
//        ListNode temp = dummy;
//
//        while (l1 != null && l2 != null) {
//
//            if (l1.val <= l2.val) {
//                temp.next = l1;
//                l1 = l1.next;
//            } else {
//                temp.next = l2;
//                l2 = l2.next;
//            }
//            temp = temp.next;
//
//        }
//        if(l1 != null) {
//            temp.next = l1;
//        } else {
//            temp.next = l2;
//        }
//        return dummy.next;
//
//    }



    // BY PRITORITY QUEUE ACTUAL SOLUTION N LOG(k)



    public ListNode mergeKLists (ListNode []lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> (a.val - b.val));

        for (ListNode list : lists) {
            pq.add(list);
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (! pq.isEmpty()) {

            ListNode smallest = pq.poll();
            curr.next = smallest;
            curr = curr.next;

            if (smallest.next != null) {
               pq.add(smallest.next);
            }

        }
        return dummy.next;
    }



    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};

        mergeKLinkedList obj = new mergeKLinkedList();

        ListNode head = obj.mergeKLists(lists);

        while (head != null) {
            System.out.print(head.val);
            if (head.next != null)
                System.out.print(" -> ");
            head = head.next;
        }


    }
}
