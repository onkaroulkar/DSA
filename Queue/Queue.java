package com.onkar;
// Queue using array.
public class Queue {

    static int arr [];
    static int size;
    static int rear = -1;
    Queue(int size){
        arr = new int[size];
        this.size = size;
    }

   public static boolean isEmpty(){
        return rear == -1;
    }

    // enqueue
    public static void add(int data){
        if(rear == size-1){
            System.out.println("Queue is full");
            return;
        }
        rear++;
        arr[rear]= data;
    }

    // dqueue
    public static int remove(){
        if (isEmpty()){
            System.out.println("queue is empty");
            return -1;
        }
        int top = arr[0];
        for(int i =0;i<rear;i++){
            arr[i]=arr[i+1];
        }
        rear--;
        return top;
    }

    // peek
    public static int peek(){
        if (isEmpty()){
            System.out.println("queue is empty");
            return -1;
        }
        int top = arr[0];
        return top;
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }

    }
}
