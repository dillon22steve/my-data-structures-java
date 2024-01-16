package data_structures.trees;

import nodes.trees.TreeNode;

public class BinarySearchTree<T extends Comparable<T>> extends Tree<T> {

    private TreeNode<T> root;


    public BinarySearchTree() {
        super();
    } //constructor



    public void insert(T itemToInsert, TreeNode<T> node) {
        if (root == null) {
            root = new TreeNode<T>(itemToInsert);
            return;
        } else {
            int compare = itemToInsert.compareTo(node.getData());
            if (compare < 0) {
                if (node.getLeftChild() == null) {
                    node.setLeftChild(new TreeNode<T>(itemToInsert));
                } else {
                    insert(itemToInsert, node.getLeftChild());
                } //if
            } else if (compare > 0) {
                if (node.getRightChild() == null) {
                    node.setRightChild(new TreeNode<T>(itemToInsert));
                } else {
                    insert(itemToInsert, node.getRightChild());
                } //if
            } else {
                //If this is reached, that means the person is already present in
                //the list
                return;
            } //if
        } //if
    } //insert

    public void insertAll(T[] items) {
        for (T item : items) {
            insert(item, root);
        } //for
    } //insertAll



    public TreeNode<T> remove(T itemToDelete, TreeNode<T> tree) {
        if (tree == null) {
            return null;
        } else {
            int compare = itemToDelete.compareTo(tree.getData());
            if (compare < 0) {
                tree.setLeftChild(remove(itemToDelete, tree.getLeftChild()));
                return tree;
            } else if (compare > 0) {
                tree.setRightChild(remove(itemToDelete, tree.getRightChild()));
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


    private boolean isLeafNode(TreeNode<T> node) {
        if (node.getLeftChild() == null && node.getRightChild() == null) {
            return true;
        } else {
            return false;
        } //if
    } //isLeafNode
    private boolean hasTwoChildren(TreeNode<T> node) {
        if (node.getLeftChild() != null && node.getRightChild() != null) {
            return true;
        } else {
            return false;
        } //if
    } //hasTwoChildren


    private void swapWithHighestLeft(TreeNode<T> tree) {
        TreeNode<T> replacement = findHighestLeftSubtree(tree.getLeftChild());
        tree.setData(replacement.getData());
        remove(replacement.getData(), tree.getLeftChild());
    } //swapWithHighestLeft

    private TreeNode<T> findHighestLeftSubtree(TreeNode<T> tree) {
        TreeNode<T> temp = tree.getRightChild();
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


    public TreeNode<T> getRoot() {
        return this.root;
    } //getRoot
    
} //BinarySearchTree
