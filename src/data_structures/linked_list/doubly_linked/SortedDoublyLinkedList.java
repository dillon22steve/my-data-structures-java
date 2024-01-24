package src.data_structures.linked_list.doubly_linked;

import src.data_structures.DataStructure;
import src.nodes.Node;
import src.nodes.linked.DoublyLinkedNode;


public class SortedDoublyLinkedList<T extends Comparable<T>> implements DataStructure<T> {

    private DoublyLinkedNode<T> head;
    private DoublyLinkedNode<T> currPos;


    public SortedDoublyLinkedList() {
        head = null;
    } //constructor


    @Override
    public void insert(T itemToInsert) {
        if (head == null) {
            head = new DoublyLinkedNode<T>(itemToInsert);
        } else if (itemToInsert.compareTo(head.getData()) < 0) {
            DoublyLinkedNode<T> nodeToInsert = new DoublyLinkedNode<T>(itemToInsert);
            nodeToInsert.setNext(head);
            head.setBack(nodeToInsert);
            head = nodeToInsert;
        } else {
            DoublyLinkedNode<T> temp = head;
            DoublyLinkedNode<T> nodeToInsert = new DoublyLinkedNode<T>(itemToInsert);
            while (temp != null) {
                if (itemToInsert.compareTo(temp.getData()) < 0) {
                    swapNodes(temp, nodeToInsert);
                    return;
                } else {
                    if (temp.getNext() == null) {
                        temp.setNext(nodeToInsert);
                        nodeToInsert.setBack(temp);
                        return;
                    } else {
                        temp = temp.getNext();
                    } //if
                } //if
            } //while
        } //if
    } //insert

    private void swapNodes(DoublyLinkedNode<T> node, DoublyLinkedNode<T> nodeToInsert) {
        DoublyLinkedNode<T> prev = node.getBack();
        if (prev != null) {
            prev.setNext(nodeToInsert);
        } //if

        nodeToInsert.setNext(node);
        nodeToInsert.setBack(prev);
        node.setBack(nodeToInsert);
    } //swapNodes

    public void insertAll(T[] items) {
        for (T item : items) {
            this.insert(item);
        } //for
    } //insertAll



    @Override
    public void remove(T itemToRemove) {
        if (isEmpty()) {
            return;
        } else if (itemToRemove.compareTo(head.getData()) == 0) {
            if (head.getNext() == null) {
                //if head is the only node in the list, make the list empty.
                destroy();
            } else {
                head = head.getNext();
                head.setBack(null);
            } //if
        } else {
            DoublyLinkedNode<T> temp = head;
            while (temp != null) {
                if (itemToRemove.compareTo(temp.getData()) == 0) {
                    DoublyLinkedNode<T> prev = temp.getBack();
                    DoublyLinkedNode<T> next = temp.getNext();

                    if (prev != null) prev.setNext(next);
                    if (next != null) next.setBack(prev);

                    return;
                } //if

                temp = temp.getNext();
            } //while
        } //if
    } //remove


    @Override
    public boolean search(T itemToSearch) {
        if (isEmpty()) {
            return false;
        } else {
            DoublyLinkedNode<T> temp = head;
            while (temp != null) {
                if (itemToSearch.compareTo(temp.getData()) == 0) {
                    return true;
                } //if

                temp = temp.getNext();
            } //while
            return false;
        } //if
    } //search


    @Override
    public void destroy() {
        head = null;
    } //destroy


    public boolean isEmpty() {
        return head == null;
    } //isEmpty


    public String toString() {
        if (isEmpty()) {
            return "";
        } else {
            String strToReturn = "";
            DoublyLinkedNode<T> temp = head;
            while (temp.getNext() != null) {
                T data = temp.getData();
                strToReturn = strToReturn + "[" + data.toString() + "], ";
                temp = temp.getNext();
            } //while

            return (strToReturn + "[" + temp.getData().toString() + "]");
        } //if
    }


    @Override
    public Node<T> get() {
        Node<T> nodeToRet = currPos;

        if (currPos != null) {
            currPos = currPos.getNext();
        } //if

        return nodeToRet;
    } //get
    
} //SortedDoublyLinkedList
