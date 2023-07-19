package ExamPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

import static java.lang.System.in;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        int matches = 0;

        Deque<Integer> maleStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(maleStack::push);

        Deque<Integer> femaleQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(femaleQueue::offer);

        while (!maleStack.isEmpty() && !femaleQueue.isEmpty()) {
            int male = maleStack.peek();
            int female = femaleQueue.peek();

            if (female <= 0) {
                femaleQueue.poll();
                continue;
            } else if(male <= 0) {
                maleStack.pop();
                continue;
            }

            if(female % 25 == 0) {
                femaleQueue.poll();
                femaleQueue.poll();
                continue;
            }else if (male % 25 == 0) {
                maleStack.pop();
                maleStack.pop();
                continue;
            }

            if (male == female) {
                matches++;
                maleStack.pop();
                femaleQueue.poll();
            } else {
                femaleQueue.poll();
                int changeValueOfMale = maleStack.pop() - 2;
                maleStack.push(changeValueOfMale);
            }
        }

        System.out.printf("Matches: %d\n", matches);

        System.out.print("Males left: ");
        if(!maleStack.isEmpty()) {
            System.out.println(maleStack.toString().replace("[", "").replace("]", ""));
        } else {
            System.out.println("none");
        }

        System.out.print("Females left: ");
        if(!femaleQueue.isEmpty()) {
            System.out.println(femaleQueue.toString().replace("[", "").replace("]", ""));
        } else {
            System.out.println("none");
        }
    }
}
