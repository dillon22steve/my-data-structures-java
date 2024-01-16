package nodes.linked;



public class DoublyLinkedNode<T extends Comparable<T>> {

    private DoublyLinkedNode<T> next, back;
    private T data;


    public DoublyLinkedNode(T data) {
        this.data = data;
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
    public T getData() {
        return data;
    } //getData
    public void setData(T data) {
        this.data = data;
    } //setData
    
} //DoublyLinkedNode
