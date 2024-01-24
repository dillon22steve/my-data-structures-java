package src.data_structures.linked_list.singly_linked;

import src.data_structures.DataStructure;
import src.nodes.linked.SinglyLinkedNode;


public class LinkedList<T extends Comparable<T>> implements DataStructure<T> {

    SinglyLinkedNode<T> head;
    SinglyLinkedNode<T> currentPos;


    public LinkedList() {
        head = null;
        currentPos = null;
    } //constructor



    @Override
    public void insert(T itemToInsert) {
        //This will be implemented in the child classes
    } //insert



    @Override
    public void remove(T itemToRemove) {
        if (isEmpty()) {
            return;
        } else if (head.getData().compareTo(itemToRemove) == 0) {
            head = head.getNext();
        } else {
            SinglyLinkedNode<T> temp = head;
            while (temp.getNext() != null) {
                SinglyLinkedNode<T> nextNode = temp.getNext();
                if (nextNode.getData().compareTo(itemToRemove) == 0) {
                    temp.setNext(nextNode.getNext());
                } else {
                    temp = temp.getNext();
                } //if
            } //while
        } //if
    } //remove



    @Override
    public boolean search(T itemToSearch) {
        SinglyLinkedNode<T> temp = head;
        while (temp != null) {
            if (temp.getData().compareTo(itemToSearch) == 0) {
                return true;
            } //if
            temp = temp.getNext();
        } //while

        return false;
    } //search



    @Override
    public void destroy() {
        this.head = null;
    } //destroy


    public void insertAll(T[] items) {
        for (T item : items) {
            this.insert(item);
        } //for
    } //insertAll


    @Override
    public String toString() {
        String list = "";
        if (isEmpty()) {
            return list;
        } //if

        
        SinglyLinkedNode<T> temp = head;
        while (temp.getNext() != null) {
            list = list + ("[" + temp.getData().toString() + "], ");
            temp = temp.getNext();
        } //while

        return (list + "[" + temp.getData().toString() + "]");
    } //toString


    public boolean isEmpty() {
        return head == null;
    } //isEmpty



    public SinglyLinkedNode<T> getHead() {
        return this.head;
    } //getHead



    @Override
    public SinglyLinkedNode<T> get() {
        if (currentPos == null) currentPos = head;
        
        SinglyLinkedNode<T> nodeToRet = currentPos;
        currentPos = currentPos.getNext();
        return nodeToRet;
    } //get

    public void setCurrentPos(SinglyLinkedNode<T> currentPos) {
        this.currentPos = currentPos;
    } //setCurrentPos
    
} //LinkedList
