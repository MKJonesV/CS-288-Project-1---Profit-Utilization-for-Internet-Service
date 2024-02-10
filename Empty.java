//package edu.iastate.cs228.hw1;
// @author Michael Jones

public class Empty extends TownCell {

  State s = State.EMPTY;
  TownCell t;
  
  public Empty(Town p, int r, int c) {
    super(p, r, c);
  }
  
  public String toString() {
    return "E";
  }
  public State who(){
    return s;
  }

  @Override
  public TownCell next(Town tNew){
    census(nCensus);
    t = new Casual(tNew, row, col);
    return finalCases(this, t, tNew);
  }  
}
