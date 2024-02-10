//package edu.iastate.cs228.hw1;
//@author Michael Jones

public class TownCell {

  protected Town plain;
  protected int row;
  protected int col;

  // constants to be used as indices.
  protected static final int RESELLER = 0;
  protected static final int EMPTY = 1;
  protected static final int CASUAL = 2;
  protected static final int OUTAGE = 3;
  protected static final int STREAMER = 4;

  public static final int NUM_CELL_TYPE = 5;

  //Use this static array to take census.
  public static final int[] nCensus = new int[NUM_CELL_TYPE];

  public TownCell(Town p, int r, int c) {
    plain = p;
    row = r;
    col = c;
  }

  /**
   * Checks all neigborhood cell types in the neighborhood.
   * Refer to homework pdf for neighbor definitions (all adjacent
   * neighbors excluding the center cell).
   * Use who() method to get who is present in the neighborhood
   *  
   * @param counts of all customers
   */
  public void census(int[] nCensus) {
    // zero the counts of all customers
    nCensus[RESELLER] = 0; 
    nCensus[EMPTY] = 0; 
    nCensus[CASUAL] = 0; 
    nCensus[OUTAGE] = 0; 
    nCensus[STREAMER] = 0; 

    
    for(int i = -1; i < 2; i++){
      for(int j = -1; j < 2; j++){
        try { 
          if(i == 0 && j == 0){ // skips the center cell
            continue;
          }else if((plain.grid[row+i][col+j]).who() == State.RESELLER){
            nCensus[RESELLER]++;
          }else if((plain.grid[row+i][col+j]).who() == State.EMPTY){
            nCensus[EMPTY]++;
          }else if((plain.grid[row+i][col+j]).who() == State.CASUAL){
            nCensus[CASUAL]++;
          }else if((plain.grid[row+i][col+j]).who() == State.OUTAGE){
            nCensus[OUTAGE]++;
          }else if((plain.grid[row+i][col+j]).who() == State.STREAMER){
            nCensus[STREAMER]++;
          }
        } catch (IndexOutOfBoundsException e){ // Catches any IndexOutOfBoundsExceptions thrown by the if statements as a result of the for loops, and continues to the next iteration of the for loops.
          continue;
        }
      }
    }
  }

  /**
   * Gets the identity of the cell.
   * 
   * @return State
   */
  public State who(){
    return State.EMPTY;
  }

  /**
   * Determines the cell type in the next cycle.
   * 
   * @param tNew: town of the next cycle
   * @return TownCell
   */

 public TownCell next(Town tNew){
    return this;
 }

  // The finalCases method goes through the additional cases for each cell type, and returns the next cell type in the cycle based on the neighboring cells from the previous montly grid.

 public TownCell finalCases(TownCell oldCell, TownCell newCell, Town tNew){
    if(!(oldCell.who() == State.OUTAGE || oldCell.who() == State.RESELLER) && (oldCell.nCensus[EMPTY] + oldCell.nCensus[OUTAGE] <= 1)){
      newCell = new Reseller(tNew, oldCell.row, oldCell.col);
    }else if(oldCell.nCensus[CASUAL] >= 5){
      newCell = new Streamer(tNew, oldCell.row, oldCell.col);
    }
    return newCell;
  }
}

