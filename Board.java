public class Board {
    private int num_rows, num_columns, num_boats;
    private Battleboat[] boats;
    private Cell[][] board; // row, then column
    private boolean debugMode;


    public Board(int m , int n, boolean debugMode){
        num_rows = m;
        num_columns = n;
        board = new Cell[num_rows][num_columns];
        this.debugMode = debugMode;
        if((m > 9 && m <= 12) || (n > 9 && n <= 12)) {num_boats = 6;}
        if ((m > 7 && m <= 9) || (n > 5 && n <= 9)) {num_boats = 4;}
        if ((m > 5 && m <= 7) || (n > 5 && n <= 7)) {num_boats = 3;}
        if((m > 3 && m <= 5) || (n > 3 && n <= 5)) {num_boats = 2;}
        if(m == 3 || n == 3) {num_boats = 1;}
        for(int r = 0; r < num_rows; r++) {
            for(int c = 0; c < num_columns; c++) {
                board[r][c] = new Cell(r, c, ' ');
            }
        }
        boats = new Battleboat[num_boats];
        int counter = 0;
        while(counter < num_boats) {
            boolean orientation;
            double a = Math.floor(Math.random()*2);
            if (a == 0) {orientation = false;}
            else {orientation = true;}
            if (orientation == false) { // horizontal
                double b = Math.floor(Math.random()*(m-3));
                double c = Math.floor(Math.random() * (n));
                int y = (int) b; //column
                int x = (int) c; // row
                if((board[x][y].get_status() == ' ') && (board[x][y+1].get_status() == ' ') && (board[x][y+2].get_status() == ' ')) {
                    Cell[] boat = {board[x][y], board[x][y+1], board[x][y+2]};
                    boats[counter] = new Battleboat(false, boat, 3);
                    counter ++;
                }
            }
            if (orientation == true) { // vertical
                double b = Math.floor(Math.random())*(m);
                double c = Math.floor(Math.random() * (n-3));
                int y = (int) b; //column
                int x = (int) c; // row
                if((board[x][y].get_status() == ' ') && (board[x+1][y].get_status() == ' ') && (board[x+2][y].get_status() == ' ')) {
                    Cell[] boat = {board[x][y], board[x+1][y], board[x+2][y]};
                    boats[counter] = new Battleboat(false, boat, 3);
                    counter ++;
                }
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

    public int guess(int r, int c){
        if (r > num_rows || c > num_columns){
            return 0;
            //"Penalty: Out of Bounds";
        }
        else if (board[r][c].get_status() == ' ') {
            board[r][c].set_status('M');
            return 1;
            //"Miss";
        }
        else if(board[r][c].get_status() == 'B'){
            board[r][c].set_status('H');
            return 2;
            //"Hit";
        }
        else {
            return 3;
            //"Penalty: Redundant Guess";
        }
    }

    public int unsunkBoats(){
        int num_sunk_boats = 0;
        for(int i = 0; i < num_boats; i++) {
            if(boats[i].is_sunk() == true) {
                    num_sunk_boats ++;
            }
        }
        return (num_boats - num_sunk_boats);
    }
/*
    //tester for the RNG effect
    public static void main(String[] args) {
        for(int m = 0; m < 12; m++) {
            double b =Math.floor(m);
            System.out.println(b);
        }
    }
*/
}
