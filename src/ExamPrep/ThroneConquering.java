package ExamPrep;

import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int parisEnergy = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        String[][] field = new String[n][n];

        int parisRow = -1;
        int parisCol = -1;

        int helenaRow = -1;
        int helenaCol = -1;
        //int colectFlolers = 0;

        for (int i = 0; i < n; i++) {
            field[i] = scanner.nextLine().split("");
            for (int j = 0; j < n; j++) {
                if (field[i][j].equals("P")) {
                    parisRow = i;
                    parisCol = j;
                }

                if (field[i][j].equals("H")) {
                    helenaRow = i;
                    helenaCol = j;
                }
            }
        }

        String command = scanner.nextLine();

        while (parisEnergy > 0) {
            boolean isOutside = false;
            int startRow = parisRow;
            int startCol = parisCol;
            switch (command) {
                case "up":
                    parisRow--;
                    if (parisRow < 0) {
                        parisRow++;
                        isOutside = true;
                    }
                    break;
                case "down":
                    parisRow++;
                    if (parisRow >= n) {
                        parisRow--;
                        isOutside = true;
                    }
                    break;
                case "left":
                    parisCol--;
                    if (parisCol < 0) {
                        parisCol++;
                        isOutside = true;
                    }
                    break;
                case "right":
                    parisCol++;
                    if (parisCol >= n) {
                        parisCol--;
                        isOutside = true;
                    }
                    break;
            }
        }
    }
}
