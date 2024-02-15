package edu.iastate.cs228.hw1.test;
  //@author Michael Jones
import static org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResellerTest {

  @Test 
  void checkMethods(){
    Town t = new Town(3, 3);
    Reseller r = new Reseller(t, 0, 0);
    State expected = State.RESELLER;
    State actual = r.who();
    
    assertEquals(expected, actual);
  }
}
