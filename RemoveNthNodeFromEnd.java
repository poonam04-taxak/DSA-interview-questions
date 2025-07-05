public class RemoveNthNodeFromEnd {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode remove(ListNode head,int n){
        if(head.next==null){
            return null;
        }
        //step1=count size
        int size=0;
        ListNode curr=head;
        while(curr!=null){
            curr=curr.next;
            size++;
        }
        //step2-> if we want to remove head
        if(n==size){
            return head.next;
        }
        //step3->traverse to the node just before target
        int indexToSearch=size-n;
        ListNode prev=head;
        int i=1;
        while(i<indexToSearch){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;//skip 4
        return head;
    }
     public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
         // Create linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        int n = 2; // remove 2nd node from end (4 in this case)

        head = remove(head, n);

        System.out.println("List after removing " + n + "th node from end:");
        printList(head);
    }
}
