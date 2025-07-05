public class MergeTwoSortedLL {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    //sorted method
    public static Node sorted(Node list1,Node list2){
        if(list1==null ){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        
        //case 1
        if(list1.data<=list2.data){
            list1.next=sorted(list1.next,list2);
            return list1;
        }
        else{
            //case2
            list2.next=sorted(list1,list2.next);
            return list2;
        }
    }
    //print list
    public static void printLL(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.data + "->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
 Node list1 = new Node(1);
        list1.next = new Node(3);
        list1.next.next = new Node(5);

        Node list2 = new Node(2);
        list2.next = new Node(4);
        list2.next.next = new Node(6);

        System.out.println("List 1:");
        printLL(list1);
        System.out.println("List 2:");
        printLL(list2);

        Node merged = sorted(list1, list2);
        System.out.println("Merged Sorted List:");
        printLL(merged);       
    }
}
