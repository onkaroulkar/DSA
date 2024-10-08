package com.dsa.problem;

public class QueueLinkedList {
     static class Node {
         int data;
         Node next;

         Node(int data) {
             this.data = data;
             next = null;
         }
     }

      static class Queue{
          Node head = null;
          Node tail = null;

         public boolean isEmpty(){
             return head == null && tail == null;
         }

         // time complexity o(1)
         public void add(int data){
             Node newNode = new Node(data);
             if(tail == null){
                 tail = head = newNode;
                 return;
             }
             tail.next = newNode;
             tail = newNode;
         }

          // time complexity o(1)
         public int remove(){
             if(isEmpty()){
                 System.out.println("Queue is Empty");
             }
             int result = head.data;
             if(head == tail){
                 tail = null;
             }
             head = head.next;
             return result;
         }

          // time complexity o(1)
         public int peek(){
             if(isEmpty()){
                 System.out.println("Queue is Empty");
                 return -1;
             }

             int result = head.data;
             return result;
         }
     }
    public static void main(String[] args) {

        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
