package Game;

import java.util.Random;
public class Sudoku {
    /**
     * Класс содеражщий судоку
     */



    private static final int EASY = 1;
    private static final int MEDIUM = 2;
    private static final int HARD = 3;

    private char[][] sudokuBoard;
    private boolean isBoardValid;
    private boolean isSudokuSolved;


    public Sudoku(){
        generateSudoku(new Random().nextInt(EASY,HARD+1));
    }
    public Sudoku(int difficulty){
        if(difficulty>=EASY && difficulty<=HARD){
            generateSudoku(difficulty);
        }else throw new IllegalArgumentException();

    }

    public Sudoku(char[][] board){
        if(board.length != 9){
            throw new IllegalArgumentException();
        }
        for(int i = 0;i<board.length;i++){
            if(board[i].length!=9){
                throw new IllegalArgumentException();
            }
        }
        this.sudokuBoard = board;
        this.isBoardValid = SudokuValidator.isSudokuValid(board);
    }

    public void generateSudoku(int difficulty){

        SudokuGenerator generator = new SudokuGenerator();
        generator.createPuzzle(difficulty);
        sudokuBoard = generator.getSudokuBoard();

    }



    public void generateSolution(){
        int i = 0;
        int j = 0;
        if(SudokuSolver.backtrackingSolution(this.sudokuBoard, i ,j)){
            System.out.println("Решение найдено");
        }else{
            System.out.println("Судоку нерешаемо");
        }

    }

    public boolean isSolutionValid(){
        return true;
    }

    public char[][] getBoard(){
        return this.sudokuBoard;
    }

    public void setBoard(char[][] sudokuBoard){
        this.sudokuBoard = sudokuBoard;
    }

    public boolean isBoardValid(){
        return this.isBoardValid;
    }

    public void printBoard(){
        for(int i = 0;i<this.sudokuBoard.length;i++){
            for(int j = 0;j<this.sudokuBoard.length;j++){
                System.out.print(this.sudokuBoard[i][j]+" ");
            }
            System.out.println();
        }
    }
}
