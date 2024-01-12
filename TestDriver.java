import person.Person;
import data_structures.linked_list.*;
import data_structures.linked_list.singly_linked.UnsortedLinkedList;

public class TestDriver {


    public static void main(String[] args) {
        Person.initIdChars();
        Person[] people = initPeople();
        TestLists(people);
    } //main

    private static Person[] initPeople() {
        Person[] arrToReturn = {
            new Person("Lisa", 55),
            new Person("Rich", 29),
            new Person("Mike", 59),
            new Person("Steve", 31),
            new Person("Alana", 29),
            new Person("Renee", 39),
            new Person("Amanda", 35)
        };

        return arrToReturn;
    } //initPeople



    private static void TestLists(Person[] people) {
        TestUnsortedList(people);
    } //TestLists
    private static void TestUnsortedList(Person[] people) {
        UnsortedLinkedList testList = new UnsortedLinkedList();

        testList.insertAll(people);
        String expectedString = "[Amanda is 35], [Renee is 39], [Alana is 29], [Steve is 31], [Mike is 59], [Rich is 29], [Lisa is 55]";
        IsWorking(expectedString, testList.toString(), "Insert (not empty)");

        IsWorking("true", ("" + testList.search(people[0])), "Search beginning");
        IsWorking("true", ("" + testList.search(people[people.length - 1])), "Search end");
        IsWorking("true", ("" + testList.search(people[3])), "Search middle");
        IsWorking("false", ("" + testList.search(new Person("Ryan", 75))), "Search not present");

        testList.remove(people[people.length - 1]);
        expectedString = "[Amanda is 35], [Renee is 39], [Alana is 29], [Steve is 31], [Mike is 59], [Rich is 29]";
        IsWorking(expectedString, testList.toString(), "Remove from end");

        testList.remove(people[2]);
        expectedString = "[Amanda is 35], [Renee is 39], [Alana is 29], [Steve is 31], [Rich is 29]";
        IsWorking(expectedString, testList.toString(), "Remove from middle");

        testList.remove(people[0]);
        expectedString = "[Renee is 39], [Alana is 29], [Steve is 31], [Rich is 29]";
        IsWorking(expectedString, testList.toString(), "Remove from beginning");
    } //TestUnsortedList
    private static void TestSortedList() {
        
    }



    public static void TestTrees() {
        TestBst();
    } //TestTrees
    private static void TestBst() {

    } //TestBst



    private static void IsWorking(String expectedString, String stringReceived, String methodTested) {
        if (!(stringReceived.equals(expectedString))) {
            System.out.println(methodTested + "             FAILED");
            System.out.println("Expected: " + expectedString);
            System.out.println("But got: " + stringReceived);
        } else {
            System.out.println(methodTested + "             PASSED");
        } //if
    }  //isWorking
    
} //TestDriver
