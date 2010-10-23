package sudoku;

public class SquareCandidate {
    private int x,y,value;
    public SquareCandidate(int x, int y, int value){
        this.x=x;
        this.y=y;
        this.value=value;
    }
    protected int getX() {
        return x;
    }
    protected int getY() {
        return y;
    }
    protected int getValue() {
        return value;
    }
    
}
