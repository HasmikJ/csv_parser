package exercise.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
  private static final String PATTERN_DATE = "yyyy-MM-dd";

  public static Date stringToDate(final String dateString) throws ParseException {
    return new SimpleDateFormat(PATTERN_DATE).parse(dateString);
  }
}