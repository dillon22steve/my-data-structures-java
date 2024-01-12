package nodes.trees;

import person.Person;

public class BstNode {

    private BstNode leftChild, rightChild;
    private Person data;

    public BstNode(Person data) {
        this.data = data;
        leftChild = null;
        rightChild = null;
    } //constructor



    public BstNode getLeftChild() {
        return leftChild;
    } //getLeftChild

    public void setLeftChild(BstNode leftChild) {
        this.leftChild = leftChild;
    } //setLeftChild

    public BstNode getRightChild() {
        return rightChild;
    } //getRightChild

    public void setRightChild(BstNode rightChild) {
        this.rightChild = rightChild;
    } //setRightChild

    public Person getData() {
        return data;
    } //getData

    public void setData(Person data) {
        this.data = data;
    } //setData

} //Node
