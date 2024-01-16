package data_structures.queues;

import nodes.linked.Node;


public class Queue<T extends Comparable<T>> {

    private Node<T> front, rear;


    public Queue() {
        front = null;
    } //constructor


    public void enqueue(T itemToQueue) {
        Node<T> nodeToQueue = new Node<T>(itemToQueue);
        if (isEmpty()) {
            rear = nodeToQueue;
            front = nodeToQueue;
        } else {
            nodeToQueue.setNext(rear);
            if (front == rear) {
                System.out.println("Reached");
            }
            rear = nodeToQueue;
        } //if
    } //enqueue

    public void enqueueAll(T[] items) {
        for (T item : items) {
            enqueue(item);
        } //for
    } //enqueueAll


    public Node<T> dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            Node<T> nodeToReturn = front;

            if (front == rear) {
                //If front equals rear then there was only Person in the queue when the
                //user called this method.
                makeEmpty();
            } else {
                Node<T> replacement = rear;
                while (replacement.getNext() != front && replacement.getNext() != null) {
                    replacement = replacement.getNext();
                } //while
                front = replacement;
                front.setNext(null);
            } //if

            return nodeToReturn;
        } //if
    } //dequeue


    public T peak() {
        if (front != null) return front.getData();
        else return null;
    } //peak


    public void makeEmpty() {
        rear = null;
    } //makeEmpty

    public boolean isEmpty() {
        return rear == null;
    } //isEmpty


    public T getFront() {
        return this.front.getData();
    } //getFront
    
} //Queue
