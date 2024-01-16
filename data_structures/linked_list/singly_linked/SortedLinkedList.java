package data_structures.linked_list.singly_linked;

import nodes.linked.Node;


public class SortedLinkedList<T extends Comparable<T>> extends LinkedList<T> {

    @Override
    public void insert(T itemToInsert) {
        Node<T> nodeToInsert = new Node<T>(itemToInsert);
        if (isEmpty()) {
            head = nodeToInsert;
        } else if (itemToInsert.compareTo(head.getData()) < 0) {
            nodeToInsert.setNext(head);
            head = nodeToInsert;
        } else {
            Node<T> temp = head;
            Node<T> next = temp.getNext();
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