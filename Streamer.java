package edu.iastate.cs228.hw1;
// @author Michael Jones

public class Streamer extends TownCell {

  State s = State.STREAMER;
  TownCell t;
  
  public Streamer(Town p, int r, int c) {
    super(p, r, c);
  }
  
  public String toString() {
    return "S";
  }

  public State who(){
    return s;
  }

  @Override
  public TownCell next(Town tNew){
    census(nCensus);
    if(nCensus[RESELLER] > 0){
      t = new Outage(tNew, row, col);
    }else if(nCensus[OUTAGE] > 0){
      t = new Empty(tNew, row, col);
    }else{
      t = new Streamer(tNew, row, col);
    }
    return finalCases(this, t, tNew);
  } 
}
