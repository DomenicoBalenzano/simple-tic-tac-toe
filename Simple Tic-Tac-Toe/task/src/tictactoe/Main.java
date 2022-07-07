package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Input of the string with the empty
        String s = "_________";
        int pos = 0;
        char[][] array = new char[3][3];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = s.charAt(pos);
                pos++;
            }
        }
        //Print the array
        printArray(array);

        //Input of the coordinates to add, loop until input is not valid
        boolean finished = false;
        char player = 'X';
        int count = 0;
        do {
            player = count % 2 == 0 ? 'X' : 'O';
            array = nextMove(array, player);
            count++;

            //Print the updated array
            printArray(array);

            //Check the state of the game
            boolean rowXwin = checkRows(array, 'X');
            boolean rowOwin = checkRows(array, 'O');
            if (!(rowXwin && rowOwin)) {
                boolean colXwin = checkCols(array, 'X');
                boolean colOwin = checkCols(array, 'O');
                if (!(colXwin && colOwin)) {
                    if (Math.abs(countChar(array, 'X') - countChar(array, 'O')) < 2) {
                        if (!(rowXwin || rowOwin) && !(colXwin || colOwin)) {
                            boolean crossXwinAsc = checkCrossAsc(array, 'X');
                            boolean crossXwinDesc = checkCrossDesc(array, 'X');
                            boolean crossOwinAsc = checkCrossAsc(array, 'O');
                            boolean crossOwinDesc = checkCrossDesc(array, 'O');
                            if (!(crossXwinAsc || crossXwinDesc || crossOwinAsc || crossOwinDesc)) {
                                if (s.contains("_")) {
                                    //nobody won and there are empty cells
                                    finished = false;
                                } else {
                                    //nobody won and the grid is full
                                    System.out.println("Draw");
                                    finished = true;
                                }
                            } else {
                                //one of them won in a cross
                                System.out.println(crossXwinAsc || crossXwinDesc ? "X wins" : "O wins");
                                finished = true;
                            }
                        } else {
                            //one of them won in a row or in a coloumn
                            System.out.println(rowXwin || colXwin ? "X wins" : "O wins");
                            finished = true;
                        }
                    } else {
                        //the difference is equals or greater then 2
                        System.out.println("Impossible");
                        finished = true;
                    }
                } else {
                    //there are 3 X and 3 O in coloumns
                    System.out.println("Impossible");
                    finished = true;
                }
            } else {
                //there are 3 X and 3 O in rows
                System.out.println("Impossible");
                finished = true;
            }
        } while (!finished);
    }

    public static void printArray(char[][] array) {
        System.out.println("---------");
        for (int i = 0; i < array.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static char[][] nextMove(char[][] array, char player) {
        boolean valid = false;
        int row = 0;
        int col = 0;
        do {
            System.out.print("Enter the coordinates: ");
            Scanner sc = new Scanner(System.in);
            if (!(sc.hasNextInt())) {
                System.out.println("You should enter numbers!");
            } else {
                row = sc.nextInt();
                if (!(sc.hasNextInt())) {
                    System.out.println("You should enter numbers!");
                } else {
                    col = sc.nextInt();
                    if ((row < 1 || row > 3) || (col < 1 || col > 3)) {
                        System.out.println("Coordinates should be from 1 to 3!");
                    } else {
                        if (array[row - 1][col - 1] != '_') {
                            System.out.println("This cell is occupied! Choose another one!");
                        } else {
                            valid = true;
                        }
                    }
                }
            }
        } while (!valid);
        //Update the array
        array[row - 1][col - 1] = player;
        return array;
    }

    public static boolean checkRows(char[][] array, char c) {
        boolean win = true;
        for (int i = 0; i < array.length; i++) {
            win = true;
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != c) {
                    win = false;
                    break;
                }
            }
            if (win) {
                break;
            }
        }
        return win;
    }

    public static boolean checkCols(char[][] array, char c) {
        boolean win = true;
        for (int i = 0; i < array.length; i++) {
            win = true;
            for (int j = 0; j < array[i].length; j++) {
                if (array[j][i] != c) {
                    win = false;
                    break;
                }
            }
            if (win) {
                break;
            }
        }
        return win;
    }

    public static int countChar(char[][] array, char c) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == c) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean checkCrossAsc(char[][] array, char c) {
        boolean win = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i][i] != c) {
                win = false;
                break;
            }
        }
        return win;
    }

    public static boolean checkCrossDesc(char[][] array, char c) {
        boolean win = true;
        int end = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i][end] != c) {
                win = false;
                break;
            }
            end--;
        }
        return win;
    }
}
