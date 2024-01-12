package nodes.linked;

import person.Person;


public class DoublyLinkedNode {

    private DoublyLinkedNode next, back;
    private Person data;


    public DoublyLinkedNode(Person data) {
        this.data = data;
    } //constructor


    public DoublyLinkedNode getNext() {
        return next;
    } //getNext
    public void setNext(DoublyLinkedNode next) {
        this.next = next;
    } //setNext
    public DoublyLinkedNode getBack() {
        return back;
    } //getBack
    public void setBack(DoublyLinkedNode back) {
        this.back = back;
    } //setBack
    public Person getData() {
        return data;
    } //getData
    public void setData(Person data) {
        this.data = data;
    } //setData
    
} //DoublyLinkedNode
