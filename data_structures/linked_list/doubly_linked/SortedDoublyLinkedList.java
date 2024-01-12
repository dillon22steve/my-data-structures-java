package data_structures.linked_list.doubly_linked;

import data_structures.DataStructure;
import nodes.linked.DoublyLinkedNode;
import person.Person;


public class SortedDoublyLinkedList implements DataStructure {

    private DoublyLinkedNode head;


    public SortedDoublyLinkedList() {
        head = null;
    } //constructor


    @Override
    public void insert(Person personToInsert) {
        if (head == null) {
            head = new DoublyLinkedNode(personToInsert);
        } else if (personToInsert.compareTo(head.getData()) < 0) {
            DoublyLinkedNode nodeToInsert = new DoublyLinkedNode(personToInsert);
            nodeToInsert.setNext(head);
            head.setBack(nodeToInsert);
            head = nodeToInsert;
        } else {
            DoublyLinkedNode temp = head;
            DoublyLinkedNode nodeToInsert = new DoublyLinkedNode(personToInsert);
            while (temp != null) {
                if (personToInsert.compareTo(temp.getData()) < 0) {
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

    private void swapNodes(DoublyLinkedNode node, DoublyLinkedNode nodeToInsert) {
        DoublyLinkedNode prev = node.getBack();
        if (prev != null) {
            prev.setNext(nodeToInsert);
        } //if

        nodeToInsert.setNext(node);
        nodeToInsert.setBack(prev);
        node.setBack(nodeToInsert);
    } //swapNodes

    public void insertAll(Person[] people) {
        for (Person person : people) {
            this.insert(person);
        } //for
    } //insertAll



    @Override
    public void remove(Person personToRemove) {
        if (isEmpty()) {
            return;
        } else if (personToRemove.equals(head.getData())) {
            if (head.getNext() == null) {
                //if head is the only node in the list, make the list empty.
                destroy();
            } else {
                head = head.getNext();
                head.setBack(null);
            } //if
        } else {
            DoublyLinkedNode temp = head;
            while (temp != null) {
                if (personToRemove.equals(temp.getData())) {
                    DoublyLinkedNode prev = temp.getBack();
                    DoublyLinkedNode next = temp.getNext();

                    if (prev != null) prev.setNext(next);
                    if (next != null) next.setBack(prev);

                    return;
                } //if

                temp = temp.getNext();
            } //while
        } //if
    } //remove


    @Override
    public boolean search(Person personToSearch) {
        if (isEmpty()) {
            return false;
        } else {
            DoublyLinkedNode temp = head;
            while (temp != null) {
                if (personToSearch.equals(temp.getData())) {
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
            DoublyLinkedNode temp = head;
            while (temp.getNext() != null) {
                Person data = temp.getData();
                strToReturn = strToReturn + "[" + data.getName() + " is " + data.getAge() + "], ";
                temp = temp.getNext();
            } //while

            return (strToReturn + "[" + temp.getData().getName() + " is " + temp.getData().getAge() + "]");
        } //if
    }
    
} //SortedDoublyLinkedList
