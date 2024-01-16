package data_structures.trees;

import nodes.trees.TreeNode;

public class Tree<T extends Comparable<T>> {

    TreeNode<T> root;


    public Tree() {
        root = null;
    } //constructor

    

    public boolean search(T itemToSearch, TreeNode<T> tree) {
        if (tree == null) {
            return false;
        } else if (itemToSearch.compareTo(tree.getData()) == 0) {
            return true;
        } else {
            int compare = itemToSearch.compareTo(tree.getData());
            if (compare < 0) {
                return search(itemToSearch, tree.getLeftChild());
            } else {
                return search(itemToSearch, tree.getRightChild());
            } //if
        } //if
    } //search



    public void inOrderTraversal(TreeNode<T> tree) {
        if (tree == null) {
            return;
        } //if

        inOrderTraversal(tree.getLeftChild());
        System.out.print("[" + tree.getData().toString() + "], ");
        inOrderTraversal(tree.getRightChild());
    } //inOrderTraversal

    public void postOrderTraversal(TreeNode<T> tree) {
        if (tree == null) {
            return;
        } //if

        inOrderTraversal(tree.getLeftChild());
        inOrderTraversal(tree.getRightChild());
        System.out.print("[" + tree.getData().toString() + "], ");
    } //postOrderTraversal

    public void preOrderTraversal(TreeNode<T> tree) {
        if (tree == null) {
            return;
        } //if

        System.out.print("[" + tree.getData().toString() + "], ");
        inOrderTraversal(tree.getLeftChild());
        inOrderTraversal(tree.getRightChild());
    } //preOrderTraversal
    
} //Tree
