package data_structures.linked_list.singly_linked;

import nodes.linked.Node;

public class UnsortedLinkedList<T extends Comparable<T>> extends LinkedList<T> {

    @Override
    public void insert(T itemToInsert) {
        Node<T> nodeToInsert = new Node<T>(itemToInsert);
        nodeToInsert.setNext(head);
        head = nodeToInsert;
    } //insert
    
} //UnsortedLinkedList
