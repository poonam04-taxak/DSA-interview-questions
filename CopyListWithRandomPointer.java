public class CopyListWithRandomPointer {
    static class Node{
        int data;
        Node next;
        Node random;

        Node(int data){
            this.data=data;
            this.next=null;
            this.random=null;
        }
    }
    public static Node randomCopy(Node head){
        if(head==null){
            return null;
        }
        //step1->Interleave copied nodes
        Node old=head;
        while(old!=null){
            Node CopyNode =new Node(old.data);
          CopyNode.next=old.next;
          old.next=CopyNode;
          old=CopyNode.next;

        }
        //step2->set random pointers
        old=head;
        while(old!=null){
            if(old.random!=null){
                old.next.random=old.random.next;
            }
            old=old.next.next;
        }
        //step3->separte lists
        old=head;
        Node dummy=new Node(0);
        Node currCopy=dummy;
        while(old!=null){
            currCopy.next=old.next;
            old.next=old.next.next;

            currCopy=currCopy.next;
            old=old.next;
        }
        return dummy.next;
    }
    // Utility function to print the list along with random pointers
    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            int randomVal = (curr.random != null) ? curr.random.data : -1;
            System.out.println("Node val: " + curr.data + ", Random points to: " + randomVal);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        // Creating the original list
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // Setting up random pointers
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        System.out.println("Original List:");
        printList(node1);

        Node copiedHead = randomCopy(node1);

        System.out.println("\nCopied List:");
        printList(copiedHead);
}
}
