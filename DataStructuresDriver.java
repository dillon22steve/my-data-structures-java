import data_structures.linked_list.SortedLinkedList;
import data_structures.linked_list.UnsortedLinkedList;
import data_structures.trees.BinarySearchTree;
import person.Person;

public class DataStructuresDriver {
    
    public static void main(String[] args) {
        Person.initIdChars();
        
        BinarySearchTree test = new BinarySearchTree();
        UnsortedLinkedList uslist = new UnsortedLinkedList();
        SortedLinkedList slist = new SortedLinkedList();

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

        // test.insert(lisa, test.getRoot());
        // test.insert(rich, test.getRoot());
        // test.insert(mike, test.getRoot());
        // test.insert(steve, test.getRoot());
        // test.insert(alana, test.getRoot());
        // test.insert(renee, test.getRoot());
        // test.insert(amanda, test.getRoot());

        // test.inOrderTraversal(test.getRoot());
        // System.out.print("\n");

        // test.remove(lisa, test.getRoot());
        // test.inOrderTraversal(test.getRoot());
        // System.out.print("\n");   
        
        // System.out.println(test.search(lisa, test.getRoot()));

        
    } //main

} //DataStructuresDriver
