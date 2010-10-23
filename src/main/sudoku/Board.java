package sudoku;

public class Board {
    private int[] data;
    private static final int BOARD_DIMENSION = 9;
    private static final int BOARD_SUB_DIMENSION = 3;
    
    public void setUpInitialState(int[] puzzleStartingPoint) {
        if(puzzleStartingPoint.length!=(BOARD_DIMENSION*BOARD_DIMENSION)) throw new IllegalArgumentException(puzzleStartingPoint.length+" data points specified, should be "+(BOARD_DIMENSION*BOARD_DIMENSION));
        for(int i=0;i<puzzleStartingPoint.length;i++){
            if (puzzleStartingPoint[i]<0 || puzzleStartingPoint[i]>BOARD_DIMENSION) throw new IllegalArgumentException("Element "+puzzleStartingPoint[i]+" at "+i+" must be in range 0-9");
        }
        data = puzzleStartingPoint;
    }

    public int[] retrieveState() {
        return data;
    }
    
    public boolean isSound(int boardIndex, int candidateValue) {
        //TODO figure what happens when the candiate value is the same as the exisitng value.
        //Check rows
        for(int k=getStartOfRowIndex(boardIndex);k<getStartOfRowIndex(boardIndex)+BOARD_DIMENSION;k++){
            if (data[k]==candidateValue&&k!=boardIndex) return false;
        }
        //Check columns
        for(int k=boardIndex%9;k<(BOARD_DIMENSION*BOARD_DIMENSION);k+=BOARD_DIMENSION){
            if (data[k]==candidateValue&&k!=boardIndex) return false;
        }
        //check sub group
        int subGroupColumn=(boardIndex/BOARD_SUB_DIMENSION)%BOARD_SUB_DIMENSION;
        int subGroupRow=(boardIndex/(BOARD_DIMENSION*BOARD_SUB_DIMENSION));
        for(int j=subGroupRow*BOARD_SUB_DIMENSION;j<(subGroupRow+1)*BOARD_SUB_DIMENSION;j++){
            for(int i=subGroupColumn*BOARD_SUB_DIMENSION;i<(subGroupColumn+1)*BOARD_SUB_DIMENSION;i++){
                if (data[(j*BOARD_DIMENSION)+i]==candidateValue&&((j*BOARD_DIMENSION)+i)!=boardIndex) return false;
            }
        }
        return true;
    }
    private int getStartOfRowIndex(int boardIndex){
        return (boardIndex/BOARD_DIMENSION)*BOARD_DIMENSION;
    }
    
}
