package edu.iastate.cs228.hw1.test;
  //@author Michael Jones
import static org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.iastate.cs228.hw1.Town;

public class TownTest {

  @Test 
  void checkMethods(){

    int x = 1;
    int y = 1;
    int z = 1;
    Town t = new Town(3, 3);

    TownCell expected = new Streamer(t, x, y);
    TownCell actual = t.makeTownCell(z, x, y, t);

    assertEquals(expected, actual);
  }
}
