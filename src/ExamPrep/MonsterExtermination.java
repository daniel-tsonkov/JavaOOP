package ExamPrep;

import java.util.*;
import java.util.stream.Collectors;

public class MonsterExtermination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int monstersCounter = 0;

        Deque<Integer> monsterQUeue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(","))
                .map(Integer::parseInt)
                .forEach(monsterQUeue::offer);

        Deque<Integer> soldierStacks = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(","))
                .map(Integer::parseInt)
                .forEach(soldierStacks::push);


        while (!monsterQUeue.isEmpty() && !soldierStacks.isEmpty()) {
            int monsterArmer = monsterQUeue.poll(); //trie
            int soldieratack = soldierStacks.pop(); //trie


            if (soldieratack >= monsterArmer) {
                int temp = 0;

                if (!soldierStacks.isEmpty()) {
                    temp = soldierStacks.pop();
                }

                soldieratack = temp + (soldieratack - monsterArmer);
                soldierStacks.push(soldieratack);
                monstersCounter++;
            } else {
                monsterArmer = monsterArmer - soldieratack;
                monsterQUeue.offer(monsterArmer);
            }
        }

        if ((soldierStacks.isEmpty()) && (monsterQUeue.isEmpty())) {
            System.out.println("The soldier has been defeated.");
        } else {
            if (monsterQUeue.isEmpty()) {
                System.out.println("All monsters have been killed!");
            }
            if (soldierStacks.isEmpty()) {
                System.out.println("The soldier has been defeated.");
            }

        }
        System.out.println("Total monsters killed: " + monstersCounter);
    }
}
