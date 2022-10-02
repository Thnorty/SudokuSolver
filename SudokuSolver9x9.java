/** 
 * Ad Soday: Oguz Nurlu
 * Ogrenci Numarasi: 211101069
 */ 

import java.util.Scanner;

public class SudokuSolver9x9 {
    private static int solvable = 0;
    private static int[][] sudoku = new int[9][9];

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();
        for (int i1 = 0; i1 < 9; i1++) {
            for (int i2 = 0; i2 < 9; i2++) {
                sudoku[i1][i2] = input.charAt(((i1 * 9) + i2) * 2) - 48;
            }
        }

        if (solve_sudoku(0))
            System.out.println("Solvable!");
        else
            System.out.println("Unsolvable :(");
        keyboard.close();
    }

    public static boolean solve_sudoku(int index) {
        int x1 = index % 9;
        int y1 = index / 9;

        if (index == 81) {
            System.out.println("-----------------");
            print_sudoku(sudoku);
            solvable = 1;
        }

        else if (sudoku[x1][y1] != 40) {
            solve_sudoku(index + 1);
        }

        else if (sudoku[x1][y1] == 40) {
            for (int i = 1; i <= 9; i++) {
                int sameNumber = 0;
                for (int i2 = 0; i2 < 9; i2++) {
                    if (i == sudoku[x1][i2])
                        sameNumber += 1;
                        
                    if (i == sudoku[i2][y1])
                        sameNumber += 1;
                }
                for (int i2 = 0; i2 < 9; i2++) {
                    int x2 = i2 % 3;
                    int y2 = i2 / 3;
                    if (x1 < 3 && y1 < 3) {
                        if (i == sudoku[0 + x2][0 + y2])
                            sameNumber += 1;
                    } else if (x1 < 3 && y1 < 6) {
                        if (i == sudoku[0 + x2][3 + y2])
                            sameNumber += 1;
                    } else if (x1 < 3 && y1 < 9) {
                        if (i == sudoku[0 + x2][6 + y2])
                            sameNumber += 1;
                    } else if (x1 < 6 && y1 < 3) {
                        if (i == sudoku[3 + x2][0 + y2])
                            sameNumber += 1;
                    } else if (x1 < 6 && y1 < 6) {
                        if (i == sudoku[3 + x2][3 + y2])
                            sameNumber += 1;
                    } else if (x1 < 6 && y1 < 9) {
                        if (i == sudoku[3 + x2][6 + y2])
                            sameNumber += 1;
                    } else if (x1 < 9 && y1 < 3) {
                        if (i == sudoku[6 + x2][0 + y2])
                            sameNumber += 1;
                    } else if (x1 < 9 && y1 < 6) {
                        if (i == sudoku[6 + x2][3 + y2])
                            sameNumber += 1;
                    } else if (x1 < 9 && y1 < 9) {
                        if (i == sudoku[6 + x2][6 + y2])
                            sameNumber += 1;
                    }
                }

                if (sameNumber == 0){
                    sudoku[x1][y1] = i;
                    solve_sudoku(index + 1);
                    sudoku[x1][y1] = 40;
                }
            }
        }
        if (solvable == 0)
            return false;
        else
            return true;
    }

    public static void print_sudoku(int[][] sudoku) {
        for (int i1 = 0; i1 < 9; i1++) {
            for (int i2 = 0; i2 < 9; i2++) {
                System.out.print(sudoku[i1][i2] + " ");
            }
            System.out.println();
        }
    }
}