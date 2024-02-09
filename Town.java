//package edu.iastate.cs228.hw1;
//@author Michael Jones

public class Town {

  TownCell[][] grid;

  public void initializeGrid(String[][] arr2D){
    grid = new TownCell[arr2D.length][arr2D[0].length];
    for(int i = 0; i < arr2D.length; i++){
      for(int j = 0; j < arr2D[i].length; j++){
        grid[i][j] = getTownCell(arr2D[i][j]);
      }
    }
  }

  public TownCell getTownCell(String str){
    if(str.equals("C")){
      Casual c = new Casual();
      return c;
    } else if(str.equals("S")){
      Streamer s = new Streamer();
      return s;
    } else if(str.equals("R")){
      Reseller r = new Reseller();
      return r;
    } else if(str.equals("O")){
      Outage o = new Outage();
      return o;
    } else {
      Empty e = new Empty();
      return e;
    }

  }

}
