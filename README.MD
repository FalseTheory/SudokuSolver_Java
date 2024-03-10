
# Sudoku Game (java)
___
Simple **sudoku** game created in java.  

## Features

1. Creating a new board  
2. Validating an existing board
3. Solving a board with backtracking algorithm
4. All the above with user provided sudoku board

## Example
___
### User board solving
```java
import Game.Sudoku;
import Game.SudokuSolver;

Sudoku sudoku = new Sudoku(userBoard);
SudokuSolver.bactrackingSolution(sudoku.getBoard(), 0, 0);
sudoku.printBoard();

```
### Creating a new board

```java
import Game.Sudoku;

Sudoku sudoku = new Sudoku();

```


