package org.example;



 class Node{
    int val ;
    Node next;

    Node(int val){
        this.val=val;
        this.next = null;
    }
}
public class LinkedList {
     Node head;

     public void add(Node node){
         if(head==null){
             head = node;
         }
         else{
             Node cur = head;
             while (cur.next!=null){
                 cur = cur.next;
             }
             cur.next = node;
         }
     }

     public void print(){
         Node cur = head;
         while (cur!=null){
             System.out.println(cur.val);
             cur = cur.next;
         }
     }

     public void delete(int val){
         Node pre = head;
         Node cur = pre.next;
         if(head.next==null){
             return;
         }
         while (cur.val!=val){
             cur = cur.next;
         }



     }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        l.add(n1);
        l.add(n2);
        l.add(n3);
        l.add(n4);



        l.print();
    }

}
