// $Id$
// Copyright 2009 MX Telecom Ltd
package steps;

import org.jbehave.Ensure;
import org.jbehave.scenario.annotations.Given;
import org.jbehave.scenario.annotations.Then;
import org.jbehave.scenario.annotations.When;
import org.jbehave.scenario.steps.Steps;

import sudoku.Board;
import sudoku.Game;
import sudoku.strategy.FirstAvailable;


public class SolveSudokuSteps extends Steps {
    Game game;
    
    @Given("a new game")
    public void resetBoard(){
        game = new Game();
        game.setStrategy(new FirstAvailable());
    }
    
    @When("the board starts with $puzzleStartingPoint")
    public void solve(String puzzleStartingPoint){
        game.setUpInitialState(Game.convertToInternal(puzzleStartingPoint),new Board());
        
    }
    
    @Then("the solution will be $solution")
    public void getSolution(String solution){
        game.solve();
        String solvedSolution = Game.convertToExternal(game.getSolution());    
//        char[] solvedSolutionCA = solvedSolution.toCharArray();
//    	char[] solutionCA = solution.toCharArray();
//    	for(int i=0;i<Math.max(solution.length(),solvedSolution.length());i++){
//    		System.out.println(solvedSolutionCA[i]+" vs "+solutionCA[i]);
//    		if(solvedSolutionCA[i]!=+solutionCA[i]){
//    			System.out.println("do not match i is "+i);
//    		}
//    	}
        Ensure.ensureThat(solvedSolution.equals(solution));
    }

}
