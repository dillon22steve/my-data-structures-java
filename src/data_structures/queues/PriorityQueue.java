package src.data_structures.queues;

import java.util.ArrayList;

import src.data_structures.heaps.Heap;

public class PriorityQueue<T extends Comparable<T>> {

    private Heap<T> heap;


    public PriorityQueue(int maxItems) {
        heap = new Heap<T>(maxItems);
    } //constructor


    public void enqueue(T itemToQueue) {
        heap.insert(itemToQueue);
    } //enqueue


    public T dequeue() {
        return heap.remove();
    } //dequeue


    public boolean isInQueue(T itemToFind) {
        ArrayList<T> array = heap.getArray();
        int bottom = heap.getBottom();
        for (int i = 0; i < bottom; i++) {
            if (array.get(i).compareTo(itemToFind) == 0) {
                return true;
            } //if
        } //for

        return false;
    } //isInQueue


    public boolean isHighestPriority(T itemToCheck) {
        T itemAtHighestPriority = heap.getArray().get(heap.getRoot());
        return (itemAtHighestPriority.compareTo(itemToCheck) == 0);
    } //isHighestPriority


    public Heap<T> getHeap() {
        return heap;
    } //getHeap
    
} //PriorityQueue
