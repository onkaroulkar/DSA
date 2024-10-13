import java.util.ArrayList;

public class BST {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left =  null;
            this.right = null;
        }
    }

    // Building a BST
    public static Node insert(Node root, int data){
        if(root == null){
            root = new Node(data);
            return root;
        }

        if(root.data > data){
            root.left = insert(root.left,data);
        }
        else{
            root.right = insert(root.right,data);
        }

        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Search a BTS
    // Time complexity  O(H)
    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }
        if(root.data > key){
            return search(root.left,key);
        }
        else if(root.data == key){
            return true;
        }
        else{
            return search(root.right,key);
        }
    }

    // Deleting node from BST.
    public static Node delete(Node root,int val){
        if(root.data > val){
            root.left = delete(root.left,val);
        }

        else if(root.data < val){
            root.right = delete(root.right,val);
        }
        else {

            // case1
            if (root.left == null && root.right == null) {
                return null;
            }

            // case2
            if (root.left == null) {
                return root.right;
            } else {
                return root.left;
            }
        }
        // case3
        Node IS = inorderSuccessor(root.right);
        root.data = IS.data;
        root.right = delete(root.right, IS.data);
        return root;
    }

    public static Node inorderSuccessor(Node root){
        while (root.left != null){
            root = root.left;
        }
        return root;
    }

    // Problem -1
    // Print  in a range.
    public static void printInRange(Node root,int x,int y){
        if(root == null){
            return;
        }

        if(root.data >= x && root.data <=y){
            printInRange(root.left,x,y);
            System.out.print(root.data+" ");
            printInRange(root.right,x,y);
        }
        else if(root.data >=y){
            printInRange(root.left,x,y);
        }
        else{
            printInRange(root.right,x,y);
        }
    }

    //problem-2
    // Root to leaf path.
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        // leaf
        if(root.left == null && root.right == null){
            printPath(path);
        }else{
            printRoot2Leaf(root.left,path);
            printRoot2Leaf(root.right,path);
        }
        path.remove(path.size()-1);
    }

    public static void printPath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int [] values = {5,1,3,4,2,7};
        Node root = null;

        for(int i=0;i<values.length;i++){
            root = insert(root,values[i]);
        }

        inorder(root);
        System.out.println();

        if(search(root,10)){
            System.out.println("key found");
        }else{
            System.out.println("key not found");
        }

        //delete(root,7);
        //inorder(root);
        printInRange(root,3,5);
        printRoot2Leaf(root,new ArrayList<>());
    }
}
