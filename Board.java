/*
public class Board {
    private int num_rows;
    private int num_columns;
    private int num_boats;
    private Battleboat[] boats;
    private Cell[][] board;
    private boolean debugMode;
    
 
    // TODO: Assign appropriate number of boats to num_boats variable
    // TODO: Initialize the board as a 2-D Cell array
    // TODO: Initialize boats as a Battleboat array
    // TODO: Place Battleboats appropriately on board and add them to the board's boats

    public Board(int m , int n, boolean debugMode){
        num_rows = m;
        num_columns = n;
        num_boats = 
        this.debugMode = debugMode;
        
    }

    //Obscures a character if the game is not being played in debug mode
    private char debug(boolean debugMode, char c){
        if(debugMode){
            return c;
        }
        else{
            switch(c){
                case 'H':
                    c = 'H';
                    break;
                case 'M':
                    c = 'M';
                    break;
                default:
                    c = ' ';
                    break;
            }
            return c;
        }
    }

    //Prints a Board object in a way that makes sense to the player
    public String toString(){

        String boardString = "\t";
        for (int j = 0; j < num_columns-1; j++){
            boardString += j + " |" + "\t";
        }

        boardString += num_columns-1;

        for(int i = 0; i < num_rows; i++){
            boardString+= "\n" + i + "\t";
            for (int j = 0; j < num_columns; j++){
                boardString += debug(debugMode, board[i][j].get_status()) + "\t";
            }
        }

        boardString += "\n";
        return boardString;
    }

    // TODO: Return a int based on the guess for the cell/its status
    // TODO: Change the statuses of the cell if applicable
    public int guess(int r, int c){
        if (){
            return 0;
            //"Penalty: Out of Bounds";
        }
        else if () {
            return 1;
            //"Miss";
        }
        else if(){
            return 2;
            //"Hit";
        }
        else {
            return 3;
            //"Penalty: Redundant Guess";
        }
    }

    //TODO: write a function that calculates the number of unsunk boats
    public int unsunkBoats(){

    }
}
*/
