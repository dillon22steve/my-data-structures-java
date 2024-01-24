package src.utils.constants;

import src.person.Person;

public class PersonConstants {

    public static Person steve, rich, lisa, mike, alana, amanda, renee, tim, kathy, chuck,
        bill, randy, stan, jim, pam, michael, stanley, dwight;

    public static Person[] people;


    public static void InitPeople() {
        steve = new Person("Steve", 31);
        rich = new Person("Rich", 28);
        lisa = new Person("Lisa", 55);
        mike = new Person("Mike", 59);
        alana = new Person("Alana", 29);
        amanda = new Person("Amanda", 35);
        renee = new Person("Renee", 39);
        tim = new Person("Tim", 63);
        kathy = new Person("Kathy", 65);
        chuck = new Person("Chuck", 91);
        bill = new Person("Bill", 91);
        randy = new Person("Randy", 19);
        stan = new Person("Stan", 43);
        jim = new Person("Jim Halpert", 31);
        pam = new Person("Pam Beasley", 27);
        michael = new Person("Michael Scott", 41);
        stanley = new Person("Stanley Hudson", 61);
        dwight = new Person("Dwight Schrute", 35);

        people = new Person[18];
        people[0] = steve;
        people[1] = rich;
        people[2] = lisa;
        people[3] = mike;
        people[4] = alana;
        people[5] = amanda;
        people[6] = renee;
        people[7] = tim;
        people[8] = kathy;
        people[9] = chuck;
        people[10] = bill;
        people[11] = randy;
        people[12] = stan;
        people[13] = jim;
        people[14] = pam;
        people[15] = michael;
        people[16] = stanley;
        people[17] = dwight;
    } //InitPeople


    public static void RandomizePeople() {
        people[0] = mike;
        people[3] = steve;

        int lastIndex = (people.length - 1);
        while (lastIndex > 0) {
            int randIndex = (int)(Math.random() * lastIndex) + 1;

            Person temp = people[randIndex];
            people[randIndex] = people[lastIndex];
            people[lastIndex] = temp;

            lastIndex--;
        } //while
    } //RandomizePeople
    
} //PersonConstants
