package data_structures.trees;

import person.Person;
import nodes.trees.BstNode;

public class BinarySearchTree extends Tree {

    private BstNode root;


    public BinarySearchTree() {
        super();
    } //constructor



    public void insert(Person personToInsert, BstNode node) {
        if (root == null) {
            root = new BstNode(personToInsert);
            return;
        } else {
            int compare = personToInsert.compareTo(node.getData());
            if (compare < 0) {
                if (node.getLeftChild() == null) {
                    node.setLeftChild(new BstNode(personToInsert));
                } else {
                    insert(personToInsert, node.getLeftChild());
                } //if
            } else if (compare > 0) {
                if (node.getRightChild() == null) {
                    node.setRightChild(new BstNode(personToInsert));
                } else {
                    insert(personToInsert, node.getRightChild());
                } //if
            } else {
                //If this is reached, that means the person is already present in
                //the list
                return;
            } //if
        } //if
    } //insert



    public BstNode remove(Person personToDelete, BstNode tree) {
        if (tree == null) {
            return null;
        } else {
            int compare = personToDelete.compareTo(tree.getData());
            if (compare < 0) {
                tree.setLeftChild(remove(personToDelete, tree.getLeftChild()));
                return tree;
            } else if (compare > 0) {
                tree.setRightChild(remove(personToDelete, tree.getRightChild()));
                return tree;
            } else if (compare == 0) {
                if (isLeafNode(tree)) {
                    tree = null;
                    return tree;
                } else if (hasTwoChildren(tree)) {
                    swapWithHighestLeft(tree);
                    return tree;
                } else {
                    if (tree.getLeftChild() == null) {
                        return tree.getRightChild();
                    }  else {
                        return tree.getLeftChild();
                    } //if
                } //if
            } else {
                return tree;
            }
        } //if
    } //remove


    private boolean isLeafNode(BstNode node) {
        if (node.getLeftChild() == null && node.getRightChild() == null) {
            return true;
        } else {
            return false;
        } //if
    } //isLeafNode
    private boolean hasTwoChildren(BstNode node) {
        if (node.getLeftChild() != null && node.getRightChild() != null) {
            return true;
        } else {
            return false;
        } //if
    } //hasTwoChildren


    private void swapWithHighestLeft(BstNode tree) {
        BstNode replacement = findHighestLeftSubtree(tree.getLeftChild());
        tree.setData(replacement.getData());
        remove(replacement.getData(), tree.getLeftChild());
    } //swapWithHighestLeft

    private BstNode findHighestLeftSubtree(BstNode tree) {
        BstNode temp = tree.getRightChild();
        while (temp.getRightChild() != null) {
            temp = temp.getRightChild();
        } //while
        return temp;
    } //findHighestLeftChild



    public void makeEmpty() {
        root = null;
    } //makeEmpty

    public boolean isEmpty() {
        return root == null;
    } //isEmpty


    public BstNode getRoot() {
        return this.root;
    } //getRoot
    
} //BinarySearchTree
