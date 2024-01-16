import java.util.ArrayList;

import data_structures.hash_maps.HashMap;
import data_structures.heaps.Heap;
import data_structures.linked_list.doubly_linked.SortedDoublyLinkedList;
import data_structures.linked_list.singly_linked.SortedLinkedList;
import data_structures.linked_list.singly_linked.UnsortedLinkedList;
import data_structures.queues.Queue;
import data_structures.stack.Stack;
import data_structures.trees.BinarySearchTree;
import person.Person;

public class DataStructuresDriver {
    
    public static void main(String[] args) {
        Person.initIdChars();
        
        //HashMap map = new HashMap(10);
        Heap<Person> heap = new Heap<Person>(7);


        Person steve = new Person("Steve", 31);
        Person rich = new Person("Rich", 28);
        Person lisa = new Person("Lisa", 55);
        Person mike = new Person("Mike", 59);
        Person alana = new Person("Alana", 29);
        Person amanda = new Person("Amanda", 35);
        Person renee = new Person("Renee", 39);
        Person[] people = {
            steve, rich, lisa, mike, alana, amanda, renee
        };
        Person testSearch = new Person("Ryan", 21);



        /* Testing Hash Map */
        // map.insertAll(people);
        // System.out.println(map);

        // map.remove(steve);
        // System.out.println("---------------------------------------");
        // System.out.println(map);

        // System.out.println(map.search(steve));
        // System.out.println(map.search(testSearch));



        /* Testing Stack */
        // stack.pushAll(people);
        // stack.popAllAndPrint();

        // stack.push(steve);
        // System.out.println(stack.peak().getName());



        /* Testing Heap */
        // heap.insertAll(people);

        // ArrayList<Person> arr = heap.getArray();
        // PrintArrayList(arr);
        // System.out.print("\n");

        // heap.remove();
        // PrintArrayList(arr);
        // System.out.print("\n");

        // heap.remove();
        // PrintArrayList(arr);
        // System.out.print("\n");

    } //main


    public static void PrintArrayList(ArrayList<Person> arrayList) {
        for (Person person : arrayList) {
            System.out.print("[" + person.getName() + "], ");
        } //for
    } //PrintArrayList

} //DataStructuresDriver
