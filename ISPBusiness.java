import java.util.*;
package edu.iastate.cs228.hw1;
// @author Michael Jones

public class ISPBuisness {

  Town t = new Town();
  private String[][] arr2D;
  Random r = new Random();
  
  public void generateGrid(String str){ // generates grid based off of text from main
    String[] arr = str.split("\n");
    String[] nums = arr[0].split(" ");
    arr2D = new String[nums[0]][nums[1]];
    for(int i = 0, i < arr2D.length, i++){
      String rowVals = arr[i+1];
      for(int j = 0, j < arr2D[i].length, j++){
        arr2D[i][j] = rowVals.substring(j, j+1);
      }
    }
  }

  public void generateGrid(int n, int m, int seed){ // generates grid randomly based off of input values from main
    arr2D = new String[n][m];
    for(int i = 0, i < arr2D.length, i++){
      for(int j = 0, j < arr2D[i].length, j++){
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
      return "E"
    }
  }

  public void showTown(){
    for(int i = 0, i < arr2D.length, i++){
      for(int j = 0, j < arr2D[i].length, j++){
        System.out.print(arr2D[i][j]+" ");
      }
      System.out.println();
    }
  }
  
}

public static void main(String[] args){
  
  Scanner s = new Scanner(System.in);
  ISPBuisness buisness = new ISPBuisness();
  boolean intialized = false;
  String str;
  int i;
  
  while(initialized == false);
    System.out.println("How to populate grid (type 1 or 2): 1: from file text. 2: randomly with seed");
    i = s.nextInt();
    if(i == 1) { // initializes the grid based off text from a file
      System.out.println("Please enter file text.");
      s.nextLine();
      str = s.nextLine();
      buisness.generateGrid(str);
      initialized = true;
    } else if(i == 2) { // initializes the grid randomly
      s.nextLine();
      while (initialized == false) {
        System.out.println("Provide the desired number of rows, columns, and the seed integer separated by spaces:");
        str = s.nextLine();
        String[] arr = str.split(" ");
        if(arr.length == 3) {
          buisness.generateGrid(arr[0], arr[1], arr[2]);
          initialized = true;
        } else {
          System.out.println("Invalid input, please try again");
        }
    } else {
      System.out.println("Invalid input, please try again.");
    }
  }
}
