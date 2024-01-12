package data_structures.linked_list.singly_linked;

import data_structures.DataStructure;
import nodes.linked.Node;
import person.Person;


public class LinkedList implements DataStructure {

    Node head;


    public LinkedList() {
        head = null;
    } //constructor



    @Override
    public void insert(Person personToInsert) {
        //This will be implemented in the child classes
    } //insert



    @Override
    public void remove(Person personToRemove) {
        if (isEmpty()) {
            return;
        } else if (head.getData().equals(personToRemove)) {
            head = head.getNext();
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                Node nextNode = temp.getNext();
                if (nextNode.getData().equals(personToRemove)) {
                    temp.setNext(nextNode.getNext());
                } else {
                    temp = temp.getNext();
                } //if
            } //while
        } //if
    } //remove



    @Override
    public boolean search(Person personToSearch) {
        Node temp = head;
        while (temp != null) {
            if (temp.getData().equals(personToSearch)) {
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


    public void insertAll(Person[] people) {
        for (Person person : people) {
            this.insert(person);
        } //for
    } //insertAll


    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print("[" + temp.getData().getName() + " is " + temp.getData().getAge() + "], ");
            temp = temp.getNext();
        } //while
        System.out.print("\n");
    } //printList


    @Override
    public String toString() {
        String list = "";
        if (isEmpty()) {
            return list;
        } //if

        
        Node temp = head;
        while (temp.getNext() != null) {
            list = list + ("[" + temp.getData().getName() + " is " + temp.getData().getAge() + "], ");
            temp = temp.getNext();
        } //while

        return (list + "[" + temp.getData().getName() + " is " + temp.getData().getAge() + "]");
    } //toString


    public boolean isEmpty() {
        return head == null;
    } //isEmpty



    public Node getHead() {
        return this.head;
    } //getHead
    
} //LinkedList
