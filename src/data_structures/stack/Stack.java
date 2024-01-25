package src.data_structures.stack;

import src.nodes.linked.SinglyLinkedNode;

public class Stack<T extends Comparable<T>> {

    private SinglyLinkedNode<T> top;

    public Stack() {
        top = null;
    } //constructor


    public SinglyLinkedNode<T> pop() {
        if (isEmpty()) {
            return null;
        } else {
            SinglyLinkedNode<T> nodeToReturn = top;
            top = top.getNext();
            return nodeToReturn;
        } //if
    } //pop

    public void popAllAndPrint() {
        SinglyLinkedNode<T> poppedNode = pop();
        while (poppedNode != null) {
            System.out.print(poppedNode.getData().toString() + " -> ");

            poppedNode = pop();
        } //while

        System.out.print("\n");
    } //popAllAndPrint


    public T peak() {
        if (isEmpty()) {
            return null;
        } else {
            return top.getData();
        } //if
    } //peak

    public void push(T itemToPush) {
        SinglyLinkedNode<T> nodeToPush = new SinglyLinkedNode<T>(itemToPush);
        nodeToPush.setNext(top);
        top = nodeToPush;
    } //push

    public void pushAll(T[] items) {
        for (T item : items) {
            push(item);
        } //for
    } //pushAll


    public boolean isEmpty() {
        return top == null;
    } //isEmpty


    public SinglyLinkedNode<T> getTop() {
        return top;
    } //getTop
    
} //Stack
