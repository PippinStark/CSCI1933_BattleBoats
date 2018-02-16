
public class Board {
    private int num_rows, num_columns, num_boats;
    private Battleboat[] boats;
    private Cell[][] board = Cell[num_rows][num_columns];
    private boolean debugMode;
    
 
    // TODO: Assign appropriate number of boats to num_boats variable
    // TODO: Initialize the board as a 2-D Cell array
    // TODO: Initialize boats as a Battleboat array
    // TODO: Place Battleboats appropriately on board and add them to the board's boats

    public Board(int m , int n, boolean debugMode){
        num_rows = m;
        num_columns = n;
        this.debugMode = debugMode;
        if((m > 9 && m <= 12) || (n > 9 && n <= 12)) {num_boats = 6;}
        if ((m > 7 && m <= 9) || (n > 5 && n <= 9)) {num_boats = 4;}
        if ((m > 5 && m <= 7) || (n > 5 && n <= 7)) {num_boats = 3;}
        if((m > 3 && m <= 5) || (n > 3 && n <= 5)) {num_boats = 2;}
        if(m == 3 || n == 3) {num_boats = 1;}
        for(int i = 0; i < num_boats; i++) {
            boolean orientation;
            double a = Math.floor(Math.random()*2);
            if (a == 0) {orientation = false;}
            else {orientation = true;}
            if (orientation == false) {
                double b = Math.floor(Math.random())*m;
                double c = Math.floor(Math.random() * (n-3));
                int y = (int) b;
                int x = (int) c;
                Cell origin = new Cell(y, x, 'B');
            }
        }



        
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
        if (r > num_rows || c > num_columns){
            return 0;
            //"Penalty: Out of Bounds";
        }
        else if (Cell.get_status() == 'B') {
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



