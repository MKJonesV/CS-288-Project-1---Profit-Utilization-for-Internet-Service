//package edu.iastate.cs228.hw1;
import java.awt.dnd.DragGestureEvent;
import java.io.FileNotFoundException;
import java.util.*;
//@author Michael Jones

public class Main{

  public static Town tOld;
  
  public static void main(String[] args){
  
    Scanner s = new Scanner(System.in);
    boolean initialized = false;
    String str;
    int profit = 0;
    int x;
  
    while(initialized == false){
      System.out.println("How to populate grid (type 1 or 2): 1: from file text. 2: randomly with seed");
      x = s.nextInt();
      if(x == 1) { // initializes the grid based off text from a file
        System.out.println("Please enter file text.");
        s.nextLine();
        str = s.nextLine();
        tOld = new Town(str); // Calls a constructor in Town class to generate grid
        initialized = true;
      } else if(x == 2) { // initializes the grid randomly
        s.nextLine();
        while (initialized == false) {
          System.out.println("Provide the desired number of rows, columns, and the seed integer separated by spaces:");
          str = s.nextLine();
          String[] arr = str.split(" ");
          if(arr.length == 3) {
            // generates grid randomly based off of input values from main
              Random r = new Random();
              tOld = new Town(Integer.parseInt(arr[0]), Integer.parseInt(arr[1])); // Calls a constructor in Town class to generate a grid of TownCells with the proper dimensions
              for(int i = 0; i < tOld.getLength(); i++){
                for(int j = 0; j < tOld.getWidth(); j++){
                  tOld.grid[i][j] = tOld.makeTownCell(r.nextInt(5), i, j, tOld);
                }
              } 
              initialized = true;
            } else {
              System.out.println("Invalid input, please try again");
            }
          }
        } else {
          System.out.println("Invalid input, please try again. Hit Enter to retry");
          s.nextInt();
        }
      }
      System.out.println(tOld);
  }

  public static int getProfit(Town t){
    int totalProfit = 0;
    for(int i = 0; i < t.getLength(); i++){
      for(int j = 0; j < t.getWidth(); j++){
        if(t.grid[i][j].toString().equals("C")){
          totalProfit++;
        }
      }
    }
    return totalProfit;
  }

  public static double finalProfit(int p){
    double d = (double) p / (tOld.getLength()*tOld.getWidth()*12);
    return d;
  }
}
