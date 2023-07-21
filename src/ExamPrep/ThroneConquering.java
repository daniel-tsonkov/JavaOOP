package ExamPrep;

import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int parisEnergy = Integer.parseInt(scanner.nextLine());
        boolean parisLeftEnergy = true;
        int n = Integer.parseInt(scanner.nextLine());

        String[][] field = new String[n][n];

        int parisRow = -1;
        int parisCol = -1;

        for (int i = 0; i < n; i++) {
            field[i] = scanner.nextLine().split("");
            for (int j = 0; j < n; j++) {
                if (field[i][j].equals("P")) {
                    parisRow = i;
                    parisCol = j;
                }
            }
        }

        while (parisLeftEnergy) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            int spartanRow = Integer.parseInt(input[1]);
            int spartanCol = Integer.parseInt(input[2]);
            field[spartanRow][spartanCol] = "S";
            int startRow = parisRow;
            int startCol = parisCol;

            switch (command) {
                case "up":
                    parisRow--;
                    if (parisRow < 0) {
                        parisRow++;
                    }
                    break;
                case "down":
                    parisRow++;
                    if (parisRow >= n) {
                        parisRow--;
                    }
                    break;
                case "left":
                    parisCol--;
                    if (parisCol < 0) {
                        parisCol++;
                    }
                    break;
                case "right":
                    parisCol++;
                    if (parisCol >= n) {
                        parisCol--;
                    }
                    break;
            }

            parisEnergy--;

            field[startRow][startCol] = "-";

            if (field[parisRow][parisCol].equals("S")) {
                parisEnergy -= 2;
            }

            if (field[parisRow][parisCol].equals("H")) {
                field[parisRow][parisCol] = "-";
                parisLeftEnergy = false;
                System.out.printf("Paris has successfully abducted Helen! ");
                System.out.printf("Energy left: %d\n", parisEnergy);
            } else {
                field[parisRow][parisCol] = "P";
            }

            if (parisEnergy <= 0) {
                field[parisRow][parisCol] = "X";
                parisLeftEnergy = false;
                System.out.printf("Paris died at %d;%d.\n", parisRow, parisCol);
            }
        }

        printMatrix(field);

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
