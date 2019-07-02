package exercise;

import exercise.domain.Person;

import static exercise.domain.Gender.valueOfIgnoreCase;
import static exercise.utils.DateUtil.stringToDate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {

  private static final String DELIMITER = ",";

  public static List<Person> retrievePersonsFromCsv(String path) {

    BufferedReader fileReader = null;

    List<Person> persons = new ArrayList<>();

    try {
      String line;
      fileReader = new BufferedReader(new FileReader(path));

      while ((line = fileReader.readLine()) != null) {
        String[] props = line.split(DELIMITER);
        if (props.length > 2) {
          persons.add(new Person(props[0], valueOfIgnoreCase(props[1].trim()), stringToDate(props[2].trim())));
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (fileReader != null) {
          fileReader.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return persons;
  }
}
