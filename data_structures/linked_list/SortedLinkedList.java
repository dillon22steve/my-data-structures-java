package data_structures.linked_list;

import person.Person;
import nodes.linked.Node;


public class SortedLinkedList extends LinkedList {

    @Override
    public void insert(Person personToInsert) {
        Node nodeToInsert = new Node(personToInsert);
        if (isEmpty()) {
            head = nodeToInsert;
        } else if (personToInsert.compareTo(head.getData()) < 0) {
            nodeToInsert.setNext(head);
            head = nodeToInsert;
        } else {
            Node temp = head;
            Node next = temp.getNext();
            while (next != null) {
                if (personToInsert.compareTo(next.getData()) < 0) {
                    nodeToInsert.setNext(next);
                    temp.setNext(nodeToInsert);
                    return;
                } //if

                temp = temp.getNext();
                next = next.getNext();
            } //while

            temp.setNext(nodeToInsert);
        } //if
    } //insert
    
} //SortedLinkedList