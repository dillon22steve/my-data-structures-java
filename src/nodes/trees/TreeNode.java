package src.nodes.trees;

import src.nodes.Node;


public class TreeNode<T extends Comparable<T>> extends Node<T> {

    private TreeNode<T> leftChild, rightChild;

    public TreeNode(T data) {
        super(data);
        leftChild = null;
        rightChild = null;
    } //constructor



    public TreeNode<T> getLeftChild() {
        return leftChild;
    } //getLeftChild

    public void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    } //setLeftChild

    public TreeNode<T> getRightChild() {
        return rightChild;
    } //getRightChild

    public void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
    } //setRightChild

} //Node
