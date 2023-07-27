package ExamPrep;

import java.util.Scanner;

public class FormulaOne {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int count = Integer.parseInt(scanner.nextLine());
        boolean complete = false;

        char[][] matrix = new char[size][size];

        fillMatrix(scanner, size, matrix);

        int playerRow = -1;
        int playerCol = -1;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 'P') {
                    playerRow = i;
                    playerCol = j;
                    matrix[playerRow][playerCol] = '.';
                    break;
                }
            }
        }

        for (int commands = 0; commands < count; commands++) {
            String command = scanner.nextLine();
            int prevPlayerRow = playerRow;
            int prevPlayerCol = playerCol;

            switch (command) {
                case "up":
                    playerRow--;
                    if (playerRow < 0) {
                        playerRow = size - 1;
                    }
                    break;
                case "down":
                    playerRow++;
                    if (playerRow >= size) {
                        playerRow = 0;
                    }
                    break;
                case "left":
                    playerCol--;
                    if (playerCol < 0) {
                        playerCol = size - 1;
                    }
                    break;
                case "right":
                    playerCol++;
                    if (playerCol >= size) {
                        playerCol = 0;
                    }
                    break;
            }

            if (matrix[playerRow][playerCol] == 'B') {
                switch (command) {
                    case "up":
                        playerRow--;
                        if (playerRow < 0) {
                            playerRow = size - 1;
                        }
                        break;
                    case "down":
                        playerRow++;
                        if (playerRow >= size) {
                            playerRow = 0;
                        }
                        break;
                    case "left":
                        playerCol--;
                        if (playerCol < 0) {
                            playerCol = size - 1;
                        }
                        break;
                    case "right":
                        playerCol++;
                        if (playerCol >= size) {
                            playerCol = 0;
                        }
                        break;
                }
            } else if (matrix[playerRow][playerCol] == 'T') {
                playerRow = prevPlayerRow;
                playerCol = prevPlayerCol;
            } else if (matrix[playerRow][playerCol] == 'F') {
                matrix[playerRow][playerCol] = 'P';
                System.out.println("Well done, the player won first place!");
                complete = true;
            }
        }
        if (!complete) {
            matrix[playerRow][playerCol] = 'P';
            System.out.println("Oh no, the player got lost on the track!");
        }
        printMatrix(matrix);
    }

    /*private static void movePlayer(int currentRow, int currentCol, char[][] matrix, String command) {

    }*/
    private static void fillMatrix(Scanner scanner, int size, char[][] matrix) {
        for (int i = 0; i < size; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
