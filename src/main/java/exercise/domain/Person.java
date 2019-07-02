package exercise.domain;

import java.util.Date;

import static exercise.domain.Gender.FEMALE;

public class Person {

  private String name;
  private Gender gender;
  private Date birthDate;

  public Person(String name, Gender gender, Date birthDate) {
    this.name = name;
    this.gender = gender;
    this.birthDate = birthDate;
  }

  public String getName() {
    return name;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public boolean isFemale() {
    return this.gender == FEMALE;
  }
}
