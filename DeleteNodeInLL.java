
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class DeleteNodeInLL {
    // Function to delete the given node
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;           // Step 1: copy next node's value
        node.next = node.next.next;         // Step 2: skip the next node
    }

    // Helper to print the linked list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create linked list: 4 -> 5 -> 1 -> 9
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        System.out.println("Before deletion:");
        printList(head);

        // We want to delete node with value 5
        ListNode nodeToDelete = head.next; // This is the node with value 5

        deleteNode(nodeToDelete);

        System.out.println("After deletion:");
        printList(head);
    }
}
