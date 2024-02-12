package edu.iastate.cs228.hw1;
//@author Michael Jones

import java.awt.dnd.DragGestureEvent;
import java.io.FileNotFoundException;
import java.util.*;

public class Main{

  public static Town tOld;
  public static Town tNew;
  public static int totalProfit = 0;
  
  public static void main(String[] args){
  
    Scanner s = new Scanner(System.in);
    boolean initialized = false;
    String str;
    int x;

    // This while loop accounts for potential imputMismatchExceptions by using a boolean operator to check if the user inputted either a 1 or 2. 
    
    while(initialized == false){
      System.out.println("How to populate grid (type 1 or 2): 1: from file text. 2: randomly with seed");
      x = s.nextInt();
      if(x == 1) { // initializes the grid based off text from a file, and catches any FileNotFoundExceptions thrown by the file.
        try{
          System.out.println("Please enter file text.");
          s.nextLine();
          str = s.nextLine();
          tOld = new Town(str); // Calls a constructor in Town class to generate grid
          initialized = true;
        } catch (FileNotFoundException e) {
          System.out.println("File not found, please try again.");
        }
      } else if(x == 2) { // initializes the grid randomly
        s.nextLine();
        while (initialized == false) { // This while loop catches any inputMismatchExceptions thrown by the user when entering their parameters.
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
      
      System.out.println("\n"+tOld+"\nProfit: $"+getProfit(tOld));
      billingCycle();
      
  }

  // Computes the monthly profit of the ISPBuisness and adds it on to the total profit

  public static int getProfit(Town t){
    int totalMonthlyProfit = 0;
    for(int i = 0; i < t.getLength(); i++){
      for(int j = 0; j < t.getWidth(); j++){
        if(t.grid[i][j].toString().equals("C")){
          totalMonthlyProfit++;
        }
      }
    }
    totalProfit += totalMonthlyProfit;
    return totalMonthlyProfit;
  }

  // Computes the final profit of the ISPBuisness as a percentage rounded to two decimal places
  
  public static double finalProfit(){
    double d = (double) Math.round((10000*totalProfit) / (tOld.getLength()*tOld.getWidth()*12))/100;
    return d;
  }

  // returns the state of the town in the next month.
  
  public static Town nextMonth(Town t){ 
    tNew = new Town(t.getLength(), t.getWidth());
    for(int i = 0; i < t.getLength(); i++){
      for(int j = 0; j < t.getWidth(); j++){
        tNew.setCell(i, j, t);
      }
    } 
    return tNew;
  } 

  // Simulates the billing cycle of the ISPBuisness over a twelve month period, and prints the town states and the montly profits
  
  public static void billingCycle(){
    for(int i = 0; i < 12; i++){
      tOld = nextMonth(tOld);
      System.out.println("\n"+tOld+"\nProfit: $"+getProfit(tOld));
    }
    System.out.println("\n"+finalProfit() + "%");
  }
}
