package Game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

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


    public Sudoku() {
        generateSudoku(new Random().nextInt(EASY, HARD + 1));
    }

    public Sudoku(int difficulty) {
        if (difficulty >= EASY && difficulty <= HARD) {
            generateSudoku(difficulty);
        } else throw new IllegalArgumentException();

    }

    public Sudoku(String path) throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(path)));
        char[][] board = new char[9][9];
        while(sc.hasNextLine()) {
            for(int i = 0;i<board.length;i++) {
                String[] line = sc.nextLine().trim().split("");
                for(int j = 0; j<line.length;j++) {
                    board[i][j] = line[j].charAt(0);
                }
            }
        }
        this.sudokuBoard = board;
        this.isBoardValid = SudokuValidator.isSudokuValid(board);
    }

    public Sudoku(char[][] board) {
        if (board.length != 9) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i].length != 9) {
                throw new IllegalArgumentException();
            }
        }
        this.sudokuBoard = board;
        this.isBoardValid = SudokuValidator.isSudokuValid(board);
    }

    public void generateSudoku(int difficulty) {

        SudokuGenerator generator = new SudokuGenerator(difficulty);

        sudokuBoard = generator.getSudokuBoard();

    }


    public void generateSolution() {
        int i = 0;
        int j = 0;
        if (SudokuSolver.backtrackingSolution(this.sudokuBoard, i, j)) {
            System.out.println("Решение найдено");
        } else {
            System.out.println("Судоку нерешаемо");
        }

    }

    public boolean isSolutionValid() {
        return true;
    }

    public char[][] getBoard() {
        return this.sudokuBoard;
    }

    public void setBoard(char[][] sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public boolean isBoardValid() {
        return this.isBoardValid;
    }

    public void printBoard() {
        for (int i = 0; i < this.sudokuBoard.length; i++) {
            for (int j = 0; j < this.sudokuBoard.length; j++) {
                System.out.print(this.sudokuBoard[i][j] + " ");
            }
            System.out.println();
        }
    }
}
