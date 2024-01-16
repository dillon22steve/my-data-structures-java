package data_structures;

public interface DataStructure<T extends Comparable<T>> {

    public void insert(T itemToInsert);

    public void remove(T itemToRemove);

    public boolean search(T itemToSearch);

    public void destroy();

} //DataStructure