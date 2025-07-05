
import java.util.Scanner;

public class Deletion {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static Node deleteAtHead(Node head) {
        if (head == null) {
            System.out.println("List is empty");
            return null;
        }
        return head.next;
    }

    public static Node deleteAtTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static Node deleteAtPosition(Node head, int position) {
        if (head == null) {
            System.out.println("List is empty");
            return null;
        }
        if (position == 0) {
            return head.next;
        }
        Node temp = head;
        for (int i = 0; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Position out of bounds");
            return head;
        }
        temp.next = temp.next.next;
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;

        // Creating 10 -> 20 -> 30 -> 40 -> 50
        head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        System.out.println("Initial List:");
        printList(head);

        head = deleteAtHead(head);
        System.out.println("After deleting head:");
        printList(head);

        head = deleteAtTail(head);
        System.out.println("After deleting tail:");
        printList(head);

        head = deleteAtPosition(head, 1);
        System.out.println("After deleting at position 1:");
        printList(head);

        sc.close();
    }
}
