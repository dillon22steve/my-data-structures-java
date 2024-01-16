package nodes.trees;


public class TreeNode<T extends Comparable<T>> {

    private TreeNode<T> leftChild, rightChild;
    private T data;

    public TreeNode(T data) {
        this.data = data;
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

    public T getData() {
        return data;
    } //getData

    public void setData(T data) {
        this.data = data;
    } //setData

} //Node
