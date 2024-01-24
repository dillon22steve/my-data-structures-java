package src.data_structures.trees;

import src.data_structures.DataStructure;
import src.nodes.Node;
import src.nodes.trees.RedBlackNode;


public class RedBlackTree<T extends Comparable<T>> extends Tree<T> implements DataStructure<T> {

    private RedBlackNode<T> rootNode;


    public RedBlackTree() {
        rootNode = null;
    } //constructor


    public void insert(T itemToInsert, RedBlackNode<T> tree) {
        if (rootNode == null) {
            rootNode = new RedBlackNode<T>(itemToInsert, 'b', null);
        } else if (tree == null) {
            return;
        } else {
            int compare = itemToInsert.compareTo(tree.getData());
            if (compare < 0) {
                if (tree.getLeftChild() == null) {
                    tree.setLeftChild(new RedBlackNode<T>(itemToInsert, 'r', tree));

                    if (tree.getColor() == 'r') {
                        reColor(tree.getLeftChild());
                    } //if
                } else {
                    insert(itemToInsert, tree.getLeftChild());
                } //if
            } else if (compare > 0) {
                if (tree.getRightChild() == null) {
                    tree.setRightChild(new RedBlackNode<T>(itemToInsert, 'r', tree));

                    if (tree.getColor() == 'r') {
                        reColor(tree.getRightChild());
                    } //if
                } else {
                    insert(itemToInsert, tree.getRightChild());
                } //if
            } //if
        } //if
    } //insert


    private void reColor(RedBlackNode<T> tree) {
        if (tree == null) {
            return;
        } else {
            RedBlackNode<T> parent = tree.getParent();
            RedBlackNode<T> grandparent = getGrandParent(tree);
            RedBlackNode<T> uncle = getUncle(tree);

            if (parent != null && parent.getColor() == 'r') {
                if (uncle != null) {
                    if (uncle.getColor() == 'r') {
                        parent.setColor('b');
                        uncle.setColor('b');

                        if (grandparent != rootNode) {
                            grandparent.setColor('r');
                            reColor(grandparent);
                        } //if
                    } //if
                } else {
                    //restructure(tree);
                } //if
            } else {
                restructure(tree);
            } //if
        } //if
    } //reColor

    private RedBlackNode<T> getGrandParent(RedBlackNode<T> node) {
        if (node == null) {
            return null;
        } else {
            RedBlackNode<T> parent = node.getParent();
            if (parent == null) {
                return null;
            } else {
                return parent.getParent();
            } //if
        } //if
    } //getGrandParent

    private RedBlackNode<T> getUncle(RedBlackNode<T> node) {
        if (node == null) {
            return null;
        } else {
            RedBlackNode<T> grandParent = getGrandParent(node);
            if (grandParent == null) {
                return null;
            } else {
                if (node.getParent() == grandParent.getLeftChild()) {
                    return grandParent.getRightChild();
                } else {
                    return grandParent.getLeftChild();
                } //if
            } //if
        } //if
    } //getUncle


    private void restructure(RedBlackNode<T> tree) {
        System.out.println(tree.getData());
        RedBlackNode<T> parent = tree.getParent();
        RedBlackNode<T> grandparent = getGrandParent(tree);

        
        if (tree == parent.getRightChild() && parent == grandparent.getLeftChild()) {
            leftRightRotation(tree);
        } else if (tree == parent.getLeftChild() && parent == grandparent.getRightChild()) {
            rightLeftRotation(tree);
        } else if (tree == parent.getLeftChild() && parent == grandparent.getLeftChild()) {
            singleRightRotation(tree);
        } else if (tree == parent.getRightChild() && parent == grandparent.getRightChild()) {
            singleLeftRotation(tree);
        } //if
    } //restructure


    private void leftRightRotation(RedBlackNode<T> tree) {
        RedBlackNode<T> parent = tree.getParent();
        RedBlackNode<T> grandparent = getGrandParent(tree);

        grandparent.setLeftChild(tree);
        tree.setLeftChild(parent);

        grandparent.getParent().setLeftChild(tree);
        tree.setRightChild(grandparent);
        grandparent.setLeftChild(null);

        tree.setColor('b');
        tree.getRightChild().setColor('r');
        tree.getLeftChild().setColor('r');
    } //leftRightRotation

    private void rightLeftRotation(RedBlackNode<T> tree) {
        RedBlackNode<T> parent = tree.getParent();
        RedBlackNode<T> grandparent = getGrandParent(tree);

        grandparent.setRightChild(tree);
        tree.setRightChild(parent);

        grandparent.getParent().setLeftChild(tree);
        tree.setLeftChild(grandparent);

        tree.setColor('b');
        tree.getLeftChild().setColor('r');
        tree.getRightChild().setColor('r');
    } //rightLeftRotation

    private void singleRightRotation(RedBlackNode<T> tree) {
        RedBlackNode<T> parent = tree.getParent();
        RedBlackNode<T> grandparent = getGrandParent(tree);

        grandparent.setLeftChild(parent.getRightChild());
        parent.setRightChild(grandparent);
        grandparent.setColor('r');
        parent.setColor('b');
    } //leftLeftRotation

    private void singleLeftRotation(RedBlackNode<T> tree) {
        RedBlackNode<T> parent = tree.getParent();
        RedBlackNode<T> grandparent = getGrandParent(tree);

        grandparent.setRightChild(parent.getLeftChild());
        parent.setLeftChild(grandparent);
        grandparent.setColor('r');
        parent.setColor('b');
    } //singleLeftRotation



    public void insertAll(T[] items) {
        for (T item : items) {
            insert(item, rootNode);
        } //for
    } //insertAll



    public void inOrderTraversal(RedBlackNode<T> tree) {
        if (tree == null) {
            return;
        } //if

        inOrderTraversal(tree.getLeftChild());
        System.out.print("[" + tree.getData().toString() + "], ");
        inOrderTraversal(tree.getRightChild());
    } //inOrderTraversal



    @Override
    public void insert(T itemToInsert) {
        insert(itemToInsert, rootNode);
    } //insert

    @Override
    public void remove(T itemToRemove) {
        
    } //remove

    @Override
    public boolean search(T itemToSearch) {
        return true;
    } //search

    @Override
    public Node<T> get() {
        return rootNode;
    } //get

    public RedBlackNode<T> getRootNode() {
        return this.rootNode;
    } //getRootNode
    
} //RedBlackTree
