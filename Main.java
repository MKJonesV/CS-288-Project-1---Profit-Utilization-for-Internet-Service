//package edu.iastate.cs228.hw1;
import java.util.*;
//@author Michael Jones

public class Main{
  public static void main(String[] args){
  
    Scanner s = new Scanner(System.in);
    ISPBuisness buisness = new ISPBuisness();
    boolean initialized = false;
    String str;
    int i;
  
    while(initialized == false){
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
            buisness.generateGrid(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
            initialized = true;
          } else {
            System.out.println("Invalid input, please try again");
          }
        }
      } else {
        System.out.println("Invalid input, please try again.");
      }
    }
    System.out.println();
    buisness.showTown();
  }
}
