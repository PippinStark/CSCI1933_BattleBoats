public class Cell {
    private int row;
    private int col;
    private char status; // ' ': Empty, 'B': Boat, 'H': Hit; 'M': Miss

    public char get_status(){
        return status;
    }

    public void set_status(char c){
        status = c;
    }

    public Cell(int row, int col, char status){
        this.row = row;
        this.col = col;
        this.status = status;
    }
    public String toString() {
        return row + "," + col;
    }
/*
    public static void main(String[] args) {
        Cell a = new Cell(1, 2, 'B');
        System.out.println(a.get_status());
        a.set_status('H');
        System.out.println(a.get_status());
    }
*/
}
