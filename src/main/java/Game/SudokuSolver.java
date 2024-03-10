package Game;


import java.util.ArrayList;
import java.util.HashSet;


public class SudokuSolver {


    /**
     * Решает даннную доску методом поиска с возвратом
     * @param board доска которую нужно решить
     * @return нужно ли заканчивать решение в данном ветвлении
     */
    public static boolean backtrackingSolution(char[][] board, int i, int j){


        if(j>8){
            j=0;
            i++;
            if(i>8){
                return true;
            }
        }

        if (board[i][j] != '.') {
            if(backtrackingSolution(board,i,j+1)){
                return true;
            }
        }else{
            for(char val = '1'; val<='9';val++){
                if(isCellValid(board,val,i,j)){
                    board[i][j] = val;
                    if(backtrackingSolution(board,i,j+1)){
                        return true;
                    }
                    board[i][j] = '.';
                }
            }
        }


        return false;
    }
    private static ArrayList<HashSet<Integer>> getUnchangeableCells(char[][] board){
        ArrayList<HashSet<Integer>> unchangeableNumbers = new ArrayList<HashSet<Integer>>();
        for(int i = 0; i<board.length; i++){
            unchangeableNumbers.add(i, new HashSet<Integer>());
            HashSet<Integer> thisRow = unchangeableNumbers.get(i);
            for(int j = 0; j<board.length; j++){
                if(board[i][j]>'0' && board[i][j]<='9'){
                    thisRow.add(j);
                }
            }
        }
        return unchangeableNumbers;
    }
    private static boolean isCellValid(char[][] board, char value, int i, int j){
        if(rowCheck(board[i], value) && colCheck(board, j, value) && boxCheck(board, i, j, value)){
            return true;
        }
        return false;
    }
    private static boolean rowCheck(char[] row, char val){
        for(char c : row){
            if (c == val){
                return false;
            }
        }
        return true;
    }
    private static boolean colCheck(char[][] board, int cInd, char val){
        for(int j = 0;j<board.length;j++){
            if(board[j][cInd]==val){
                return false;
            }
        }


        return true;
    }
    private static boolean boxCheck(char[][] board, int rInd, int cInd, char val){
        rInd /= 3;
        cInd /= 3;
        for(int i = rInd*3; i<rInd*3+3;i++){
            for(int j = cInd*3; j<cInd*3+3;j++){
                if(board[i][j]==val){
                    return false;
                }
            }
        }

        return true;
    }


}
