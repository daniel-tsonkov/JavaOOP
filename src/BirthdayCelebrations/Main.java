package BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> livingBeings = new ArrayList<>();

        String information = scanner.nextLine();

        while (!information.equals("End")) {
            String[] splitetInformation = information.split("\\s+");

            switch (splitetInformation[0]) {
                case "Citizen":
                    livingBeings.add(new Citizen(splitetInformation[1], Integer.parseInt(splitetInformation[2]), splitetInformation[3], splitetInformation[4]));
                    break;
                case "Pet":
                    livingBeings.add(new Pet(splitetInformation[1], splitetInformation[2]));
                    break;
            }

            information = scanner.nextLine();
        }

        String year = scanner.nextLine();

        livingBeings.stream().map(Birthable::getBirthDate).filter(birthDate -> birthDate.endsWith(year)).forEach(System.out::println);

        scanner.close();
    }
}

