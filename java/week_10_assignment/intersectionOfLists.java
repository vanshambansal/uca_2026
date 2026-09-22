package week_10_assignment;


public class intersectionOfLists {

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

    Node intersection(Node temp1, Node temp2) {
        Node dummy = new Node(-1);
        Node temp = dummy;

        while (temp1 != null && temp2 != null) {
            if (temp1.val == temp2.val) {
                temp.next = new Node(temp1.val);
                temp1 = temp1.next;
                temp2 = temp2.next;
                temp = temp.next;
            } else if (temp1.val < temp2.val) {
                temp1 = temp1.next;
            } else {
                temp2 = temp2.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        intersectionOfLists obj1 = new intersectionOfLists();
        obj1.insert(10);
        obj1.insert(20);
        obj1.insert(20);
        obj1.insert(30);
        obj1.insert(40);

        intersectionOfLists obj2 = new intersectionOfLists();
        obj2.insert(20);
        obj2.insert(20);
        obj2.insert(25);
        obj2.insert(40);
        obj2.insert(50);

        intersectionOfLists result = new intersectionOfLists();
        result.head = result.intersection(obj1.head, obj2.head);

        result.print();

    }

}
