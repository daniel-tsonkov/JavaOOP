package ExamPrep;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][n];

        fillMatrix(matrix, scanner);

        int playerRow = -1;
        int playerCol = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j].equals("P")) {
                    playerRow = i;
                    playerCol = j;
                }
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            switch (command) {
                case "up" :
                    break;
                case "down" :
                    break;
                case "left" :
                    break;
                case "right" :
                    break;
            }

            command = scanner.nextLine();
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("");
        }
    }
}
