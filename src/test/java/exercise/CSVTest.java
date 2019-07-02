package exercise;

import exercise.domain.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static exercise.CsvParser.retrievePersonsFromCsv;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CSVTest {

  private List<Person> persons;

  @Test
  public void csvParser_sizeOfPersonsIsCorrect() {
    persons = retrievePersonsFromCsv("src/testdata/address-book.csv");
    assertThat(persons.size(), equalTo(5));
  }

  /**
   * Jon, Male, 1985-03-09       valid
   * Paul, Male,                 invalid
   * Jessica, Female, 1990-11-05 valid
   * Sarah, 1980-08-17           invalid
   * Male, 1973-04-20            invalid
   */
  @Test
  public void csvParser_parseOnlyValidLines() {
    persons = retrievePersonsFromCsv("src/testdata/address-book-dummy-data.csv");
    assertThat(persons.size(), equalTo(2));
  }

  @Test
  public void csvParser_checkContentOfCsv_personsAreSetCorrectly() {
    persons = retrievePersonsFromCsv("src/testdata/address-book.csv");
    List<String> personNames = persons.stream().map(Person::getName).collect(Collectors.toList());
    List<String> testNames = asList("Jessica", "Michael", "Paul", "Jon", "Sarah");
    testNames.stream().map(personNames::contains).forEach(Assert::assertTrue);
  }

}