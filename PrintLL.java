public class PrintLL {
static class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        this.next=null;
    }
}
    //traverse the linked list
    public static void printList(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data + "->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
     Node head=new Node(10);
     head.next=new Node(20);
     head.next.next=new Node(30);

     System.out.println("your linked list is:");
     printList(head);
    }
}
