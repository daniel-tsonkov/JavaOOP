package JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static long sum = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        int value = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = value++;
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("Let the Force be with you")) {
            int[] heroCoordinates = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] evilCoordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int evilRow = evilCoordinates[0];
            int evilCol = evilCoordinates[1];

            moveCoordinates(matrix, evilRow, evilCol, "evil", sum);

            int heroRow = heroCoordinates[0];
            int heroCol = heroCoordinates[1];

            moveCoordinates(matrix, heroRow, heroCol, "hero", sum);

            command = scanner.nextLine();
        }
        System.out.println(sum);
    }

    private static void moveCoordinates(int[][] matrix, int row, int col, String type, long sum) {
        while (row >= 0 && col >= 0) {
            if (row < matrix.length && col < matrix[0].length) {
                if (type.equals("evil")) {
                    matrix[row][col] = 0;
                } else {
                    sum += matrix[row][col];
                }
            }
            row--;
            col--;
        }
    }
}
