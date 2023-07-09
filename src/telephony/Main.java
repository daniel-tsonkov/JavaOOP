package telephony;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);

        String[] phoneNumbers = scanner.nextLine().split("\\s+");
        String[] urls = scanner.nextLine().split("\\s+");

        Smartphone smartphone = new Smartphone(List.of(phoneNumbers), List.of(urls));


        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());
    }
}
