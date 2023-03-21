import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
     static ArrayList<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Boolean x = true;
        int choice;
        while (x) {
            displayMenu();
            try{
               choice = input.nextInt();
            }
            catch(Exception e){
              System.out.println("Invalid choice. Please try again.");
              displayMenu();
               choice = input.nextInt();
            }
                switch (choice) {
                    case 1:
                        addTask();
                        break;
                    case 2:
                        removeTask();
                        break;
                    case 3:
                        displayTasks();
                        break;
                    case 4:
                        System.out.println("Exiting program...");
                        x = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
              
              
            
            }
            
        }
    }

    private static void displayMenu() {
        System.out.println("\nTo-Do List Menu");
        System.out.println("1. Add task");
        System.out.println("2. Remove task");
        System.out.println("3. Display tasks");
        System.out.println("4. Exit program");
        System.out.print("Enter your choice: ");
    }

    private static void addTask() {
      
        System.out.print("Enter task to add: ");
        Scanner scan = new Scanner(System.in);
        String task = scan.nextLine();
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    private static void removeTask() {
        displayTasks();
        try{
            if(tasks.isEmpty()) System.out.println("There are no tasks to remove");
            else{
                  System.out.print("Enter the index of the task you want to remove: ");
                  Scanner scan = new Scanner(System.in);
                  int task = scan.nextInt();
                  if (!tasks.isEmpty()) {
                      tasks.remove(task - 1);
                      System.out.println("Task removed successfully!");
                  } 
              
            }
          }
      catch(Exception e ){
        System.out.println("There are no tasks at the given index. Please enter a different index");
        removeTask();
      }
    }

    private static void displayTasks() {
      int count = 1;
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
        } else {
            System.out.println("\nTasks:");
            for (String task : tasks) {
                System.out.println(count + ".\t " + task);
                count++;
            }
        }
    }
}