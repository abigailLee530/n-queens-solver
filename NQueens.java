import java.util.*;

/**
 * A program that solves the N-Queens problem using a backtracking algorithm.
 * 
 * The N-Queens problem involves placing N queens on an N×N chessboard such that
 * no two queens threaten each other. This means no two queens can share the same
 * row, column, or diagonal.
 * 
 * The program prompts the user for the board size (N), generates an empty board,
 * and attempts to place queens column by column. .
 */
public class NQueens{

   /** 2D array representing the chessboard. '.' indicates an empty space and 'Q' indicates a queen. */
   private static char[][] board;

   /** The size of the board (N × N) */
   private static int n;

   /**
    * Prompts the user to enter the board size, initializes the board, and
    * attempts to solve the N-Queens problem, then prints the board configuration. 
    */
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      
      while(n <=0){
         try{
            System.out.print("Enter board size: ");
            n = scan.nextInt();
         }catch(InputMismatchException e){
            System.out.println("Please enter a valid number");
            scan.next();
         }
      }
      
      scan.close();
      board = new char[n][n];
      
      for(int i = 0; i< n; i++){
         Arrays.fill(board[i], '.');
      }

      solve(0);
      printBoard();
   }
   
   /**
    * Prints the current state of the chessboard to the console.
    * Each cell is displayed with a space separator for readability.
    */
   public static void printBoard(){
      for(int row = 0; row < n; row++){
         for(int col = 0; col<n; col++){
            System.out.print(board[row][col]+" ");
         }
         System.out.println();
      }
   }
   
   /**
    * Determines whether a queen can be safely placed at a given position.
    * 
    * This method checks:
    *   The left side of the current row
    *   The upper-left diagonal
    *   The lower-left diagonal
    * 
    * Only these directions need to be checked because queens are placed
    * from left to right one column at a time.
    *
    * @param row the row index where the queen is being considered
    * @param col the column index where the queen is being considered
    * @return true if the position is safe for placing a queen, false otherwise
    */
   public static boolean isSafe(int row, int col){
      for(int x = col-1; x >= 0; x--){
         if(board[row][x] == 'Q'){
            return false;
         }
      }
      for(int x = 1; row - x>= 0 && col -x >= 0; x++){
         if(board[row-x][col-x] == 'Q'){
            return false;
         }
      }
      
      for(int y = 1; row+y <n && col-y >=0; y++){
         if(board[row+y][col-y] == 'Q'){
            return false;
         }
      }
      return true;  
   }
   
   /**
    * Attempts to solve the N-Queens problem using recursion and backtracking.
    * 
    * The algorithm places queens one column at a time. For each column, it
    * tries every row and checks whether placing a queen there is safe. If a
    * safe position is found, the queen is placed and the algorithm proceeds
    * to the next column. If no valid placement leads to a solution, the method
    * backtracks by removing the queen and trying another position.
    *
    * @param col the current column where a queen needs to be placed
    * @return true if a valid arrangement of queens is found, false otherwise
    */
   public static boolean solve(int col){
      if(col == n){
         return true;
      }
      for(int row = 0; row<n; row++){
         if(isSafe(row,col)){
            board[row][col] = 'Q';
            if (solve(col+1)){
               return true;
            }
            board[row][col] = '.';
         }     
      
      }
      return false;
   } 

}