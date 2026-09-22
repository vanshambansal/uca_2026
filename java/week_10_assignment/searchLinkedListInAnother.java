package week_10_assignment;

public class searchLinkedListInAnother {
    Node head;

    static class Node {
        Node next;
        int val;
        Node(int val) {
            this.val = val;
            next = null;
        }
    }

    void insert(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

    }

    void print() {

        Node temp = head;

        while (temp != null) {
            if (temp.next == null) System.out.print(temp.val);
            else System.out.print(temp.val + "->");

            temp = temp.next;
        }
        System.out.println();
    }

    boolean searchHelper(Node temp1, Node temp2) {

        while (temp1 !=null && temp2 != null) {
            if (temp1.val != temp2.val) return false;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        if (temp1 != null) return false;
        return true;
    }

    boolean search(Node temp1, Node temp2) {

        if (temp1 == null) return true;

        while (temp2 != null) {
            if (temp1.val == temp2.val) {
                boolean flag = searchHelper(temp1, temp2);
                if (flag) return true;
            }
            temp2 = temp2.next;
        }

        return false;

    }

    public static void main(String[] args) {

        searchLinkedListInAnother obj1 = new searchLinkedListInAnother();
        obj1.insert(20);
        obj1.insert(25);
        obj1.insert(40);

        searchLinkedListInAnother obj2 = new searchLinkedListInAnother();
        obj2.insert(20);
        obj2.insert(20);
        obj2.insert(25);
        obj2.insert(40);
        obj2.insert(50);

        searchLinkedListInAnother result = new searchLinkedListInAnother();
        boolean ans = result.search(obj1.head, obj2.head);

        System.out.println(ans);
    }

}
