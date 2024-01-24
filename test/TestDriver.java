package test;

import src.person.Person;

public class TestDriver {

    public static void main(String[] args) {
        Person.initIdChars();
        Tester tester = new Tester();
        tester.runTests();
    } //main
    
} //TestDriver
