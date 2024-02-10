package edu.iastate.cs228.hw1;
// @author Michael Jones

public class Outage extends TownCell {

  State s = State.OUTAGE;
  TownCell t;
  
  public Outage(Town p, int r, int c) {
    super(p, r, c);
  }
  
  public String toString() {
    return "O";
  }

  public State who(){
    return s;
  }

  @Override
  public TownCell next(Town tNew){
    census(nCensus);
    t = new Empty(tNew, row, col);
    return finalCases(this, t, tNew);
  }  
}
