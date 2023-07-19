package ExamPrep;

import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[][] field = new String[n][n];
        int playerRow = -1;
        int playerCol = -1;
        int colectFlolers = 0;

        for (int i = 0; i < n; i++) {
            field[i] = scanner.nextLine().split("");
            for (int j = 0; j < n; j++) {
                if (field[i][j].equals("B")) {
                    playerRow = i;
                    playerCol = j;
                }
            }
        }

        String command = scanner.nextLine();
        boolean isOutside = false;

        while (!command.equals("End")) {
            int startRow = playerRow;
            int startCol = playerCol;
            playerRow = updateBeeRow(command, playerRow);
            playerCol = updateBeeCol(command, playerCol);

            if ((playerRow < 0) || (playerRow >= n) || (playerCol < 0) || (playerCol >= n)) {
                System.out.println("The bee got lost!");
                command = "End";
                field[startRow][startCol] = ".";
                continue;
            } else {
                 if (field[playerRow][playerCol].equals("O")) {
                    field[playerRow][playerCol] = ".";

                     playerRow = updateBeeRow(command, playerRow);
                     playerCol = updateBeeCol(command, playerCol);
                }
                 if (field[playerRow][playerCol].equals("f")) {
                    colectFlolers++;
                }
                field[startRow][startCol] = ".";
                field[playerRow][playerCol] = "B";
            }
            command = scanner.nextLine();
        }

        if (colectFlolers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n", (5 - colectFlolers));
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!\n", colectFlolers);
        }

        printMatrix(field);
    }

    private static int updateBeeRow(String command, int playerRow) {
        switch (command) {
            case "up":
                playerRow--;
                break;
            case "down":
                playerRow++;
                break;
        }
        return playerRow;
    }

    private static int updateBeeCol(String command, int playerCol) {
        switch (command) {
            case "left":
                playerCol--;
                break;
            case "right":
                playerCol++;
                break;
        }
        return playerCol;
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
