package com.onkar;

public class LinkedList {
    Node head;
    private int size;
    LinkedList(){
        this.size = 0;
    }
    class Node{
        String data;
        Node next;
        Node(String data){
            this.data = data;
            this.next = null;
            size++;
        }
    }

    // add first
    public void addFirst(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // add last
    public void addLast(String data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            return;
        }
        Node currentNode = head;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next =newNode;
    }

    // print list
    public void printList(){
        if(head == null){
            System.out.print("list is empty");
            return;
        }
        Node currentNode = head;
        while (currentNode != null){
            System.out.print(currentNode.data + "->");
            currentNode = currentNode.next;
        }
        System.out.print("NULL");
        System.out.println();
    }

    // delete first
    public void deleteFirst(){
        if(head == null){
            System.out.println("list is empty");
            return;
        }
        size--;
        head = head.next;
    }

    // delete last
    public void deleteLast(){
        if(head == null){
            System.out.println("list is empty");
            return;
        }
        size--;
        if(head.next == null){
            head = null;
            return;
        }

        Node secondLast = head;
        Node lastNode = head.next;
        while(lastNode.next != null){
            lastNode = lastNode.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }

    // size
    public int getSize(){
        return size;
    }

    // reverse a linked list
    public void reverseIterate(){
        if(head == null || head.next == null){
            return;
        }

        Node prvNode = head;
        Node currNode = head.next;
        while(currNode != null){
            Node nextNode = currNode.next;
            currNode.next = prvNode;

            //update
            prvNode = currNode;
            currNode = nextNode;
        }

        head.next = null;
        head = prvNode;
    }

    // Insert at the given index
    public void addInMiddle(int index,String data){
        if(index > size || index < 0 ){
            System.out.println("invalid index");
            return;
        }
        size++;

        Node newNode = new Node(data);
        if (head == null || index == 0){
            newNode.next = head;
            head = newNode;
        }

        Node currNode = this.head;
        for(int i = 1;i <size;i++){
            if(i == index){
                Node nextNode = currNode.next;
                currNode.next = newNode;
                newNode.next = nextNode;
                break;
            }
            currNode = currNode.next;
        }
    }

    // reverse linked list using recursion
    public Node reverseRecursive(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node newNode = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        /*ll.addFirst("a");
        ll.addFirst("is");
        ll.addLast("list");
        ll.addFirst("this");
        ll.printList();
        ll.deleteLast();
        ll.deleteFirst();
        ll.printList();
        System.out.println(ll.getSize());*/
        ll.addLast("1");
        ll.addLast("2");
        ll.addLast("3");
        ll.addLast("4");
        ll.printList();
        ll.reverseIterate();
        ll.printList();
        ll.head = ll.reverseRecursive(ll.head);
        ll.printList();
    }
}
