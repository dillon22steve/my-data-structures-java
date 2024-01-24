package src.data_structures.hash_maps;

import src.nodes.hash_map.HashMapNode;
import src.person.Person;


public class HashMap {

    private HashMapNode[] map;
    private int size;


    public HashMap(int initialSize) {
        this.size = initialSize;
        map = new HashMapNode[size];
    } //constructor


    private int hashFunction(Person person) {
        int hashCode = generateHashCode(person.getId());

        return hashCode % size;
    } //hashFunction

    private int generateHashCode(String id) {
        int hashCode = 0;
        int strLength = id.length();
        for (int i = 0, j = strLength - 1; i < strLength; i++, j--) {
            hashCode += (31 ^ j) * id.charAt(i);
        } //for
      
        return Math.abs(hashCode);
    } //generateHashCode


    public void insert(Person person) {
        int hashIndex = hashFunction(person);

        if (map[hashIndex] == null) {
            map[hashIndex] = new HashMapNode(person);
        } else {
            HashMapNode temp = map[hashIndex];
            while (temp.getNext() != null) {
                temp = temp.getNext();
            } //while

            temp.setNext(new HashMapNode(person));
        } //if
    } //insert

    public void insertAll(Person[] people) {
        for (Person person : people) {
            insert(person);
        } //for
    } //insertAll


    public void remove(Person personToRemove) {
        int hashIndex = hashFunction(personToRemove);

        if (map[hashIndex] != null) {
            HashMapNode temp = map[hashIndex];
            if (temp.getData().compareTo(personToRemove) == 0) {
                map[hashIndex] = temp.getNext();
            } else {
                while (temp.getNext() != null) {
                    if (temp.getNext().getData().compareTo(personToRemove) == 0) {
                        temp.setNext(temp.getNext().getNext());
                    } else {
                        temp = temp.getNext();
                    } //if
                } //while
            } //if
        } //if
    } //remove


    public boolean search(Person personToSearch) {
        int hashIndex = hashFunction(personToSearch);

        HashMapNode temp = map[hashIndex];
        while (temp != null ) {
            if (temp.getData().compareTo(personToSearch) == 0) {
                return true;
            } else {
                temp = temp.getNext();
            } //if
        } //while

        return false;
    } //search


    public void destroy() {
        map = null;
    } //destroy


    public String toString() {
        String str = "";

        for (int i = 0; i < map.length - 1; i++) {
            HashMapNode temp = map[i];

            if (temp != null) {
                str = str + "index " + i +": " + listToString(temp) + "\n";
            } //if
        } //for

        if (map[map.length - 1] != null) {
            str = str + "index " + (map.length - 1) +": " + listToString(map[map.length - 1]);
        } //if

        return str;
    } //toString

    private String listToString(HashMapNode list) {
        if (list == null) return "";

        String str = "";
        while (list.getNext() != null) {
            str = str + "[" + list.getData().toString() + "] -> ";
            list = list.getNext();
        } //while

        str = str + "[" + list.getData().toString() + "]";

        return str;
    } //listToString
    
} //HashMap2
