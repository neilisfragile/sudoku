package sudoku;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoardBehaviour {
    private Board board;
       
    @Before
    public void setUp(){
        board = new Board();
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void shouldCheckInitialInputIsEightyOneValues(){
        board.setUpInitialState(new int[]{1,2,3});
    }
    @Test(expected=IllegalArgumentException.class)
    public void shouldCheckInitialInputGreaterThanZero(){
        int[] localTestData = TestingUtils.getSampleInitialState();
        localTestData[1]=-1;
        board.setUpInitialState(localTestData);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldCheckInitialInputLessThanNine(){
        int[] localTestData = TestingUtils.getSampleInitialState();
        localTestData[0]=10;
        board.setUpInitialState(localTestData);
    }
    //Not sure i need this.
//    @Test
//    public void shouldBeAbleToSetAndRetreiveTheState(){
//        board.setUpInitialState(TestingUtils.sampleInitialState);
//        Assert.assertArrayEquals(TestingUtils.sampleInitialState, board.retrieveState());
//    }
    @Test
    public void shouldBeAbleToDetectInvalidSquareValues(){
        board.setUpInitialState(TestingUtils.getSampleInitialState());
        //test valid examples
        Assert.assertTrue(board.isSound(0, 1));
        Assert.assertTrue(board.isSound(26,8));
        Assert.assertTrue(board.isSound(64,1));
        //already there
        Assert.assertTrue(board.isSound(79,4));
        
        
        //test row
        Assert.assertFalse(board.isSound(36, 8));
        //test column
        Assert.assertFalse(board.isSound(38, 4));
        //test subgroup
        Assert.assertFalse(board.isSound(49, 1));
    }
    
    
}
