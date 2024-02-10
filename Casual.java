//package edu.iastate.cs228.hw1;
// @author Michael Jones

public class Casual extends TownCell {

  State s = State.CASUAL;
  TownCell t;
  
  public Casual(Town p, int r, int c) {
    super(p, r, c);
  }
  
  public String toString() {
    return "C";
  }

  public State who(){
    return s;
  }

  @Override
  public TownCell next(Town tNew){
    census(nCensus);
    if(nCensus[RESELLER] > 0){
      t = new Outage(tNew, row, col);
    }else if(nCensus[STREAMER] > 0){
      t = new Streamer(tNew, row, col);
    }else{
      t = new Casual(tNew, row, col);
    }
    return finalCases(this, t, tNew);
  }  
}
