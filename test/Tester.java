package test;

import src.data_structures.hash_maps.HashMap;
import src.data_structures.linked_list.doubly_linked.SortedDoublyLinkedList;
import src.data_structures.linked_list.singly_linked.SortedLinkedList;
import src.data_structures.linked_list.singly_linked.UnsortedLinkedList;
import src.data_structures.queues.Queue;
import src.data_structures.stack.Stack;
import src.data_structures.trees.AvlTree;
import src.data_structures.trees.BinarySearchTree;
import src.data_structures.trees.RedBlackTree;
import src.nodes.linked.SinglyLinkedNode;
import src.person.Person;


public class Tester {
    
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



    public Tester() {
        
    } //constructor




    public void runTests() {
        testLists();
        testTrees();
        testQueues();
        testStack();
        testHashMap();
    } //RunTests




    private void testLists() {
        testUnsortedList();
        testSortedList();
        testDoublyLinkedList();
    } //TestLists


    private void testUnsortedList() {
        System.out.println("*** Testing UnsortedLinkedList ***");

        UnsortedLinkedList<Person> uslist = new UnsortedLinkedList<Person>();
        uslist.insertAll(people);
        System.out.println(uslist.toString());

        System.out.println("Search steve: " + uslist.search(steve) + ", Search Alana: " + uslist.search(alana) +
            ", Search Mike: " + uslist.search(mike) + ", Search Ryan: " + uslist.search(testSearch));

        uslist.remove(steve);
        System.out.println("After removing Steve: " + uslist.toString());
        
        uslist.remove(renee);
        System.out.println("After removing Renee: " + uslist.toString());

        uslist.remove(mike);
        System.out.println("After removing Mike: " + uslist.toString());

        System.out.println("*************************************************************************************");
        System.out.println();
    } //TestUnsortedList


    private void testSortedList() {
        System.out.println("*** Testing SortedLinkedList ***");

        SortedLinkedList<Person> slist = new SortedLinkedList<Person>();

        slist.insertAll(people);
        System.out.println(slist.toString());

        System.out.println("Search steve: " + slist.search(steve) + ", Search Alana: " + slist.search(alana) +
            ", Search Mike: " + slist.search(mike) + ", Search Ryan: " + slist.search(testSearch));

        slist.remove(steve);
        System.out.println("After removing Steve: " + slist.toString());
        
        slist.remove(alana);
        System.out.println("After removing Alana: " + slist.toString());

        slist.remove(mike);
        System.out.println("After removing Mike: " + slist.toString());

        System.out.println("*************************************************************************************");
        System.out.println();
    } //TestSortedList


    private void testDoublyLinkedList() {
        System.out.println("*** Testing DoublyLinkedList ***");
        SortedDoublyLinkedList<Person> doubList = new SortedDoublyLinkedList<Person>();

        doubList.insertAll(people);
        System.out.println(doubList.toString());

        System.out.println("Search steve: " + doubList.search(steve) + ", Search Alana: " + doubList.search(alana) +
            ", Search Mike: " + doubList.search(mike) + ", Search Ryan: " + doubList.search(testSearch));

        doubList.remove(steve);
        System.out.println("After removing Steve: " + doubList.toString());
        
        doubList.remove(alana);
        System.out.println("After removing Alana: " + doubList.toString());

        doubList.remove(mike);
        System.out.println("After removing Mike: " + doubList.toString());

        System.out.println("*************************************************************************************");
        System.out.println();
    } //testDoublyLinkedList




    private void testTrees() {
        testBst();
        testAvlTree();
        testRedBlackTree();
    } //TestTrees
    private void testBst() {
        System.out.println("*** Testing BinarySearchTree ***");
        BinarySearchTree<Person> test = new BinarySearchTree<Person>();

        //Wanted to insert them in a different order than the people array.
        test.insertAll(new Person[] {lisa, rich, mike, steve, alana, renee, amanda});

        test.inOrderTraversal(test.getRoot());
        System.out.print("\n");

        test.remove(lisa, test.getRoot());
        test.inOrderTraversal(test.getRoot());
        System.out.print("\n");   
        
        System.out.println(test.search(lisa, test.getRoot()));

        System.out.println("*************************************************************************************");
        System.out.println();
    } //TestBst

    private void testAvlTree() {
        System.out.println("*** Testing AVL Tree ***");
        AvlTree<Person> tree = new AvlTree<Person>();

        tree.insertAll(people);

        tree.inOrderTraversal(tree.getRoot());
        System.out.print("\n");

        System.out.println("*************************************************************************************");
        System.out.println();
    } //testAvlTree

    private void testRedBlackTree() {
        System.out.println("*** Testing Red Black Tree ***");
        RedBlackTree<Person> rbTree = new RedBlackTree<Person>();

        rbTree.insertAll(people);

        rbTree.inOrderTraversal(rbTree.getRootNode());
        System.out.print("\n");

        System.out.println("*************************************************************************************");
        System.out.println();
    }



    private void testStack() {
        System.out.println("*** Testing Stack ***");


        System.out.print("Pushed in order: ");
        for (int i = 0; i < people.length - 1; i++) {
            System.out.print(people[i].getName() + " -> ");
        } //for
        System.out.print(people[people.length - 1].getName() + "\n");


        Stack<Person> stack = new Stack<Person>();
        stack.pushAll(people);

        stack.popAllAndPrint();

        System.out.println("*************************************************************************************");
        System.out.println();
    } //testStack



    private void testQueues() {
        testNormalQueue();
    } //testQueues


    private void testNormalQueue() {
        System.out.println("*** Testing Normal Queue ***");

        Queue<Person> queue = new Queue<Person>();
        queue.enqueueAll(people);

        System.out.print("Enqueued in order: ");
        for (int i = 0; i < people.length - 1; i++) {
            System.out.print(people[i].getName() + " -> ");
        } //for
        System.out.print(people[people.length - 1].getName() + "\n");


        System.out.print("Dequeued in order: ");
        for (int i = 0; i < people.length - 1; i++) {
            SinglyLinkedNode<Person> dequeuedNode = queue.dequeue();
            if (dequeuedNode != null) {
                System.out.print(dequeuedNode.getData().getName() + " -> ");
            } //if
        } //for

        SinglyLinkedNode<Person> dequeuedNode = queue.dequeue();
        if (dequeuedNode != null) {
            System.out.print(dequeuedNode.getData().getName() + "\n");
        } //if

        System.out.println("*************************************************************************************");
        System.out.println();
    } //testNormalQueue



    private void testHashMap() {
        System.out.println("*** Test HashMap ***");
        
        HashMap map = new HashMap(50);
        map.insertAll(people);

        System.out.println(map);
        System.out.println();


        for (int i = 0; i < people.length; i++) {
            System.out.print(people[i].getName() + ": " + map.search(people[i]) + ",   ");
        } //for
        System.out.print("\n");

        System.out.println("*************************************************************************************");
        System.out.println();
    } //testHashMap



    private static void IsWorking(String expectedString, String stringReceived, String methodTested) {
        if (!(stringReceived.equals(expectedString))) {
            System.out.println(methodTested + "             FAILED");
            System.out.println("Expected: " + expectedString);
            System.out.println("But got: " + stringReceived);
        } else {
            System.out.println(methodTested + "             PASSED");
        } //if
    }  //isWorking
} //Tester
