package data_structures.linked_list;

import nodes.linked.Node;
import person.Person;

public class UnsortedLinkedList extends LinkedList {

    @Override
    public void insert(Person personToInsert) {
        Node nodeToInsert = new Node(personToInsert);
        nodeToInsert.setNext(head);
        head = nodeToInsert;
    } //insert
    
} //UnsortedLinkedList
