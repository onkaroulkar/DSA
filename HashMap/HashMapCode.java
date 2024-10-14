package com.onkar;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Map;

public class HashMapCode {
    static class HashMap<k,v>{ // generics
        private class Node{
            k key;
            v value;

            public Node(k key,v value){
                this.key = key;
                this.value = value;
            }
        }

        private int n; // n - nodes
        private int N; // N - buckets
        private LinkedList<Node> buckets[]; // N = buckets.length

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0;i<4;i++){
                this.buckets[i]=new LinkedList();
            }
        }

        // Hash function
        private int hashFunction(k key){
            int bi = key.hashCode();
            return Math.abs(bi) % N;
        }

        // Search in LL
        private int searchInLL(k key, int bi){
           LinkedList<Node> ll = buckets[bi];
           for(int i=0;i<ll.size();i++){
               if(ll.get(i).key == key){
                   return i; // di
               }
           }
            return -1;
        }

        // Rehash
        private void rehash(){
            LinkedList<Node> oldBuckets[] = buckets;
            buckets = new LinkedList[N*2];

            for(int i=0;i<N*2;i++){
                 buckets[i] = new LinkedList<>();
            }

            for(int i=0;i<oldBuckets.length;i++){
                LinkedList<Node> ll = oldBuckets[i];
                for(int j=0;j<ll.size();j++){
                    Node node = ll.get(j);
                    put(node.key,node.value);
                }
            }
        }

        // put function
        public void put(k key,v value){
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);
            if(di == -1){ // key doesn't exit.
                buckets[bi].add(new Node(key, value));
                n++;
            }else{ // key exists.
                Node data = buckets[bi].get(di);
                data.value = value;
            }

            double lambada = (double) n/N;
            if(lambada > 2.0){
                // rehashing
                rehash();
            }
        }

        // get function
        public v get(k key){
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);
            if(di == -1){ // key doesn't exit.
                return null;
            }else{ // key exists.
                Node node = buckets[bi].get(di);
                return node.value;
            }
        }

        // contains key function
        public boolean containsKey(k key){
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);
            if(di == -1){ // key doesn't exit.
                return true;
            }else{ // key exists.
                Node node = buckets[bi].get(di);
                return false;
            }
        }

        // remove function
        public v remove(k key){
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);
            if(di == -1){ // key doesn't exit.
                return null;
            }else{ // key exists.
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
        }

        // isEmpty function
        public boolean isEmpty(){
            return n == 0;
        }

        // key set function
        public ArrayList<k> keySet(){
            ArrayList<k> keys = new ArrayList<>();
            for(int i=0;i< buckets.length;i++){
                LinkedList<Node> ll = buckets[i];
                for(int j=0;j<ll.size();j++){
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }
    }

    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("India",190);
        map.put("China",200);
        map.put("US",50);
        ArrayList<String> keys = map.keySet();
        for(int i=0;i<keys.size();i++){
            System.out.println(keys.get(i) + " " + map.get(keys.get(i)));
        }

        map.remove("India");
        System.out.println(map.get("India"));
    }
}
