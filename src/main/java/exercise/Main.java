package exercise;


import exercise.domain.Person;

import static exercise.CsvParser.retrievePersonsFromCsv;
import static java.lang.System.out;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {

  public static void main(String[] args) {
    List<Person> persons = retrievePersonsFromCsv("src/testdata/address-book.csv");

    out.println("Female count in address book is: " + persons.stream().filter(Person::isFemale).count());

    getOldestPersonFromAddressBook(persons).ifPresent(p -> out.println(
        "The oldest person in address book is: '" + p.getName() + "' and his/her birthdate is: '" + p.getBirthDate()
            + "'"));
  }

  private static Optional<Person> getOldestPersonFromAddressBook(List<Person> persons) {
    return persons.stream().min(Comparator.comparing(Person::getBirthDate));
  }

}
