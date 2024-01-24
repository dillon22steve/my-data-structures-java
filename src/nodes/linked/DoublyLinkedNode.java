package src.nodes.linked;

import src.nodes.Node;

public class DoublyLinkedNode<T extends Comparable<T>> extends Node<T> {

    private DoublyLinkedNode<T> next, back;


    public DoublyLinkedNode(T data) {
        super(data);
    } //constructor


    public DoublyLinkedNode<T> getNext() {
        return next;
    } //getNext
    public void setNext(DoublyLinkedNode<T> next) {
        this.next = next;
    } //setNext
    public DoublyLinkedNode<T> getBack() {
        return back;
    } //getBack
    public void setBack(DoublyLinkedNode<T> back) {
        this.back = back;
    } //setBack
    
} //DoublyLinkedNode
