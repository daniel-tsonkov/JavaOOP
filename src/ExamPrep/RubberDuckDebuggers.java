package ExamPrep;

import java.util.*;

public class RubberDuckDebuggers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputProgrammers = scanner.nextLine().split("\\s+");
        String[] inputTasks = scanner.nextLine().split("\\s+");

        Map<String, Integer> ducksMap = new LinkedHashMap<>();

        ducksMap.put("Darth Vader Ducky", 0);
        ducksMap.put("Thor Ducky", 0);
        ducksMap.put("Big Blue Rubber Ducky", 0);
        ducksMap.put("Small Yellow Rubber Ducky", 0);

        ArrayDeque<Integer> programmers = new ArrayDeque<>();
        Arrays.stream(inputProgrammers).mapToInt(Integer::parseInt).forEach(programmers::offer);
        Stack<Integer> tasks = new Stack<>();
        Arrays.stream(inputTasks).mapToInt(Integer::parseInt).forEach(tasks::push);

        while (!programmers.isEmpty() && !tasks.isEmpty()) {
            int programer = programmers.peek();
            int taask = tasks.peek();
            int needTime = programer * taask;

            if(needTime >= 0 && needTime <= 60) {
                ducksMap.put("Darth Vader Ducky", ducksMap.get("Darth Vader Ducky") + 1);
                programmers.poll();
                tasks.pop();
            } else  if(needTime >= 61 && needTime <= 120) {
                ducksMap.put("Thor Ducky", ducksMap.get("Thor Ducky") + 1);
                programmers.poll();
                tasks.pop();
            }  else  if(needTime >= 121 && needTime <= 180) {
                ducksMap.put("Big Blue Rubber Ducky", ducksMap.get("Big Blue Rubber Ducky") + 1);
                programmers.poll();
                tasks.pop();
            }else  if(needTime >= 181 && needTime <= 240) {
                ducksMap.put("Small Yellow Rubber Ducky", ducksMap.get("Small Yellow Rubber Ducky") + 1);
                programmers.poll();
                tasks.pop();
            } else {
                programmers.offerLast(programmers.poll());
                tasks.push(tasks.pop() - 2);
            }
        }

        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded: ");
        for (Map.Entry<String, Integer> duckEntry : ducksMap.entrySet()) {
            System.out.println(duckEntry.getKey() + ": " + duckEntry.getValue());
        }
    }
}
