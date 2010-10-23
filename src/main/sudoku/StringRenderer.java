package sudoku;

public class StringRenderer implements GameObserver{
    Board board;
    public void boardChanged(Board board) {
        // TODO Auto-generated method stub        
    }
    @Override
    public String toString(){
        return board.toString();
    }

}
