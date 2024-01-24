package src.nodes.linked;

import src.nodes.Node;

public class SinglyLinkedNode <T extends Comparable<T>> extends Node<T> {

    private SinglyLinkedNode<T> next;

    public SinglyLinkedNode(T data) {
        super(data);
        this.next = null;
    } //constructor

    public SinglyLinkedNode(T data, SinglyLinkedNode<T> next) {
        super(data);
        this.next = next;
    } //constructor



    public SinglyLinkedNode<T> getNext() {
        return next;
    } //getNext

    public void setNext(SinglyLinkedNode<T> next) {
        this.next = next;
    } //setNext

} //Node
