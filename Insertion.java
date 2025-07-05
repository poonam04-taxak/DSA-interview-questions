import java.util.Scanner;

public class Insertion {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    //insert at head
    public static Node insertHead(Node head,int data){
        Node newNode=new Node(data);
        newNode.next=head;
        head=newNode;
        return head;
    }
    //insert at tail
    public static Node insertTail(Node head,int data){
        Node newNode=new Node(data);
        if(head==null){
            return newNode;
        }
        Node temp=head;
        while(temp.next!=null){
       temp=temp.next;
        }
        temp.next=newNode;
        return head;
    }
    //at pos
    public static Node insertPos(Node head,int data,int pos){
        Node newNode=new Node(data);
        if(pos==0){
            newNode.next=head;
            return newNode;
        }
        Node temp=head;
        for(int i=0;i<pos-1 &&temp!=null;i++){
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("pos out of bounds");
            return head;
        }
        newNode.next=temp.next;
        temp.next=newNode;
        return head;
    }
     public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
        Node head = null;

        head = insertHead(head, 30);
        head = insertHead(head, 20);
        head = insertHead(head, 10);
        System.out.println("After inserting at head:");
        printList(head);

        head = insertTail(head, 40);
        head = insertTail(head, 50);
        System.out.println("After inserting at tail:");
        printList(head);

        head = insertPos(head, 25, 2);
        System.out.println("After inserting 25 at position 2:");
        printList(head);

        sc.close();   
    }
}
