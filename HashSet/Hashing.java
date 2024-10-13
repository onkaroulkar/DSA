import java.util.*;

public class Hashing {

    public static void main(String[] args) {
        // creating
        HashSet<Integer> set = new HashSet<>();
        HashMap<String,Integer> map = new HashMap<>();

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

        // map-insert
        map.put("india",120);
        map.put("US",130);
        map.put("China",150);

        System.out.println(map);

        //searching
        if(map.containsKey("Indonesia")){
            System.out.println("Key is present in the map");
        }else{
            System.out.println("key is not present in the map");
        }

        System.out.println(map.get("China"));
        System.out.println(map.get("Indonesia"));

        // for(int val : arr)
        // 1st way
        for(Map.Entry<String,Integer> e:map.entrySet()){
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }

        // 2nd way
        Set<String> keys = map.keySet();
        for(String key : keys) {
            System.out.println(key + " "+ map.get(key));
        }
    }
}
