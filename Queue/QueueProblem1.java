package com.dsa.problem;

import java.util.Stack;

// Implement Queue using two stack (microsoft/google)
public class QueueProblem1 {
    static class Queue{
       static  Stack<Integer> st1 =  new Stack<>();
        static Stack<Integer> st2 = new Stack<>();

        static boolean isEmpty(){
            return st1.isEmpty();
        }

        public static void add(int data){
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }

            st1.push(data);

            while(!st2.isEmpty()){
                st1.push(st2.pop());
            }
        }

        public static int remove(){
            if(st1.isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }

            int result = st1.pop();
            return result;
        }

        public static int peek(){
            if(st1.isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            int result = st1.peek();
            return result;
        }
    }
    public static void main(String[] args) {

        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
