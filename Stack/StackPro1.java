package com.onkar;

import java.util.Stack;

public class StackPro1 {

    public static void addAtBottom(int data, Stack<Integer>stack){
        if(stack.isEmpty()){
            stack.push(data);
            return;
        }
        int top =stack.pop();
        addAtBottom(data,stack);
        stack.push(top);

    }

    public static void reverse(Stack<Integer>stack){
        if(stack.isEmpty()){
            return;
        }
        int top = stack.pop();
        reverse(stack);
        addAtBottom(top,stack);
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        //addAtBottom(4,stack);
        reverse(stack);
        while(!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
