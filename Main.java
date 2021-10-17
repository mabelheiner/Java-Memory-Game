import java.util.Scanner;

class Main {
  
  public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
      
        //creates a board and sets the level;

        board myBoard = new board();
        myBoard.getLevel();
        
        while(true){
            System.out.println("Press n for new game, q to quit");
            String nq = scanner.nextLine();
            if(nq.equals("q")){
                System.out.println("Exiting...");
                break;
            }else if(nq.equals("n")){
                System.out.println("You need to get all the matches within 30 guesses to beat level 1. Good Luck!");
                myBoard.shuffleCards();
                myBoard.printFirstBoard();

                myBoard.printBoard();
                myBoard.checkInput();

            }else{
                System.out.println("Invalid character");
                continue;
            }
        }

    }
}
