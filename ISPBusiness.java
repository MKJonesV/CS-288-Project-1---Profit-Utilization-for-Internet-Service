//package edu.iastate.cs228.hw1;
import java.util.*;
// @author Michael Jones

public class ISPBuisness {

  private Town t = new Town();
  private String[][] arr2D;
  private Random r = new Random();

  public void generateGrid(String str){ // generates grid based off of text from main
    String[] arr = str.split("\n");
    String[] nums = arr[0].split(" ");
    arr2D = new String[Integer.parseInt(nums[0])][Integer.parseInt(nums[1])];
    for(int i = 0; i < arr2D.length; i++){
      String rowVals = arr[i+1];
      for(int j = 0; j < arr2D[i].length; j++){
        arr2D[i][j] = rowVals.substring(j, j+1);
      }
    }
  }

  public void generateGrid(int n, int m, int seed){ // generates grid randomly based off of input values from main
    arr2D = new String[n][m];
    for(int i = 0; i < arr2D.length; i++){
      for(int j = 0; j < arr2D[i].length; j++){
        arr2D[i][j] = randomUser(r.nextInt(5));
      }
    }
  }

  public String randomUser(int i){
    if(i == 0){
      return "C";
    } else if(i == 1){
      return "S";
    } else if(i == 2){
      return "R";
    } else if(i == 3){
      return "O";
    } else {
      return "E";
    }
  }

  public void showTown(){
    for(int i = 0; i < arr2D.length; i++){
      for(int j = 0; j < arr2D[i].length; j++){
        System.out.print(arr2D[i][j]+" ");
      }
      System.out.println();
    }
  }

  public int getProfitPercentage(){
    double potentialProfit = arr2D.length * arr2D[0].length;
    double totalProfit = 0.0;
    for(int i = 0; i < arr2D.length; i++){
      for(int j = 0; j < arr2D.length; j++){
        if(arr2D[i][j].equals("C")){
          totalProfit++;
        }
      }
    }
    return (int) (100*(totalProfit / potentialProfit));
  }
}

