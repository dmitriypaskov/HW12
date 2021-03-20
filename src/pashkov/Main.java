package pashkov;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
        // 1)Write a Person class that has the following fields:
        // - Surname, Name, Patronymic, date of birth.
        //   Write constructors:
        // - to all fields,
        // - only in full name
        // - which takes 1 parameter - a string with the full name "Ivanov Ivan Ivanovich",
        //   and sets separate values in the Surname, First name, Patronymic fields.
        //   Write methods:
        // - which returns the full name of the type "Ivanov Ivan Ivanovich"
        // - short full name of the type "Ivanov I. I."
        // 2 *) Date of birth is set as a string like "12/18/1985"
        // - add a method that displays the number of full years.

        Person person = new Person("Pashkov","Dmytro","Stanislavovich","15.06.1993");
        Person person1 = new Person("Pashkov Dmytro Stanislavovich");
        System.out.println(person.fio());
        System.out.println(person.fioShort());
        System.out.println(person.age() + "years old");
        System.out.println(person1.fio());
        System.out.println(person1.fioShort());
    }
}
