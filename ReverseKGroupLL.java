
public class ReverseKGroupLL {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node reverseKGroup(Node head, int k) {
        if (head == null || k == 1) return head;

        Node ptr = head;
        int count = 0;

        // Step 1: Check if at least k nodes exist
        while (ptr != null && count < k) {
            ptr = ptr.next;
            count++;
        }

        if (count == k) {
            // Step 2: Reverse first k nodes
            Node prev = null;
            Node curr = head;
            Node next = null;
            int i = 0;

            while (i < k && curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                i++;
            }

            // Step 3: Recursively reverse the next groups
            head.next = reverseKGroup(next, k);

            // Return new head after reversing k nodes
            return prev;
        }

        return head; // If nodes < k, return as is
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original List:");
        printList(head);

        int k = 2;
        head = reverseKGroup(head, k);

        System.out.println("List after reversing in k-group (k = " + k + "):");
        printList(head);
    }
}
