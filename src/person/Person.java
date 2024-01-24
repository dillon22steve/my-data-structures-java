package src.person;

public class Person implements Comparable<Person> {

    public static final int NUM_CHARS = 70;

    //The characters that will be used to randomly generate the person's id.
    public static char[] idChars = new char[NUM_CHARS];

    //The special characters that will be added to the list of id characters
    public static char[] specialChars = {
        '!', '@', '#', '$', '%', '&', '*', '?'
    };

    private String name;
    private int age;
    private String id;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;

        generateRandomId();
    } //constructor



    /**
     * Initializes the idChars array that will be used to randomly generate the
     * object's id.
     */
    public static void initIdChars() {
        //Adds the numbers 0-9 to the id array.
        addToIdArr(0, 10, '0');

        //Adds the lowercase letters to the array.
        addToIdArr(10, 36, 'a');

        //Adds the uppercase letters to the array.
        addToIdArr(36, 62, 'A');

        //Adds the special characters to the list of possible id chars
        for (int i = 62, j = 0; j < specialChars.length; i++, j++) {
            idChars[i] = specialChars[j];
        } //for
    } //initIdChars

    private static void addToIdArr(int startIndex, int endIndex, char initialChar) {
        char charToAdd = initialChar;
        for (int i = startIndex; i < endIndex; i++) {
            idChars[i] = charToAdd;
            charToAdd++;
        } //for
    } //addToIdArr

    private void generateRandomId() {
        id = "";
        for (int i = 0; i < 25; i++) {
            int randIndex = (int)(Math.random() * idChars.length);
            id = id + idChars[randIndex];
        } //for
    } //generateRandomId



    public boolean equals(Person otherPerson) {
        if (this.id.equals(otherPerson.id)) {
            //System.out.println("this: [" + this.name + ", " + this.id + "], " + "other: [" + otherPerson.name + ", " + otherPerson.id);
            return true;
        } else {
            return false;
        } //if
    } //equals


    public int compareTo(Person otherPerson) {
        int compare = name.compareTo(otherPerson.name);
        if (compare == 0) {
            return id.compareTo(otherPerson.id);
        } else {
            return compare;
        } //if
    } //compareTo




    public String getName() {
        return name;
    } //getName
    public void setName(String name) {
        this.name = name;
    } //setName
    public int getAge() {
        return age;
    } //getAge
    public void setAge(int age) {
        this.age = age;
    } //setAge
    public String getId() {
        return this.id;
    } //getId


    @Override
    public String toString() {
        return this.name;
    } //toString

} //Person
