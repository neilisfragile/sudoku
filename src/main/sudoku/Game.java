package sudoku;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sudoku.strategy.Strategy;

public class Game {
    private GameObserver observer;
    private Board board;
    private Strategy strategy;
    public static String lineSeparator = System.getProperty ( "line.separator" );


    public void setUpInitialState(int[] puzzleStartingPoint, Board board) {
        this.board = board;
        board.setUpInitialState(puzzleStartingPoint);
        
    }

    public void solve() {
        strategy.solve(board);
        
    }

    public void setObserver(GameObserver observer) {
        this.observer = observer;
        notifyObserver();
    }
    
    private void notifyObserver(){
        observer.boardChanged(board);
    }
    
    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public int[] getSolution() {
        return board.retrieveState();
    }

	public static int[] convertToInternal(String initialExternalState) {
				int[] output = new int[81];
		String getNumbers = "\\d"; 
	     // Compile and get a reference to a Pattern object. 
	     Pattern pattern = Pattern.compile(getNumbers); 
	     // Get a matcher object - we cover this next. 
	     Matcher matcher = pattern.matcher(initialExternalState);
	     
	     for(int i=0;matcher.find() == true;i++){
			output[i] = Integer.parseInt(matcher.group());
		}
		return output;
	}

	public static String convertToExternal(int[] internalGameState) {
		
		String lineSeparator = System.getProperty ( "line.separator" );
		String line ="-------------------";
		StringBuffer outputBuilder = new StringBuffer();
		for(int i=0;i<9;i++){
			if(i%3==0) outputBuilder.append(line+lineSeparator);
			for(int j=0;j<9;j++){
				if(j%3==0) outputBuilder.append("|");
				outputBuilder.append(internalGameState[(i*9)+j]);
				if(j%3!=2)outputBuilder.append(",");
			}
			outputBuilder.append("|"+lineSeparator);
		}
		outputBuilder.append(line);
		return outputBuilder.toString();
	}
	
}
