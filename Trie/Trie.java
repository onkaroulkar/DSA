public class Trie  {

      static class Node{
        Node [] children;
        boolean eow;

        public Node(){
            children = new Node[26];
            for(int i=0;i<26;i++){
                children[i] = null;
            }
            eow = false;
        }
    }

    static Node root =  new Node();

    // time complexity O(L)    L= length of the word
    public static void insert(String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            if(i==word.length()-1){
                curr.children[idx].eow = true;
            }
            curr = curr.children[idx];
        }
    }

    // time complexity O(n)
    public static boolean search(String key){
        Node curr = root;
        for(int i=0;i<key.length();i++){
            int idx = key.charAt(i)-'a';
            Node node = curr.children[idx];
            if(node == null){
                return false;
            }
            if(i == key.length()-1 && node.eow == false){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    // word break problem.
    // given an input string and directory of the words, find out if the input string can be broken into a space-separated sequence of directory words.
    // steps -
    // 1. find all possible parts of the string by using loops.
    // 2. 1st part - trie search + 2nd call- recursive call.
    // 3. if 1st part and 2nd part both returns true then return true else return false.
    public static boolean wordBreak(String key){
        if(key.length() == 0){
            return true;
        }
        for(int i=1;i<=key.length();i++){
            String firstPart = key.substring(0,i);
            String secondPart = key.substring(i);
            if(search(firstPart) && wordBreak(secondPart)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String words[] = {"the","a","there","their","any"};
        for(int i=0;i< words.length;i++){
            insert(words[i]);
        }
       // System.out.println(search("there"));
       // System.out.println(search("an"));
        System.out.println(wordBreak("thea"));
    }
}
