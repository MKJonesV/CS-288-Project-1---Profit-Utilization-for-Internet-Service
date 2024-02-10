//package edu.iastate.cs228.hw1;
//@author Michael Jones

public class Town {

  TownCell[][] grid;
  String[][] arr2D;

  public Town(String inputFileName) // throws FileNotFoundException 
  {
    String str = "";
    String[] arr = str.split("\n");
    String[] nums = arr[0].split(" ");
    arr2D = new String[Integer.parseInt(nums[0])][Integer.parseInt(nums[1])];
    for(int i = 0; i < arr2D.length; i++){
      String rowVals = arr[i+1];
      for(int j = 0; j < arr2D[i].length; j++){
        arr2D[i][j] = rowVals.substring(j, j+1);
      }
    }
    generateGrid(arr2D);
  }

  public Town(int l, int w){
    grid = new TownCell[l][w];
  }
// generates grid based off of text from main

  public void generateGrid(String[][] arr){ // takes the String array arr2D and converts it to a TownCell array based off of the values in arr2D
    arr2D = arr;
    grid = new TownCell[arr2D.length][arr2D[0].length];
    for(int i = 0; i < arr2D.length; i++){
      for(int j = 0; j < arr2D[i].length; j++){
        grid[i][j] = makeTownCell(arr2D[i][j], i, j, this);
      }
    }
  }

  public TownCell makeTownCell(int i, int x, int y, Town t){
    if(i == 0){
      Casual c = new Casual(t, x, y);
      return c;
    } else if(i == 1){
      Streamer s = new Streamer(t, x, y);
      return s;
    } else if(i == 2){
      Reseller r = new Reseller(t, x, y);
      return r;
    } else if(i == 4){
      Outage o = new Outage(t, x, y);
      return o;
    } else {
      Empty e = new Empty(t, x, y);
      return e;
    }
  }
  
  public TownCell makeTownCell(String str, int x, int y, Town t){
    if(str.equals("C")){
      Casual c = new Casual(t, x, y);
      return c;
    } else if(str.equals("S")){
      Streamer s = new Streamer(t, x, y);
      return s;
    } else if(str.equals("R")){
      Reseller r = new Reseller(t, x, y);
      return r;
    } else if(str.equals("O")){
      Outage o = new Outage(t, x, y);
      return o;
    } else {
      Empty e = new Empty(t, x, y);
      return e;
    }
  }

  public int getLength(){
    return grid.length;
  }
  public int getWidth(){
    return grid[0].length;
  }

  public String toString() {
    String s = "";
      for(int i = 0; i < this.getLength(); i++){
        for(int j = 0; j < this.getWidth(); j++){
          s += (grid[i][j]+" ");
        }
        s += "\n";
      }
    return s;
  }

}
