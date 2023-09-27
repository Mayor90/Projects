 /************************
Name: Owolabi Oluwamayowa
Class: CSCI 237
27th August, 2021
*************************/

     import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class readdata {
  public static void main(String[] args) {
    ArrayList<Integer> numList = new ArrayList<Integer>();//creates array list to store integers

    try {
      FileInputStream file = new FileInputStream("sample.txt");//coverts the data into readable form
      Scanner sc = new Scanner(file);

      while (sc.hasNextLine()) {
          // stores the data as string
          String line = sc.nextLine();

          // splits data to individual numbers as strings
          String[] arrLine = line.split(" ");

          // loop through line string array and converts each number from string to integer
          // add int to arraylist
          
          for (int i = 0; i < arrLine.length; i++) {
           
            String numString = arrLine[i];
            int number = Integer.parseInt(numString);
            numList.add(number);
          }
      }

      sc.close();//closes the scanner
    } catch (FileNotFoundException ex) {
        System.out.println(ex.toString());
    }

    
    for (int num : numList) { 
      System.out.println(num);//prints the array
    }
  }
}
    
       
    
    
   
    