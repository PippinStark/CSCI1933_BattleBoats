public class Battleboat {
    private int size;
    private boolean orientation; // false <-> horizontal, true <-> vertical
    private Cell[] spaces;
    private boolean sunk = false;


    public Battleboat(boolean orientation, Cell[] spaces, int size){
        this.orientation = orientation;
        this.spaces = spaces;
        if (size != 0) {
            this.size = size;
        }
        else {this.size = 3;}
        for(int i = 0; i < this.size; i++) {
            spaces[i].set_status('B');
        }
    }

    public boolean get_orientation(){
        return orientation;
    }

    public int get_size(){
        return size;
    }

    public Cell[] get_spaces(){
        return spaces;
    }
    public boolean is_sunk(){
        if(sunk == true) {return sunk;}
        else {
            int sunk_parts = 0; //added because it would declare boats sunk after one hit
            for (int i = 0; i < size; i++) {
                if (spaces[i].get_status() == 'H') {
                    sunk_parts ++;
                }
            }
            if(sunk_parts == 3) {sunk = true;}
            return sunk;
        }
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
