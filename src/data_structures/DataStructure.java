package src.data_structures;

import src.nodes.Node;


public interface DataStructure<T extends Comparable<T>> {

    public void insert(T itemToInsert);

    public void remove(T itemToRemove);

    public boolean search(T itemToSearch);

    public void destroy();

    public Node<T> get();

} //DataStructure