package exercise;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MainTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final PrintStream originalErr = System.err;

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }

  @After
  public void restoreStreams() {
    System.setOut(originalOut);
    System.setErr(originalErr);
  }

  @Test
  public void main() {
    String expectedOutput = "Female count in address book is: 2\n"
        + "The oldest person in address book is: 'Michael' and his/her birthdate is: 'Fri Apr 20 00:00:00 CET 1973'\n";
    Main.main(new String[]{});
    assertEquals(expectedOutput, outContent.toString());
  }

}