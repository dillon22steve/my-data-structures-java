package src.nodes;

public class Node<T extends Comparable<T>> {
    
    private T data;

    public Node(T data) {
        this.data = data;
    } //constructor

    public T getData() {
        return this.data;
    } //getData

    public void setData(T data) {
        this.data = data;
    } //setData

} //Node
