package com.onkar;
import java.util.LinkedList;
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
        Queue<Node> q = new LinkedList<>();
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

    // Count total no of nodes in a tree.
    // Time Complexity = O(n)
    public static int countNodes(Node root){

        if(root == null){
            return 0;
        }

        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left + right + 1;
    }

    // Calculate sum of nodes in a tree
    // Time Complexity = o(n)
    public static int sumNodes(Node root){
        if(root == null){
            return 0;
        }
        int left = sumNodes(root.left);
        int right = sumNodes(root.right);
        return left + right + root.data;
    }

    // Calculate the height of a tree.
    // Time Complexity = O(n)
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int totalHeight = Math.max(leftHeight,rightHeight) + 1;
        return totalHeight;
    }

    // Approach-1
    // Diameter of a tree - asked in a Adobe/snapdeal
    // Time Complexity = O(n^2)
    public static int diameter(Node root){
        if(root == null){
            return 0;
        }
        int dia1 = diameter(root.left);
        int dia2 = diameter(root.right);
        int dia3 = height(root.left) + height(root.right) + 1;
        int dia = Math.max(dia3,Math.max(dia1,dia2));
        return dia;
    }

    // Approach-2
    // Diameter of a tree - asked in a Adobe/snapdeal
    // Time Complexity = O(n)
    static class TreeInfo{
        int ht;
        int dia;
        TreeInfo(int ht,int dia){
            this.ht = ht;
            this.dia = dia;
        }
    }

    public static TreeInfo diameter1(Node root){

        if(root == null){
            return new TreeInfo(0,0);
        }

        TreeInfo left = diameter1(root.left);
        TreeInfo right = diameter1(root.right);
        int myHeight = Math.max(left.ht,right.ht) +1;
        int dia1 = left.dia;
        int dia2 = left.dia;
        int dia3 = left.ht + right.ht + 1;
        int maxDia = Math.max(dia3,Math.max(dia1,dia2));
        TreeInfo myInfo = new TreeInfo(myHeight,maxDia);
        return myInfo;
    }

    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        /*System.out.println(root.data);
        preorder(root);
        inorder(root);
        postorder(root);
        levelOrder(root);*/
        System.out.println(countNodes(root));
        System.out.println(sumNodes(root));
        System.out.println(height(root));
        System.out.println(diameter(root));
        System.out.println(diameter1(root).dia);

    }
}