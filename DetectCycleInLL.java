public class DetectCycleInLL {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static boolean hasCycle(Node head){
        if(head==null || head.next==null){
            return false;//list too short to form a cycle
        }
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){
                return true;//cycle
            }
        }
        return false;

    }
    public static void main(String[] args) {
        Node head=new Node(3);
        head.next=new Node(2);
        head.next.next=new Node(0);
        head.next.next.next=new Node(-4);

        //create cycle
        head.next.next.next.next=head.next;
        System.out.println("cycle detected:"+hasCycle(head));

        // Create a new list without cycle: 1 -> 2 -> 3
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);

        System.out.println("Cycle detected: " + hasCycle(head2)); // Output: false
    }
}
