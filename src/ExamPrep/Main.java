package ExamPrep;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        StringBuilder wordBuilder = new StringBuilder(word);
        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][n];

        fillMatrix(matrix, scanner);

        int playerRow = -1;
        int playerCol = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j].equals("P")) {
                    playerRow = i;
                    playerCol = j;
                }
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            boolean isOutside = false;
            int startRow = playerRow;
            int startCol = playerCol;
            switch (command) {
                case "up":
                    playerRow--;
                    if (playerRow < 0) {
                        playerRow++;
                        isOutside = true;
                    }
                    break;
                case "down":
                    playerRow++;
                    if (playerRow >= n) {
                        playerRow--;
                        isOutside = true;
                    }
                    break;
                case "left":
                    playerCol--;
                    if (playerCol < 0) {
                        playerCol++;
                        isOutside = true;
                    }
                    break;
                case "right":
                    playerCol++;
                    if (playerCol >= n) {
                        playerCol--;
                        isOutside = true;
                    }
                    break;
            }
            if (!isOutside) {
                String currentWord = matrix[playerRow][playerCol];
                if (!currentWord.equals("-")) {
                    wordBuilder.append(currentWord);
                }
                matrix[playerRow][playerCol] = "P";
                matrix[startRow][startCol] = "-";
            } else {
                if (wordBuilder.length() > 0) {
                    wordBuilder.deleteCharAt(wordBuilder.length() - 1);
                }
            }

            command = scanner.nextLine();
        }
        System.out.println(wordBuilder);
        
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("");
        }
    }
}
