package src.nodes.hash_map;

import src.nodes.Node;
import src.person.Person;


public class HashMapNode extends Node<Person> {

    private Person data;
    private HashMapNode next;


    public HashMapNode(Person data) {
        super(data);
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
