public class Battleboat {
    private int size;
    private boolean orientation; // false <-> horizontal, true <-> vertical
    private Cell[] spaces;

    // TODO: declare the Cell objects associated with each boat

    public Battleboat(boolean orientation, Cell[] spaces, int size){
        this.orientation = orientation;
        this.spaces = spaces;
        if (size != 0) {
            this.size = size;
        }
        else {this.size = 3;}
    }

    public boolean get_orientation(){
        return orientation;
    }

    public int get_size(){
        return size;
    }

    //ToDo:
    public Cell[] get_spaces(){
        return spaces;
    }
    /*
    public static void main(String[] args) {
        Cell[] loc= {new Cell(1,0,'B'), new Cell(1,1,'B'),
                new Cell(1,3,'B')};
        Battleboat B = new Battleboat(false, loc, 3);
        System.out.println(B.get_size());
        System.out.println(B.get_orientation());
        System.out.println(B.get_spaces());
    }
*/
}
