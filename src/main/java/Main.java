import Game.Sudoku;
import Game.SudokuGenerator;
import Game.SudokuSolver;
import Game.SudokuValidator;

public class Main {
    public static void main(String[] args){
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        Sudoku sudoku = new Sudoku(board);
        SudokuGenerator generator = new SudokuGenerator();
        sudoku.setBoard(generator.getSudokuBoard());
        sudoku.printBoard();


    }
}

