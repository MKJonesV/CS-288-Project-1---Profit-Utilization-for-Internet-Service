package edu.iastate.cs228.hw1.test;
  //@author Michael Jones
import static org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasualTest {

  @Test 
  void checkMethods(){
    Town t = new Town(3, 3);
    Casual c = new Casual(t, 0, 0);
    State expected = State.CASUAL;
    State actual = c.who();

    assertEquals(expected, actual);
  }
}
