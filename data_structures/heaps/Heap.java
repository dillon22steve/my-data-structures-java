package data_structures.heaps;

import java.util.ArrayList;


public class Heap<T extends Comparable<T>> {

    public int maxItems;
    public int root, bottom;
    public ArrayList<T> array;

    public Heap(int maxItems) {
        root = 0;
        bottom = 0;
        this.maxItems = maxItems;
        array = new ArrayList<T>(maxItems);
    } //constructor



    public void insert(T itemToInsert) {
        if (bottom == maxItems) {
            return;
        } else {
            array.add(array.size(), itemToInsert);

            if ((bottom + 1) != maxItems) bottom++;

            reheapUp(array.size() - 1);
        }
    } //insert

    public void reheapUp(int child) {
        int parent = getParent(child);
        int compare = array.get(child).compareTo(array.get(parent));
        while (compare > 0) {
            swap(child, parent);

            child = parent;
            parent = getParent(child);

            compare = array.get(parent).compareTo(array.get(parent));
        } //while
    } //reheapUp

    public void insertAll(T[] items) {
        for (T item : items) {
            insert(item);
        } //for
    } //insertAll



    public T remove() {
        T itemToReturn = array.get(root);

        swap(root, array.size() - 1);
        array.remove(array.size() - 1);
        //bottom--;

        reheapDown(root);

        return itemToReturn;
    } //remove


    private void reheapDown(int parent) {
        int maxChild;
        int leftChild = getLeftChild(parent);
        int rightChild = getRightChild(parent);

        if (array.get(leftChild).compareTo(array.get(rightChild)) > 0) {
            maxChild = leftChild;
        } else {
            maxChild = rightChild;
        } //if

        if (array.get(parent).compareTo(array.get(maxChild)) < 0) {
            swap(parent, maxChild);
            reheapDown(maxChild);
        } else {
            //This is the base case, which is the parent is greater
            //than both of its children.
            return;
        }
    } //reheapDown




    private void swap(int index1, int index2) {
        T temp = array.get(index1);
        
        array.set(index1, array.get(index2));
        array.set(index2, temp);
    } //swap


    private int getLeftChild(int parent) {
        return (parent * 2) + 1;
    } //getLeftChild

    private int getRightChild(int parent) {
        return (parent * 2) + 2;
    } //getLeftChild

    private int getParent(int child) {
        return ((child - 1) / 2);
    } //getParent



    public int getRoot() {
        return root;
    } //getRoot
    public int getBottom() {
        return bottom;
    } //getBottom
    public ArrayList<T> getArray() {
        return this.array;
    } //getArray
    
} //Heap
