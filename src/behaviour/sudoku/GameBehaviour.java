package sudoku;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import sudoku.strategy.Strategy;
@RunWith(JMock.class)
public class GameBehaviour {
    private Mockery context = new Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};
    
    Game game;
        
    @Before
    public void createNewGame(){
        game = new Game();
    }
    
    
    @Test
    public void shouldInstigateSolvingPuzzle (){
        
        final Strategy strategy = context.mock(Strategy.class);
        final Board board = context.mock(Board.class);
        context.checking(new Expectations() {
            {
                allowing(board).setUpInitialState(TestingUtils.getSampleInitialState());
                exactly(1).of(strategy).solve(board);
                exactly(1).of(board).retrieveState(); will(returnValue(TestingUtils.getSampleFinalState()));
            }
        });
        game.setUpInitialState(TestingUtils.getSampleInitialState(),board);
        game.setStrategy(strategy);
        
        game.solve();
        Assert.assertArrayEquals(TestingUtils.getSampleFinalState(), game.getSolution());
        
    }
    @Test
    public void shouldConvertAndReconvertStringRepresentation(){
    	String initialExternalState = "-------------------"+Game.lineSeparator+
"|0,8,2|3,0,5|6,7,0|"+Game.lineSeparator+
"|7,0,5|0,9,0|0,0,2|"+Game.lineSeparator+
"|6,0,3|2,0,0|5,0,0|"+Game.lineSeparator+
"-------------------"+Game.lineSeparator+
"|0,3,0|0,0,2|0,5,0|"+Game.lineSeparator+
"|0,0,8|0,0,0|4,0,0|"+Game.lineSeparator+
"|0,2,0|1,0,0|0,8,0|"+Game.lineSeparator+
"-------------------"+Game.lineSeparator+
"|0,0,4|0,0,1|2,0,3|"+Game.lineSeparator+
"|2,0,0|0,8,0|7,0,5|"+Game.lineSeparator+
"|0,6,7|5,0,9|1,4,0|"+Game.lineSeparator+
"-------------------";
    	int[] internalGameState = Game.convertToInternal(initialExternalState);
    	String finalExternalGameState = Game.convertToExternal(internalGameState);
    	
//    	char[] finalExternalGameStateCA = finalExternalGameState.toCharArray();
//    	char[] initialExternalStateCA = initialExternalState.toCharArray();
//    	for(int i=0;i<initialExternalState.length();i++){
//    		System.out.println(finalExternalGameStateCA[i]+" vs "+initialExternalStateCA[i]);
//    		if(finalExternalGameStateCA[i]!=+initialExternalStateCA[i]){
//    			System.out.println("do not match i is "+i);
//    		}
//    	}
    	Assert.assertEquals(initialExternalState,finalExternalGameState);
    }
    
}
