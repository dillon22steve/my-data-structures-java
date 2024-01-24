package src.nodes.trees;

import src.nodes.Node;

public class RedBlackNode<T extends Comparable<T>> extends Node<T> {

    private char color;
    private RedBlackNode<T> parent;
    private RedBlackNode<T> leftChild;
    private RedBlackNode<T> rightChild;

    public RedBlackNode(T data, char color, RedBlackNode<T> parent) {
        super(data);
        this.color = color;
        this.parent = parent;
    } //constructor


    public char getColor() {
        return color;
    } //getColor

    public void setColor(char color) {
        this.color = color;
    } //setColor


    public RedBlackNode<T> getParent() {
        return parent;
    } //getParent

    public void setParent(RedBlackNode<T> parent) {
        this.parent = parent;
    } //setParent


    public RedBlackNode<T> getLeftChild() {
        return leftChild;
    } //getLeftChild

    public void setLeftChild(RedBlackNode<T> leftChild) {
        this.leftChild = leftChild;
    } //setLeftChild


    public RedBlackNode<T> getRightChild() {
        return rightChild;
    } //getRightChild

    public void setRightChild(RedBlackNode<T> rightChild) {
        this.rightChild = rightChild;
    } //setRightChild
    
} //RedBlackNode
