import Game.Sudoku;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private final static int FROM_FILE = 1;
    private final static int GENERATE = 2;
    private final static int SOLVE = 3;
    private final static int CLEAR_BOARD = 4;
    private final static int PRINT_BOARD = 5;
    private final static int EXIT = 0;

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);

        Sudoku sudoku = null;
        while(true) {
            System.out.println("Выберите действие");
            System.out.println("1.Загрузить доску из файла");
            System.out.println("2.Сгенерировать судоку");
            System.out.println("3.Сгенерировать решение");
            System.out.println("4.Очистить доску");
            System.out.println("5.Вывести доску");
            System.out.println("0.Выход");

            try {
               int commandAction = sc.nextInt();
                switch(commandAction){
                    case FROM_FILE:
                        sudoku = new Sudoku("input.txt");
                        System.out.println("Успешно прочитано из файла");
                        break;
                    case GENERATE:
                        sudoku = new Sudoku(3);
                        System.out.println("Успешно сгенерирована доска:");
                        sudoku.printBoard();
                        break;
                    case SOLVE:
                        if(sudoku!=null) {
                            sudoku.generateSolution();
                            sudoku.printBoard();
                        }
                        break;
                    case CLEAR_BOARD:
                        sudoku = null;
                        break;
                    case PRINT_BOARD:
                        if(sudoku!=null) {
                            sudoku.printBoard();
                        }
                        break;
                    case EXIT:
                        System.out.println("Завершение работы");
                        return;
                    default:
                        System.out.println("Несуществующая команда");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Неправильная команда");
                sc.nextLine(); // Очистка буфера
            }


        }






    }
}

