package src.data_structures.queues;

import src.data_structures.DataStructure;
import src.nodes.Node;
import src.nodes.linked.SinglyLinkedNode;


public class Queue<T extends Comparable<T>> implements DataStructure<T> {

    private SinglyLinkedNode<T> front, rear;


    public Queue() {
        front = null;
    } //constructor


    public void enqueue(T itemToQueue) {
        SinglyLinkedNode<T> nodeToQueue = new SinglyLinkedNode<T>(itemToQueue);
        if (isEmpty()) {
            rear = nodeToQueue;
            front = nodeToQueue;
        } else {
            nodeToQueue.setNext(rear);
            rear = nodeToQueue;
        } //if
    } //enqueue

    public void enqueueAll(T[] items) {
        for (T item : items) {
            enqueue(item);
        } //for
    } //enqueueAll


    public SinglyLinkedNode<T> dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            SinglyLinkedNode<T> nodeToReturn = front;

            if (front == rear) {
                //If front equals rear then there was only Person in the queue when the
                //user called this method.
                destroy();
            } else {
                SinglyLinkedNode<T> replacement = rear;
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

    public boolean isEmpty() {
        return rear == null;
    } //isEmpty


    public T getFront() {
        return this.front.getData();
    } //getFront


    public SinglyLinkedNode<T> getRear() {
        return rear;
    } //getRear


    @Override
    public void insert(Comparable itemToInsert) {
        
    } //insert


    @Override
    public void remove(Comparable itemToRemove) {
        dequeue();
    } //remove


    @Override
    public boolean search(Comparable itemToSearch) {
        return true;
    } //search


    @Override
    public void destroy() {
        rear = null;
    } //destroy


    @Override
    public Node get() {
        return dequeue();
    } //get
    
} //Queue
