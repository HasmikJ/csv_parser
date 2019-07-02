package exercise.domain;

import java.util.HashMap;
import java.util.Map;

public enum Gender {

  MALE("male"),
  FEMALE("female");

  private String gender;

  private static final Map<String, Gender> GENDER_FROM_STRING = new HashMap<>();

  static {
    for (Gender gender : Gender.values()) {
      GENDER_FROM_STRING.put(gender.getGender().toLowerCase(), gender);
    }
  }

  Gender(String gender) {
    this.gender = gender;
  }

  public static Gender valueOfIgnoreCase(String value) {

    if (value == null) {
      return null;
    }

    return GENDER_FROM_STRING.get(value.toLowerCase());
  }

  public String getGender() {
    return gender;
  }

}
