package edu.iastate.cs228.hw1.test;
  //@author Michael Jones
import static org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import edu.iastate.cs228.hw1.*;

public class ISPBusinessTest {

  //@Test 
  void checkMethods(){
    
    ISPBuisness i = new ISPBuisness();
    i.tOld = new Town(3, 3);
    i.totalProfit = 0;
    double expected = 0.0;
    double actual = finalProfit();

    assertEquals(expected, actual);
  }
}
