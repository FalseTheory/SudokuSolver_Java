package Game;

import java.util.Random;

public class SudokuGenerator {

    private final int TRANSPOSE = 0;
    private final int SWAP_ROWS = 1;
    private final int SWAP_COLS = 2;
    private final int SWAP_ROW_REGION = 3;
    private final int SWAP_COL_REGION = 4;
    private char[][] sudokuBoard;

    public SudokuGenerator(){
        this.sudokuBoard = new char[][]{
                {'1', '2', '3', '4', '5', '6', '7', '8', '9'},
                {'4', '5', '6', '7', '8', '9', '1', '2', '3'},
                {'7', '8', '9', '1', '2', '3', '4', '5', '6'},
                {'2', '3', '6', '7', '8', '9', '1', '2', '3'},
                {'5', '6', '7', '8', '9', '1', '2', '3', '4'},
                {'8', '9', '1', '2', '3', '4', '5', '6', '7'},
                {'3', '4', '5', '6', '7', '8', '9', '1', '2'},
                {'6', '7', '8', '9', '1', '2', '3', '4', '5'},
                {'9', '1', '2', '3', '4', '5', '6', '7', '8'}
        };
        int seed = new Random().nextInt(0,100);
        for(int i = 0; i<seed;i++){
            generateRandomLayout();
        }


    }


    private void generateRandomLayout(){
        int operation = new Random().nextInt(0,5);
        switch(operation){
            case(TRANSPOSE):
                transposeBoard();
                break;
            case(SWAP_ROWS):
                swapRegionRow();
                break;
            case(SWAP_COLS):
                swapRegionColumns();
                break;
            case(SWAP_ROW_REGION):
                swapRowsRegions();
                break;
            case(SWAP_COL_REGION):
                swapColumnsRegions();
                break;
        }
    }

    private void transposeBoard(){
        for(int i = 0;i<sudokuBoard.length;i++){
            for(int j = i;j<sudokuBoard.length;j++){
                if(j!=i){
                    char tmp = sudokuBoard[j][i];
                    sudokuBoard[j][i] = sudokuBoard[i][j];
                    sudokuBoard[i][j] = tmp;
                }
            }
        }

    }
    private void swapRegionRow(){
        int region = new Random().nextInt(0,9) / 3;
        boolean up = new Random().nextBoolean();
        if(up){
            char[] tmp = sudokuBoard[region * 3];
            sudokuBoard[region * 3] = sudokuBoard[region * 3 + 1];
            sudokuBoard[region * 3 + 1] = tmp;

        }else{
            char[] tmp = sudokuBoard[region * 3 + 1];
            sudokuBoard[region * 3 + 1] = sudokuBoard[region * 3 + 2];
            sudokuBoard[region * 3 + 2] = tmp;
        }

    }
    private void swapRegionColumns(){
        transposeBoard();
        swapRegionRow();
        transposeBoard();

    }
    private void swapRowsRegions(){
        boolean up = new Random().nextBoolean();
        int start;
        int end;
        if(up){
            start = 0;
            end = 3;
        }else{
            start = 6;
            end = 9;
        }

        for(int i = start, j = 3; i < end; i++,j++){
            char[] tmp = sudokuBoard[j];
            sudokuBoard[j] = sudokuBoard[i];
            sudokuBoard[i] = tmp;
        }

    }
    private void swapColumnsRegions(){
        transposeBoard();
        swapRowsRegions();
        transposeBoard();
    }
    public char[][] getSudokuBoard(){
        return sudokuBoard;
    }
    public void createPuzzle(int difficulty){
        int cellsToFill;
        if (difficulty==3){
            cellsToFill = new Random().nextInt(17,27);
        }else if(difficulty==2){
            cellsToFill = new Random().nextInt(28,31);
        }else{
            cellsToFill = new Random().nextInt(32,38);
        }
    }


}
