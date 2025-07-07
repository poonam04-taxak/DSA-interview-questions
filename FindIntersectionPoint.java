public class FindIntersectionPoint {
    static class Node{
   int data;
   Node next;

   Node(int data){
    this.data=data;
    this.next=null;
   }

    }
    //two pointers with resetting
    public static Node intersectPoint(Node headA,Node headB){
        if(headA==null || headB==null){
            return null;
        }
        Node a=headA;
        Node b=headB;

        while(a!=b){
            a=(a==null)?headB:a.next;
            b=(b==null)?headA:b.next;
        }
        return a;//intersection node or null

    }
    public static void main(String[] args) {
        //create shared intersection part
        Node intersect=new Node(8);
        intersect.next=new Node(10);
        //create list1
        Node headA=new Node(3);
        headA.next=new Node(7);
        headA.next.next=intersect;

        //create list 2
        Node headB=new Node(99);
        headB.next=new Node(1);
        headB.next.next=intersect;

        Node result=intersectPoint(headA,headB);
        if(result!=null){
            System.out.println("intersection point is:"+result.data);
        }
        else{
            System.out.println("null intersection point");
        }
    }
}
/*✏️ How are pointers moved?
java
Copy
Edit
a = (a == null) ? headB : a.next;
b = (b == null) ? headA : b.next;
✅ Meaning:
If a reaches the end (null), jump it to the head of the other list (headB).

If b reaches the end (null), jump it to the head of the other list (headA).

Otherwise, move forward (a.next, b.next) as usual.

 */