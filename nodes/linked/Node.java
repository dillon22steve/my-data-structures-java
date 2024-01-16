package nodes.linked;

public class Node <T extends Comparable<T>> {

    private Node<T> next;
    private T data;

    public Node(T data) {
        this.data = data;
        this.next = null;
    } //constructor

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    } //constructor



    public Node<T> getNext() {
        return next;
    } //getNext

    public void setNext(Node<T> next) {
        this.next = next;
    } //setNext

    public T getData() {
        return data;
    } //getData

    public void setData(T data) {
        this.data = data;
    } //setData

} //Node
