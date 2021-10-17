import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class board extends Level {
    public static String [][] board = new String[4][4];
    public static String [][] cards = new String[4][4];
    public static Scanner scanner = new Scanner(System.in);
    
    //prints the starting board for the level
    public void printFirstBoard(){
      setXY(getLevel());
      for(int i = 0; i<getXY(); i++){
        for(int j = 0; j<getXY(); j++){
          board[i][j] = " _ ";
          }
        }
    }
    
    //prints the current board
    public void printBoard(){
        printLevel();
        for (int i = 0; i < 4; i++){
          System.out.print(" ");
        }
        for (int i = 0; i<getXY(); i++){
          int c = i + 1;
          System.out.print("C" + c + "  ");
        }
        System.out.println("");
        
        for(int i = 0; i<getXY(); i++){
            int r = i+1;
            System.out.print("R" + r + " |");
            for(int j = 0; j<getXY();j++) {
                System.out.print(board[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
    }

    //checks if the user passes the level and starts the next game
    public void playAgain(int guess){
      if (getLevel() == 1 && guess <30) {
        System.out.println("You passed level 1!");
        System.out.println("You need to get all the matches in less than 25 guesses to pass level 2");
        upLevel();
      } else if (getLevel() == 2 && guess < 25) {
        System.out.println("You passed level 2!");
        System.out.println("You need to get all the matches in less than 20 guesses to pass level 3");
        upLevel();
      } else if (getLevel() == 3 && guess < 20) {
        System.out.println("You passed level 3!");
        System.out.println("You need to get all the matches in less than 15 guesses to pass level 4");
        upLevel();
      } else if (getLevel() == 4 && guess < 15) {
        System.out.println("You passed level 4!");
        System.out.println("You need to get all the matches in less than 10 guesses to pass level 5");
        upLevel();
      } else if (getLevel() == 5 && guess < 10) {
        System.out.println("You passed level 5!");
        System.out.println("You won the game!");
        System.exit(1);
      }
      else {
        System.out.println("You got all the matchs! Sadly, you didn't beat the level. Try again!");
      }
        shuffleCards();

        printBoard();
        checkInput();
    }

    //organizes the board
    public void shuffleCards(){
        Random random = new Random();
        ArrayList<String> letters = new ArrayList<String>();

        int num = getXY() * getXY();
        
        for (int k = 0; k<num/2; k++) {
          letters.add(String.valueOf(k));
        }

        for (int n = 0; n<num/2; n++) {
          letters.add(String.valueOf(n));
        }


        int index;
        for(int i = 0; i<getXY(); i++){
            for(int j = 0; j<getXY(); j++){
                index = random.nextInt(letters.size());
                cards[i][j] = letters.get(index);
                letters.remove(index);
            }
        }
    }

    //gets the users input and checks if it's valid
    public void checkInput(){
      int guess = 0;
        while(true){
            if(!gameOver()){
                System.out.println("Row: (1-4)");
                int row1 = scanner.nextInt();

                if(row1 > 4) {
                  System.out.println("It has to be 1-4");
                  System.out.println();
                  printBoard();
                  continue;
                }

                System.out.println("Column: (1-4)");
                int column1 = scanner.nextInt();

                if(column1 > 4) {
                  System.out.println("It has to be 1-4");
                  System.out.println();
                  printBoard();
                  continue;
                  }

                if(!board[row1-1][column1-1].equals(" _ ")) {
                    System.out.println("Already Entered");
                    if (board[row1 - 1][column1 - 1] == " ❃ ")
                    continue;
                    else {
                    board[row1 - 1][column1 - 1] = " _ ";
                    }
                    System.out.println();

                    continue;
                }
                  else{
                    board[row1-1][column1-1] = " " + cards[row1-1][column1-1] + " ";
                    printBoard();
                }

                System.out.println("Row: (1-4)");
                int row2 = scanner.nextInt();

                if(row2 > 4) {
                  System.out.println("It has to be 1-4");
                  System.out.println();
                  printBoard();
                  continue;
                }

                System.out.println("Column: (1-4)");
                int column2 = scanner.nextInt();

                if(column2 > 4) {
                  System.out.println("It has to be 1-4");
                  System.out.println();
                  printBoard();
                  continue;
                }

                if(!board[row2-1][column2-1].equals(" _ ")) {
                    System.out.println("Already Entered");
                    if (board[row1 - 1][column1 - 1] == " ❃ ")
                    continue;
                    else {
                    board[row1 - 1][column1 - 1] = " _ ";
                    }
                    System.out.println();

                    printBoard();
                    continue;
                }else{
                    board[row2-1][column2-1] = " " + cards[row2-1][column2-1] + " ";

                    if (board[row1-1][column1-1].equals(board[row2-1][column2-1])) {
                        printBoard();
                        System.out.println("Correct!");
                        board[row1-1][column1-1] = " ❃ ";
                        board[row2-1][column2-1] = " ❃ ";
                    }else{
                        printBoard();
                        System.out.println("False!!");
                        board[row1-1][column1-1] = " _ ";
                        board[row2-1][column2-1] = " _ ";
                        printBoard();
                    }
                }
                guess++;
            }else {
                guess++;
                printBoard();
                System.out.println("It took you " + guess + " guesses to win!");
                printFirstBoard();
                playAgain(guess);
            }
        }

    } 


    //checks if the game is over
    public boolean gameOver(){
        for(int i = 0; i<getXY(); i++){
            for(int j = 0; j<getXY();j++){
                if(board[i][j].equals(" _ ")){
                    return false;
                }
            }
        }
        return true;
    }   
}
