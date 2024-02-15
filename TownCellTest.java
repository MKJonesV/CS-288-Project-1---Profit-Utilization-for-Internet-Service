package edu.iastate.cs228.hw1.test;
  //@author Michael Jones
import static org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TownCellTest {

  @Test 
  void checkMethods(){

    Town t = new Town(3, 3);
    Outage o = new Outage(t, 0, 0);
    Empty e = new Empty(t, 0, 0);
    TownCell expected = e;
    TownCell actual = o.next(t);

    assertEquals(expected, actual);
  }
}

