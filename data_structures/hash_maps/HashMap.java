package data_structures.hash_maps;

import data_structures.DataStructure;
import data_structures.linked_list.singly_linked.UnsortedLinkedList;
import person.Person;

public class HashMap implements DataStructure {

    private UnsortedLinkedList[] map;

    public HashMap(int size) {
        map = new UnsortedLinkedList[size];
    } //constructor


    private int hashFunction(Person person) {
        int hashCode = generateHashCode(person.getId());

        return hashCode % map.length;
    } //hashFunction

    private int generateHashCode(String id) {
        int hashCode = 0;
        int strLength = id.length();
        for (int i = 0, j = strLength - 1; i < strLength; i++, j--) {
            hashCode += (31 ^ j) * id.charAt(i);
        } //for
      
        return Math.abs(hashCode);
    } //generateHashCode



    @Override
    public void insert(Person personToInsert) {
        int hashIndex = hashFunction(personToInsert);

        if (map[hashIndex] == null) map[hashIndex] = new UnsortedLinkedList();

        map[hashIndex].insert(personToInsert);
    } //insert

    public void insertAll(Person[] people) {
        for (Person person : people) {
            insert(person);
        } //for
    } //insertAll



    @Override
    public void remove(Person personToRemove) {
        int hashIndex = hashFunction(personToRemove);
        map[hashIndex].remove(personToRemove);
    }



    @Override
    public boolean search(Person personToSearch) {
        int hashIndex = hashFunction(personToSearch);
        return map[hashIndex].search(personToSearch);
    }



    @Override
    public void destroy() {
        map = null;
    } //destroy


    public String toString() {
        String str = "";
        for (int i = 0; i < map.length - 1; i++) {
            if (map[i] != null) {
                str += map[i].toString() + "    [NEXT LIST]    ";
            } //if
        } //for

        if (map[map.length - 1] != null) {
            str += map[map.length - 1].toString();
        } //if

        return str;
    } //toString
    
} //HashMap
