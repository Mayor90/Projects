 /************************
Name: Owolabi Oluwamayowa
Class: CSCI 237
27th August, 2021
*************************/

     import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class palindrome {
  public static void main(String[] args) {
  
   String pali = "iTopiNonAvevanoNipoti";
  
   
     
   char [] ch = pali.replaceAll(" ","").toLowerCase().toCharArray();
   int flag = 0;
   
   for (int i = 0; i < ch.length/2; i++)
   {
      if (ch[i] != ch[ch.length - 1 - i])
      {
         flag = 1;
         break;
      }
   }
   if (flag == 1) 
   {
      System.out.println (pali + " is not a palindrome.");
   }
   else 
   {
      System.out.println (pali + " is a palindrome.");
   }
     }
}
    
       
    
    
   
    