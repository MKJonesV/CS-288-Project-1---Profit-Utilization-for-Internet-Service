//package edu.iastate.cs228.hw1;
// @author Michael Jones

public class Reseller extends TownCell {

  State s = State.RESELLER;
  TownCell t;
  
  public Reseller(Town p, int r, int c) {
    super(p, r, c);
  }
  
  public String toString() {
    return "R";
  }

  public State who(){
    return s;
  }

  @Override
  public TownCell next(Town tNew){
    census(nCensus);
    if(nCensus[CASUAL] <= 3 || nCensus[EMPTY] >= 3){
      t = new Empty(tNew, row, col);
    }else{
      t = new Reseller(tNew, row, col);
    }
    return finalCases(this, t, tNew);
  } 
}
