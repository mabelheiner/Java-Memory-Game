abstract class Level {
  int xy = 4;
  int l = 1;

  //returns the level the current user is on
  public int getLevel() {
    return l;
  }

  //sets the dimensions for the board
  public int setXY(int l){
    xy = 4;
    return xy;
  }

  //returns the dimensions for the board
  public int getXY(){
    return xy;
  }

  //increases the level of the game
  public int upLevel(){
    l++;
    return l;
  }

  //decreases the level of the game
  public int downLevel(){
    l--;
    return l;
  }

  //prints the level onto the board
  public void printLevel(){
    System.out.println("        Level " + l + "   ");
  }
}
