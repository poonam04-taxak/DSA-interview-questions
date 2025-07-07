public class PalindromeLL {
    static class Node{
        int data;
     Node next;
     Node(int data){
        this.data=data;
        this.next=null;
     }
    }
    public static boolean isPalindrome(Node head){
        if(head==null || head.next==null){
            return true;

        }
        //step1->find middle
        Node slow=head;
      Node fast=head;

      while(fast!=null && fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;

      }
      //reverse the second half
      Node secHalf=reverse(slow);
      Node firstHalf=head;

      //step3->compare first half and sec
      while(secHalf!=null){
        if(firstHalf.data!=secHalf.data){
            return false;
        }
        firstHalf=firstHalf.next;
        secHalf=secHalf.next;

      }
      return true;
    }
    //helper to reverse a secHalf
    public static Node reverse(Node head){
        Node prev=null;
        Node curr=head;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
          prev=curr;
          curr=next;
        }
        return prev;
    }
    public static void printlist(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+ " ->");
            curr=curr.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);

        System.out.println("Linked List:");
        printlist(head);

        boolean result = isPalindrome(head);
        System.out.println("Is Palindrome: " + result);
    }
}
