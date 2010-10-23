package sudoku;

import org.jbehave.scenario.Scenario;

import steps.SolveSudokuSteps;

public class CanSolveSudoku extends Scenario{

    public CanSolveSudoku() {
        super(new SolveSudokuSteps());
    }

}