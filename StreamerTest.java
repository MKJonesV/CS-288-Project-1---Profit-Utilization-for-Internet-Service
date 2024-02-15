package edu.iastate.cs228.hw1.test;
  //@author Michael Jones
import static org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import edu.iastate.cs228.hw1.*;

public class StreamerTest {

  //@Test 
  void checkMethods(){
    Town t = new Town(3, 3);
    Streamer s = new Streamer(t, 0, 0);
    State expected = State.STREAMER;
    State actual = s.who();

    assertEquals(expected, actual);
  }
}
