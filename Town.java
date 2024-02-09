package edu.iastate.cs228.hw1;
// @author Michael Jones

public class Town {
  
  TownCell[][] grid;

  public void initializeGrid(String[][] arr2D){
    grid = new TownCell[arr2D.length][arr2D[0].length]();
    for(int i = 0; i < arr2D.length; i++){
      for(int j = 0; j < arr2D[i].length; j++){
        
      }
    }
  }

  public TownCell getTownCell(String str){
    if(str.equals("C")){
      return TownCell c = new Casual();
    } else if(str.equals("S")){
      return TownCell s = new Streamer();
    } else if(str.equals("R")){
      return TownCell r = new Reseller();
    } else if(str.equals("O")){
      return TownCell o = new Outage();
    } else {
      return TownCell e = new Empty();
    }
      
  }
  
}
