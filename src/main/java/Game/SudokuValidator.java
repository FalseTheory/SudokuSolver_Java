package Game;

import java.util.HashSet;
import java.util.Set;

public class SudokuValidator {

    public static boolean isSudokuValid(char[][] board){
        for(int i = 0; i < board.length; i++){
            if(!isRowValid(board[i])){
                return false;
            }
            if(!isColumnValid(board, i)){
                return false;
            }
        }
        for(int i = 0;i<board.length;i+=3){
            for(int j = 0;j<board.length;j+=3){
                if(!isBoxValid(board,i,j)){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isRowValid(char[] row){
        Set<Character> thisRow = new HashSet<>();

        for(int i = 0; i < row.length; i++){
            if(row[i]=='.'){
                continue;
            }
            if(!thisRow.add(row[i])){
                return false;
            }
        }
        return true;
    }
    private static boolean isColumnValid(char[][] board, int cInd){
        Set<Character> thisCol = new HashSet<>();

        for(int j = 0; j<board.length; j++){
            if(board[j][cInd]=='.'){
                continue;
            }
            if(!thisCol.add(board[j][cInd])){
                return false;
            }
        }
        return true;
    }
    private static boolean isBoxValid(char[][] board, int rInd, int cInd){
        Set<Character> thisBox = new HashSet<>();

        for(int i = rInd; i<rInd+3; i++){
            for(int j = cInd;j<cInd+3;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(!thisBox.add(board[i][j])){
                    return false;
                }
            }
        }

        return true;
    }
}
