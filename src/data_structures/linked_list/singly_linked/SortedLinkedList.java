package src.data_structures.linked_list.singly_linked;

import src.nodes.linked.SinglyLinkedNode;


public class SortedLinkedList<T extends Comparable<T>> extends LinkedList<T> {

    @Override
    public void insert(T itemToInsert) {
        SinglyLinkedNode<T> nodeToInsert = new SinglyLinkedNode<T>(itemToInsert);
        if (isEmpty()) {
            head = nodeToInsert;
        } else if (itemToInsert.compareTo(head.getData()) < 0) {
            nodeToInsert.setNext(head);
            head = nodeToInsert;
        } else {
            SinglyLinkedNode<T> temp = head;
            SinglyLinkedNode<T> next = temp.getNext();
            while (next != null) {
                if (itemToInsert.compareTo(next.getData()) < 0) {
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