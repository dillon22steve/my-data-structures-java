package src.data_structures.trees;

import src.data_structures.DataStructure;
import src.nodes.Node;
import src.nodes.trees.TreeNode;


public class AvlTree<T extends Comparable<T>> extends Tree<T> implements DataStructure<T> {

    public AvlTree() {
        root = null;
    } //constructor


    public void insert(T itemToInsert, TreeNode<T> tree) {
        if (root == null) {
            root = new TreeNode<T>(itemToInsert);
        } else if (tree == null) {
            //This will be reached if itemToInsert is a duplicate.
            return;
        } else {
            int compare = itemToInsert.compareTo(tree.getData());

            if (compare < 0) {
                if (tree.getLeftChild() == null) {
                    tree.setLeftChild(new TreeNode<T>(itemToInsert));
                    restructureIfNeeded(tree);
                } else {
                    insert(itemToInsert, tree.getLeftChild());
                } //if
            } else if (compare > 0) {
                if (tree.getRightChild() == null) {
                    tree.setRightChild(new TreeNode<T>(itemToInsert));
                } else {
                    insert(itemToInsert, tree.getRightChild());
                } //if
            } //if
        } //if
    } //insert


    private void restructureIfNeeded(TreeNode<T> tree) {
        
    } //restructureIfNeeded


    private TreeNode<T> rotateLeft(TreeNode<T> tree) {
        TreeNode<T> newParent = tree.getRightChild();
        TreeNode<T> newRight = newParent.getLeftChild();

        newParent.setLeftChild(tree);
        tree.setRightChild(newRight);

        return newParent;
    } //rotateLeft

    private TreeNode<T> rotateRight(TreeNode<T> tree) {
        TreeNode<T> newParent = tree.getLeftChild();
        TreeNode<T> newLeft = tree.getRightChild();

        newParent.setRightChild(tree);
        tree.setLeftChild(newLeft);

        return newParent;
    } //rotateRight


    public void insertAll(T[] items) {
        for (T item : items) {
            insert(item, root);
        } //for
    } //insertAll


    private int getBalanceFactor(TreeNode<T> tree) {
        return height(tree.getLeftChild()) - height(tree.getRightChild());
    } //getBalance
    private int height(TreeNode<T> tree) {
        if (tree == null) {
            return 0;
        } else {
            return 1 + height(tree.getRightChild()) + height(tree.getLeftChild());
        } //if
    } //height


    @Override
    public void insert(T itemToInsert) {
        insert(itemToInsert, root);
    } //insert

    @Override
    public void remove(T itemToRemove) {
        
    } //remove

    @Override
    public boolean search(T itemToSearch) {
        return search(itemToSearch, root);
    } //search

    @Override
    public Node<T> get() {
        return root;
    } //get

    
} //AvlTree
