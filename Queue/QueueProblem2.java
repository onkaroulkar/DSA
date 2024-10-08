package com.dsa.problem;

import java.util.Stack;

public class QueueProblem2 {
    static class Queue{ static Stack<Integer> stack1 = new Stack<>();
       static Stack<Integer> stack2 = new Stack<>();

        static boolean isEmpty(){
            return stack1.isEmpty();
        }

        static void add(int data){
            stack1.push(data);
        }

        static int remove(){
            int result = 0;
            if(stack2.isEmpty()){
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }else{
                System.out.println("Queue is Empty");
            }

            if(!stack2.isEmpty()){
                 result = stack2.pop();
            }
            return result;
        }

        static int peek(){
            int result = 0;
            if(stack2.isEmpty()){
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }else{
                System.out.println("Queue is Empty");
            }

            if(!stack2.isEmpty()){
                result = stack2.peek();
            }

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
