package src.data_structures.linked_list.singly_linked;

import src.nodes.linked.SinglyLinkedNode;

public class UnsortedLinkedList<T extends Comparable<T>> extends LinkedList<T> {

    @Override
    public void insert(T itemToInsert) {
        SinglyLinkedNode<T> nodeToInsert = new SinglyLinkedNode<T>(itemToInsert);
        nodeToInsert.setNext(head);
        head = nodeToInsert;
    } //insert
    
} //UnsortedLinkedList
