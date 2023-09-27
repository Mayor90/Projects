/************************
Name: Owolabi Oluwamayowa
Class: CSCI 237
13th September, 2021
*************************/
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Assignment2 {
  public static void main(String[] args) {
    ArrayList<ArrayList<String>> adjList = new ArrayList<ArrayList<String>>();//stores the list as an array

    try {
      FileInputStream file = new FileInputStream("sample.txt");//coverts the data into readable form

      Scanner sc = new Scanner(file);

      while (sc.hasNextLine()) {
        // stores line as string
        String line = sc.nextLine();
        ArrayList<String> temp = new ArrayList<String>();

        String[] arrLine = line.trim().split(";");//splits the data in the list by the semi colon

        for (int i = 0; i < arrLine.length; i++) {
          char node_char;
          if (i == 0) {
            node_char = arrLine[i].trim().charAt(0);//removes all the spaces from the list
            temp.add(Character.toString(node_char));
          }

          node_char = arrLine[i].trim().charAt(2);
          temp.add(Character.toString(node_char));
        }
        
        adjList.add(temp);
      }

      sc.close();
    } catch (Exception ex) {
      System.out.println(ex.toString());
    }

    // print parent node + adjacent nodes separated by comma
    for (int i = 0; i < adjList.size(); i++) {
      String temp = "";
      
      for (int j = 0; j < adjList.get(i).size(); j++){
        if (j == 0){
          temp += adjList.get(i).get(j);
        }
        else{
          temp += "," + adjList.get(i).get(j);
        }
      }

      System.out.println(temp);
    }
  }
}
   
    