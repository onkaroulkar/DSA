package com.dsa.problem;

import java.util.ArrayDeque;
import java.util.Queue;

public class binaryTreeYT {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static class BinaryTree{
        public  static int idx = -1;
        public static Node buildTree(int node[]){
            idx++;
            if(node[idx]== -1){
                return null;
            }
            Node newNode = new Node(node[idx]);
            newNode.left = buildTree(node);
            newNode.right = buildTree(node);
            return newNode;
        }
    }

    // Preorder traversal--time complexity O(n)
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    // Inorder traversal -- time complexity O(n)
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    // Postorder traversal -- time complexity O(n)
    public static void postorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        inorder(root.right);
        System.out.print(root.data+" ");
    }

    // Level Order Traversal--  Time Compelxity = O(n)
    public static void levelOrder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr == null){
                System.out.println();
                // queue is empty
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.println(curr.data+" ");
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
    }



    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        //System.out.println(root.data);
        /*preorder(root);
        inorder(root);
        postorder(root);*/
        levelOrder(root);
    }
}
