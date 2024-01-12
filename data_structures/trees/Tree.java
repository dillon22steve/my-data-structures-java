package data_structures.trees;

import nodes.trees.BstNode;
import person.Person;

public class Tree {

    BstNode root;


    public Tree() {
        root = null;
    } //constructor

    

    public boolean search(Person personToSearch, BstNode tree) {
        if (tree == null) {
            return false;
        } else if (personToSearch.equals(tree.getData())) {
            return true;
        } else {
            int compare = personToSearch.compareTo(tree.getData());
            if (compare < 0) {
                return search(personToSearch, tree.getLeftChild());
            } else {
                return search(personToSearch, tree.getRightChild());
            } //if
        } //if
    } //search



    public void inOrderTraversal(BstNode tree) {
        if (tree == null) {
            return;
        } //if

        inOrderTraversal(tree.getLeftChild());
        System.out.print("[" + tree.getData().getName() + "], ");
        inOrderTraversal(tree.getRightChild());
    } //inOrderTraversal

    public void postOrderTraversal(BstNode tree) {
        if (tree == null) {
            return;
        } //if

        inOrderTraversal(tree.getLeftChild());
        inOrderTraversal(tree.getRightChild());
        System.out.print("[" + tree.getData().getName() + "], ");
    } //postOrderTraversal

    public void preOrderTraversal(BstNode tree) {
        if (tree == null) {
            return;
        } //if

        System.out.print("[" + tree.getData().getName() + "], ");
        inOrderTraversal(tree.getLeftChild());
        inOrderTraversal(tree.getRightChild());
    } //preOrderTraversal
    
} //Tree
