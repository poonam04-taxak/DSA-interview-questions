public class LinkedListCycle2 {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node detectCycle(Node head){
        
        Node slow=head;
        Node fast=head;
//step1->detect cycle
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                //step2->find entry point of cycle
                Node entry=head;
                while(entry!=slow){
                     entry=entry.next;
                     slow=slow.next;
                }
                return entry;
            }
        }
        return null;//no cycle
    }
    public static void main(String[] args) {
         Node head = new Node(3);
        Node node2 = new Node(2);
        Node node0 = new Node(0);
        Node nodeMinus4 = new Node(-4);

        head.next = node2;
        node2.next = node0;
        node0.next = nodeMinus4;
        nodeMinus4.next = node2; // creating cycle starting at node with data = 2

        Node cycleStart = detectCycle(head);

        if (cycleStart != null) {
            System.out.println("Cycle starts at node with data: " + cycleStart.data);
        } else {
            System.out.println("No cycle detected.");
        }
    }
    }
