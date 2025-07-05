public class ReverseLL {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    //reverse list
    public static Node reverse(Node head){
        Node prev=null;
        Node curr=head;

        while(curr!=null){
            Node next=curr.next;//store next
            curr.next=prev;//reverse
            //update curr and prev
            prev=curr;
            curr=next;

        }
        return prev;
    }
    //tarverse
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
        head.next.next.next=new Node(40);
        System.out.println("original list");
        printList(head);

        head=reverse(head);
        System.out.println("reversed list:");
        printList(head);

    }
}
