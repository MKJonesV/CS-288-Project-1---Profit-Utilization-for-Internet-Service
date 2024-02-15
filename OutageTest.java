package edu.iastate.cs228.hw1.test;
  //@author Michael Jones
import static org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import edu.iastate.cs228.hw1.*;

public class OutageTest {

  //@Test 
  void checkMethods(){
    Town t = new Town(3, 3);
    Outage o = new Outage(t, 0, 0);
    State expected = State.OUTAGE;
    State actual = o.who();

    assertEquals(expected, actual);
  }
}
