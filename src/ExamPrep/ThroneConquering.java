package ExamPrep;

import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int parisEnergy = Integer.parseInt(scanner.nextLine());
        boolean parisLeftEnergy = true;
        int rows = Integer.parseInt(scanner.nextLine());
        String[][] field = new String[rows][];
        int col = 0;


        for (int i = 0; i < rows; i++) {
            field[i] = scanner.nextLine().split("");
        }


        int parisRow = -1;
        int parisCol = -1;

        for (int row = 0; row < rows; row++) {
            for (int cols = 0; cols < field[row].length; cols++) {
                if (field[row][cols] == "P") {
                    parisRow = row;
                    parisCol = col;
                }
            }
        }


        while (parisLeftEnergy) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];
            int spartanRow = Integer.parseInt(input[1]);
            int spartanCol = Integer.parseInt(input[2]);
            int startRow = parisRow;
            int startCol = parisCol;
            field[startRow][startCol] = "-";
            field[spartanRow][spartanCol] = "S";

            switch (command) {
                case "up":
                    parisRow--;
                    if (parisRow < 0) {
                        parisRow++;
                    }
                    break;
                case "down":
                    parisRow++;
                    if (parisRow >= field.length) {
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
                    if (parisCol >= field.length) {
                        parisCol--;
                    }
                    break;
            }

            parisEnergy--;

            if (parisEnergy <= 0) {
                parisDead(field, parisRow, parisCol);
                return;
            }
            if (field[parisRow][parisCol] == "S") {
                parisEnergy -= 2;
                if (parisEnergy <= 0) {
                    parisDead(field, parisRow, parisCol);
                    return;
                } else {
                    field[parisRow][parisCol] = "-";
                }
            } else if (field[parisRow][parisCol] == "H") {
                field[parisRow][parisCol] = "-";
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", parisEnergy);
                printMatrix(field);
                return;
            }
        }

        printMatrix(field);

    }

    public static void parisDead(String[][] field, int parisRow, int parisCol) {
        field[parisRow][parisCol] = "X";
        System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
        printMatrix(field);
    }

    private static void printMatrix(String[][] field) {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                System.out.print(field[row][col]);
            }
            System.out.println();
        }
    }
}
