package ExamPrep;

import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[][] field = new String[n][n];
        int mouseRow = -1;
        int mouseCol = -1;
        int eatCheses = 0;

        for (int i = 0; i < n; i++) {
            field[i] = scanner.nextLine().split("");
            for (int j = 0; j < n; j++) {
                if (field[i][j].equals("M")) {
                    mouseRow = i;
                    mouseCol = j;
                }
            }
        }

        String command = scanner.nextLine();
        boolean isOutside = false;

        while (!command.equals("end")) {
            int startRow = mouseRow;
            int startCol = mouseCol;
            mouseRow = updateBeeRow(command, mouseRow);
            mouseCol = updateBeeCol(command, mouseCol);

            if ((mouseRow < 0) || (mouseRow >= n) || (mouseCol < 0) || (mouseCol >= n)) {
                System.out.println("Where is the mouse?");
                command = "end";
                field[startRow][startCol] = "-";
                continue;
            } else {
                if (field[mouseRow][mouseCol].equals("B")) {
                    field[mouseRow][mouseCol] = "-";

                    mouseRow = updateBeeRow(command, mouseRow);
                    mouseCol = updateBeeCol(command, mouseCol);
                }
                if (field[mouseRow][mouseCol].equals("c")) {
                    eatCheses++;
                }
                field[startRow][startCol] = "-";
                field[mouseRow][mouseCol] = "M";
            }
            command = scanner.nextLine();
        }

        if (eatCheses < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.\n", (5 - eatCheses));
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!\n", eatCheses);
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
