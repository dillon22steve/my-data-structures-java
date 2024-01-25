package src.nodes.hash_map;

import src.nodes.Node;
import src.person.Person;


public class HashMapNode extends Node<Person> {

    private HashMapNode next;


    public HashMapNode(Person data) {
        super(data);
    } //constructor


    public HashMapNode getNext() {
        return next;
    } //getNext
    public void setNext(HashMapNode next) {
        this.next = next;
    } //setNext
    
} //HashMapNode
