package com.csc;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CheeseAnalyzer {

  //class variables/arraylists and initialization of the CheeseCalculator class
  int wordNumber = 0;
  ArrayList<String> cheeseData = new ArrayList<String>();
  CheeseCalculator calculator = new CheeseCalculator(this);

  //method that writes the file output.txt
  public void fileWriter() {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
      writer.write("Number of pasteurized milk cheeses: " + calculator.pasteurized + "\n");
      writer.write("Number of raw milk cheeses: " + calculator.raw + "\n");
      writer.write("Animal with greatest number of cheeses: " + calculator.greatestAnimal + "\n");
      writer.write("Number of cheeses that are both organic and have over 41% moisture: " + calculator.moistyOrganic);
      writer.close();
    }
    catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  //Additional noTopColumn write method, deletes top column then writes rest of csv file
  public void noTopColumn() {
    String line = "";
    try {
      BufferedReader reader = new BufferedReader(new FileReader("cheese_data.csv"));
      int i = 0;
      String print = "";
      while ((line = reader.readLine()) != null) {
        if (i != 0) {
          print = print + line + "\n";
        }
      i++;
      }
      reader.close();
      try {
        BufferedWriter writer = new BufferedWriter(new FileWriter ("output.txt"));
        writer.write(print);
        writer.close();
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

  //Additional noIDs write method, deletes IDs then writes rest of csv file
  public void noIDs() {
    String line = "";
    String completeLine = "";
    String print = "";
    try {
      BufferedReader reader = new BufferedReader(new FileReader("cheese_data.csv"));
      while ((line = reader.readLine()) != null) {
        int i = 0;
        while (i < line.length() && line.charAt(i) != ',') {
          i++;
        }
        i++;
        while (i < line.length()) {
          completeLine = completeLine + line.charAt(i);
          i++;
        }
        print = print + completeLine + "\n";
        completeLine = "";
      }

      reader.close();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter ("output.txt"));
      writer.write(print);
      writer.close();
    }
    catch(IOException e) {
      e.printStackTrace();
    }
  }
  //method that reads in the .csv file and separates each data point
  public void fileReader() {
    String line;
    try {
      BufferedReader reader = new BufferedReader(new FileReader("cheese_data.csv"));
      while ((line = reader.readLine()) != null) {
        wordNumber = 0;
        cheeseData.add(wordNumber, "");
        for (int i = 0; i < line.length() && line.length() != 0; i++) {
          if (line.charAt(i) == '"') {
            i++;
            while (line.charAt(i) != '"') {
              String currentCheese = cheeseData.get(wordNumber);
              cheeseData.set(wordNumber, currentCheese + line.charAt(i));
              i++;
            }
          }
          if (line.charAt(i) != ',') {
            String currentCheese = cheeseData.get(wordNumber);
            cheeseData.set(wordNumber, currentCheese + line.charAt(i));
          }
          else {
            calculator.MilkAnimal();
            calculator.MilkTreatment();
            calculator.MilkMoistOrganic();
            wordNumber = wordNumber + 1;
            cheeseData.add(wordNumber, "");
          }
        }
      }
      reader.close();
    }
    catch (IOException e) {
      e.printStackTrace(); 
    }
  }

  //very minimal main function
public static void main(String[] args) {
  CheeseAnalyzer analyzer = new CheeseAnalyzer();
  analyzer.noIDs();
} 
}


