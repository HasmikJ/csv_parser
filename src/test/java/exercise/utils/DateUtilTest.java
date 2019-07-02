package exercise.utils;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class DateUtilTest {

  private static final String PATTERN_DATE = "yyyy-MM-dd";

  private SimpleDateFormat formatter;

  @Before
  public void setUp() {
    formatter = new SimpleDateFormat(PATTERN_DATE);
  }

  @Test
  public void formatDate_withGivenDateString_shouldParseDate() throws ParseException {

    Date date = DateUtil.stringToDate("1973-04-20");

    assertThat(formatter.parse("1973-04-20"), equalTo(date));
  }

  @Test(expected = ParseException.class)
  public void formatDate_withNotValidString_shouldThrowParseException() throws ParseException {

    DateUtil.stringToDate("1232434");
  }

}