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

    // Problem No.1 - word break problem.
    // given an input string and directory of the words, find out if the input string can be broken into a space-separated sequence of directory words.
    // steps -
    // 1. find all possible parts of the string by using loops.
    // 2. 1st part - trie search + 2nd part - recursive call.
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

    // Problem No.2 - startsWithProblem
    // Create a function boolean statsWith(String prefix) for a trie.
    // Return true if there is a previously inserted string word that has the prefix,and false otherwise.
    // Steps:
    // 1. Apply for loop from 0 to prefix.length.
    // 2. Calculate the index  of each character of the prefix.
    // 3. If character is not present at the index then return false else update the root.
    // 4. At end return true;
    public static boolean startsWith(String prefix){
        Node current = root;
        for(int i=0;i<prefix.length();i++){
            int idx = prefix.charAt(i) - 'a';
            if(current.children[idx] == null){
                return false;
            }else{
                current = current.children[idx];
            }
        }
        return true;
    }

    // Problem No.3 - Count Unique Substrings.
    // Given a string of length n of lowercase alphabet characters,
    // we need to count total no of distinct substring of this string.
    // Steps:
    // 1. Find all the suffix of the string.
    // 2. create a trie from the suffix.
    // 3. count the nodes of the trie.
    public static int countNode(Node root){
        if(root == null){
            return 0;
        }
        int count = 0;
        for(int i=0;i<26;i++){
            if(root.children[i] != null){
                count+= countNode(root.children[i]);
            }
        }
        return count+1;
    }

    // Problem 4
    // Longest Word with all Prefixes.
    // Find the longest string in words such that every prefix of it is also in words.
    // steps:
    // 1. Create "ans" string variable and "temp" StringBuilder variable.
    // 2. Check children node is not empty and children eow value is true.
    // 3. add i'th character in temp variable.
    // 4. if temp > ans then copy "temp" into "ans".
    // 5. call longestWord() metod ---> recursive call.
    // 6. At backtracking delete the "temp" variable character from last.

    public static String ans ="";

    public static void longestWord(Node root,StringBuilder temp){
        if(root == null){
            return;
        }
        for(int i=0;i<26;i++){
            if(root.children[i] != null && root.children[i].eow == true){
                temp.append((char)(i+'a'));
                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }
                longestWord(root.children[i],temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }


    public static void main(String[] args) {
       /* String words[] = {"the","a","there","their","any"};
        for(int i=0;i< words.length;i++){
            insert(words[i]);
        }
       System.out.println(search("there"));
       System.out.println(search("an"));
       System.out.println(wordBreak("thea"));
       System.out.println(startsWith("theid"));
        String str = "ababa";
        for(int i=0;i<str.length();i++){
            String suffix = str.substring(i);
            insert(suffix);
        }
        System.out.println(countNode(root));*/

        String words[] = {"a","banana","app","appl","ap","apply","apple"};
        for(int i=0; i<words.length;i++){
            insert(words[i]);
        }
        longestWord(root,new StringBuilder(""));
        System.out.println(ans);
    }
}
