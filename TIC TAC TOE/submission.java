
//The algorithm assumes that x is player 1 always. The algorithm starts with O's turn to play
import java.util.*;

class submission {
  public static void main(String[] args) {
    String[][] board = new String[3][3];
    // int count = 0;

    // create the board. the board contains an already begun game with the exception
    // of two final moves
    /*
     * This is the board that would be used
     * 
     * X O X
     * O X O
     * O _ _
     * 
     * The algorithm plays in one of the open positions and checks if it is a
     * winning position for the letter added.
     */
    Boolean x = true;
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 3; j++) {
        if (x) {
          board[i][j] = "X";
          x = false;
        } else {
          board[i][j] = "O";
          x = true;
        }

      }
    }
    board[2][0] = "O";

    // The arraylist contains a list of unfilled positions on the board. When a
    // position is filled, the arraylist removes that position.
    List<String> unfilled = new ArrayList<>();
    unfilled.add("21");
    unfilled.add("22");

    // start the game and print the winner and the filled grid
    String winner = play(board, 0, unfilled);
    if (winner == "X" || winner == "O") {
      System.out.println("The winner is " + winner + "!");
    } else
      System.out.println("There is no winner this time. Stalemate!");
    System.out.println();

    // run completion algorithm
    // if not complete
    // use recursion, base case is complete game. if game does not end, keep playing
    // check for each of the 8 possible winning methods after each play. if the game
    // ends return the winner.
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i][j] == null)
          System.out.print("  _  ");
        else
          System.out.print("  " + board[i][j] + "  ");
      }
      System.out.println();
    }
  }

  public static String play(String[][] board, int turn, List<String> unfilled) {

    if (hCheck(board) != null)
      return hCheck(board);
    if (vCheck(board) != null)
      return vCheck(board);
    if (fdCheck(board) != null)
      return fdCheck(board);
    if (bdCheck(board) != null)
      return bdCheck(board);
    if (isFull(board))
      return null;

    Random random = new Random();
    int m = 2 - turn;
    int index = random.nextInt(m);
    String position = unfilled.get(index);

    int x = position.charAt(0) - '0';
    int y = position.charAt(1) - '0';

    if (turn % 2 == 0) {
      board[x][y] = "X";
    } else if (turn % 2 == 1) {
      board[x][y] = "O";
    }
    unfilled.remove(x + "" + y);
    return play(board, turn + 1, unfilled);
  }

  public static String hCheck(String[][] board) {
    for (int i = 0; i < board.length; i++) {
      if ((board[i][0] == board[i][1]) && (board[i][1] == board[i][2])) {
        return board[i][0];
      }
    }
    return null;
  }

  public static String vCheck(String[][] board) {
    for (int i = 0; i < board.length; i++) {
      if ((board[0][i] == board[1][i]) && (board[1][i] == board[2][i])) {
        return board[0][i];
      }
    }
    return null;
  }

  public static String fdCheck(String[][] board) {
    if (board[0][0] == board[1][1] && board[1][1] == board[2][2])
      return board[0][0];
    return null;
  }

  public static String bdCheck(String[][] board) {
    if ((board[0][2] == board[1][1]) && (board[1][1] == board[2][0])) {
      return board[2][0];
    }
    return null;
  }

  public static Boolean isFull(String[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == null)
          return false;
      }
    }
    return true;
  }
}