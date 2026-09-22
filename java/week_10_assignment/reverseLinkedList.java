package week_10_assignment;

import java.util.LinkedList;

class Node {
    Node next;
    int val;
    Node(int val) {
        this.val = val;
        next = null;
    }
}

public class reverseLinkedList {

    static void print(Node head) {

        Node temp = head;

        while (temp != null) {
            if (temp.next == null) System.out.print(temp.val);
            else System.out.print(temp.val + "->");

            temp = temp.next;
        }
        System.out.println();
    }

    static Node reverse(Node head) {

        if (head == null || head.next == null) return head;

        Node temp = head.next;
        Node newHead = reverse(temp);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        print(head);
        Node newHead = reverse(head);
        print(newHead);

    }
}
