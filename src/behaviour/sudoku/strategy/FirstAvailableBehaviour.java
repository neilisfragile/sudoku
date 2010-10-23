package sudoku.strategy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sudoku.Board;
import sudoku.TestingUtils;

public class FirstAvailableBehaviour {
    private Strategy firstAvailable;

    @Before
    public void onSetup(){
        firstAvailable = new FirstAvailable();
    }
   @Test
    public void shouldSolvePuzzle(){
        //TODO mock board?
        Board board = new Board();
        board.setUpInitialState(TestingUtils.getSampleInitialState());
        
        firstAvailable.solve(board);
        Assert.assertArrayEquals(TestingUtils.getSampleFinalState(),board.retrieveState());
    }
}
