package data_structures;

import person.Person;

public interface DataStructure {

    public void insert(Person personToInsert);

    public void remove(Person personToRemove);

    public boolean search(Person personToSearch);

    public void destroy();

} //DataStructure