package ExamPrep;

import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[][] field = new String[n][n];
        int beeCoordinatesX = -1;
        int beeCoordinatesY = -1;

        for (int i = 0; i < n; i++) {
            field[i] = scanner.nextLine().split("");
            for (int j = 0; j < n; j++) {
                if (field[i][j].equals("B")) {
                    beeCoordinatesX = i;
                    beeCoordinatesY = j;
                }

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
