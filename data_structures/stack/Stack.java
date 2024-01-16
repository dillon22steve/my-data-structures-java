package data_structures.stack;

import nodes.linked.Node;

public class Stack<T extends Comparable<T>> {

    private Node<T> top;

    public Stack() {
        top = null;
    } //constructor


    public Node<T> pop() {
        if (isEmpty()) {
            return null;
        } else {
            Node<T> nodeToReturn = top;
            top = top.getNext();
            return nodeToReturn;
        } //if
    } //pop

    public void popAllAndPrint() {
        Node<T> poppedNode = pop();
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
        Node<T> nodeToPush = new Node<T>(itemToPush);
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
    
} //Stack
