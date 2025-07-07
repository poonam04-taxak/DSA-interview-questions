
public class FlattenLinkedList {
    static class Node {
        int data;
        Node next;
        Node bottom;
        Node(int data) {
            this.data = data;
            this.next = null;
            this.bottom = null;
        }
    }

    // Merge two sorted bottom lists
    static Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node result;
        if (a.data < b.data) {
            result = a;
            result.bottom = merge(a.bottom, b);
        } else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }
        return result;
    }

    static Node flatten(Node root) {
        if (root == null || root.next == null) {
            return root;
        }
        root.next = flatten(root.next);
        root = merge(root, root.next);
        return root;
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.bottom;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.bottom = new Node(7);
        head.bottom.bottom = new Node(8);
        head.bottom.bottom.bottom = new Node(30);

        head.next = new Node(10);
        head.next.bottom = new Node(20);

        head.next.next = new Node(19);
        head.next.next.bottom = new Node(22);
        head.next.next.bottom.bottom = new Node(50);

        head.next.next.next = new Node(28);
        head.next.next.next.bottom = new Node(35);
        head.next.next.next.bottom.bottom = new Node(40);
        head.next.next.next.bottom.bottom.bottom = new Node(45);

        Node flatHead = flatten(head);
        System.out.println("Flattened list:");
        printList(flatHead);
    }
}
