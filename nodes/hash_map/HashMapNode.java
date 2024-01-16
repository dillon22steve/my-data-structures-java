package nodes.hash_map;

import person.Person;


public class HashMapNode {

    private Person data;
    private HashMapNode next;


    public HashMapNode(Person data) {
        this.data = data;
    } //constructor



    public Person getData() {
        return data;
    } //getData
    public void setData(Person data) {
        this.data = data;
    } //setData
    public HashMapNode getNext() {
        return next;
    } //getNext
    public void setNext(HashMapNode next) {
        this.next = next;
    } //setNext
    
} //HashMapNode
