package ExamPrep;

import java.util.Scanner;

public class DeliveryBoy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        String[][] field = new String[x][y];
        int playerRow = -1;
        int playerCol = -1;
        boolean deliveryLate = true;

        int startPlayerRow = playerRow;
        int startplayerCol = playerCol;

        for (int i = 0; i < x; i++) {
            field[i] = scanner.nextLine().split("");
            for (int j = 0; j < y; j++) {
                if (field[i][j].equals("B")) {
                    playerRow = i;
                    playerCol = j;
                    startPlayerRow = playerRow;
                    startplayerCol = playerCol;
                }
            }
        }

        for (int i = 0; i <= 9; i++) {
            String command = scanner.nextLine();
            int prevPlayerRow = playerRow;
            int prevPlayerCol = playerCol;

            switch (command) {
                case "up":
                    playerRow--;
                    break;
                case "down":
                    playerRow++;
                    break;
                case "left":
                    playerCol--;
                    break;
                case "right":
                    playerCol++;
                    break;
            }
            if (playerRow < 0 || playerRow >= x || playerCol < 0 || playerCol >= y ) {
                System.out.println("The delivery is late. Order is canceled.");
                field[startPlayerRow][startplayerCol] = " ";
                break;
            }
            if (field[playerRow][playerCol].equals("A")) {
                field[playerRow][playerCol] = "P";
                System.out.println("Pizza is delivered on time! Next order...");
                deliveryLate = false;
                break;
            }
            if (field[playerRow][playerCol].equals("*")) {
                playerRow = prevPlayerRow;
                playerCol = prevPlayerCol;
            } else {
                if (field[playerRow][playerCol].equals("P")) {
                    field[playerRow][playerCol] = "R";
                    System.out.println("Pizza is collected. 10 minutes for delivery.");
                } else {
                    field[playerRow][playerCol] = ".";
                }
            }
        }

        printMatrix(field, x, y);
    }

    private static void printMatrix(String[][] matrix, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
