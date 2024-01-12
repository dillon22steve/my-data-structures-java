package nodes.linked;

import person.Person;

public class Node {

    private Node next;
    private Person data;

    public Node(Person data) {
        this.data = data;
        this.next = null;
    } //constructor

    public Node(Person data, Node next) {
        this.data = data;
        this.next = next;
    } //constructor



    public Node getNext() {
        return next;
    } //getNext

    public void setNext(Node next) {
        this.next = next;
    } //setNext

    public Person getData() {
        return data;
    } //getData

    public void setData(Person data) {
        this.data = data;
    } //setData

} //Node
