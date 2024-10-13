import java.util.HashSet;
import java.util.Iterator;

public class Hashing {

    public static void main(String[] args) {
        // creating
        HashSet<Integer> set = new HashSet<>();

        // Insert
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        // search- contains
        if(set.contains(1)){
            System.out.println("set conatains 1");
        }

        // Delete
        set.remove(1);
        if(!set.contains(1)){
            System.out.println("does not containd  1");
        }
        System.out.println("aize of the set is " + set.size());

        // print all element of a set
        System.out.println(set);

        // Iterator
        Iterator it = set.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
