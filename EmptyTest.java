package edu.iastate.cs228.hw1.test;
  //@author Michael Jones
import static org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmptyTest {

  @Test 
  void checkMethods(){
    Town t = new Town(3, 3);
    Empty e = new Empty(t, 0, 0);
    State expected = State.EMPTY;
    State actual = e.who();

    assertEquals(expected, actual);
  }
}
