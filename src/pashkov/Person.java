package pashkov;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Person {

    private StringBuilder sb = new StringBuilder();
    private String surname;
    private String name;
    private String patronymic;
    private String fullName;
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
        sb.append(fullName.trim());
        int a = 0;
        int b = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                a = i;
                sb.deleteCharAt(i);
                break;
            }
        }
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                b = i;
                sb.deleteCharAt(i);
                break;
            }
        }

        this.surname = sb.substring(0, a);
        this.name = sb.substring(a, b);
        this.patronymic = sb.substring(b);
    }

    public String fio() {
        String fio = surname + " " + name + " " + patronymic;
        return fio;
    }

    public String fioShort() {
        char name1 = name.charAt(0);
        char patronymic1 = patronymic.charAt(0);
        String fioS = surname + " " + name1 + ". " + patronymic1 + ".";
        return fioS;
    }

    public int age() throws ParseException {
        Date birthDate = new SimpleDateFormat("dd.MM.yyyy").parse(dateOfBirth);
        LocalDate localDateBirth = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate dateNow = LocalDate.now();
        int age = Period.between(localDateBirth, dateNow).getYears();
        return age;
    }
}
