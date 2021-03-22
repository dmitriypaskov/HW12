package pashkov;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Person {

    private final String surname;
    private final String name;
    private final String patronymic;
    private String dateOfBirth;

    public Person(String surname, String name, String patronymic, String dateOfBirth) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
    }

    public Person(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public Person(String fullName) {
        String[] parts = fullName.split("\\s+");
        this.surname = parts[0];
        this.name = parts[1];
        this.patronymic = parts[2];

    }

    public String getFullName() {
        return surname + " " + name + " " + patronymic;
    }

    public String getNameWithInitials() {
        char name1 = name.charAt(0);
        char patronymic1 = patronymic.charAt(0);
        return surname + " " + name1 + ". " + patronymic1 + ".";
    }

    public int getAge() throws ParseException {
        Date birthDate = new SimpleDateFormat("dd.MM.yyyy").parse(dateOfBirth);
        LocalDate localDateBirth = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate dateNow = LocalDate.now();
        return Period.between(localDateBirth, dateNow).getYears();
    }
}
