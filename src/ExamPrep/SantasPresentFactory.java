package ExamPrep;

import java.util.*;
import java.util.stream.Collectors;

public class SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String matterialsInput = scanner.nextLine();
        String magicsInput = scanner.nextLine();

        Stack<Integer> matterials = new Stack<>();
        Arrays.stream(matterialsInput.split("\\s+")).map(Integer::parseInt).forEach(matterials::push);

        Queue<Integer> magics = new ArrayDeque<>();
        magics = Arrays.stream(magicsInput.split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        Map<String, Integer> presentsMap = new TreeMap<>();
        presentsMap.put("Doll", 0);
        presentsMap.put("Wooden train", 0);
        presentsMap.put("Teddy bear", 0);
        presentsMap.put("Bicycle", 0);


        while (!matterials.isEmpty() && !magics.isEmpty()) {
            int material = matterials.peek();
            int magic = magics.peek();

            int totalMagic = material * magic;

            if(totalMagic == 150) {
                matterials.pop();
                magics.poll();
                presentsMap.put("Doll", presentsMap.get("Doll") + 1);
            }else if(totalMagic == 250) {
                matterials.pop();
                magics.poll();
                presentsMap.put("Wooden train", presentsMap.get("Wooden train") + 1);
            }else if(totalMagic == 300) {
                matterials.pop();
                magics.poll();
                presentsMap.put("Teddy bear", presentsMap.get("Teddy bear") + 1);
            }else if(totalMagic == 400) {
                matterials.pop();
                magics.poll();
                presentsMap.put("Bicycle", presentsMap.get("Bicycle") + 1);
            } else if (totalMagic < 0) {
                int sum = material + magic;
                matterials.pop();
                magics.poll();
                matterials.push(sum);
            } else if (totalMagic > 0) {
                magics.poll();
                matterials.push(matterials.pop() + 15);
            } else {
                if(material == 0) {
                    matterials.pop();
                }
                if(magic == 0) {
                    magics.poll();
                }
            }
        }

        if ((presentsMap.get("Doll") > 0 && presentsMap.get("Wooden train") > 0) || (presentsMap.get("Teddy bear") > 0 && presentsMap.get("Bicycle") > 0)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!matterials.isEmpty()) {
            System.out.print("Materials left: ");
            Collections.reverse(matterials);
            System.out.println(matterials.toString().replace("[", "").replace("]", ""));
        }

        if (!magics.isEmpty()) {
            System.out.print("Magic left: ");
            System.out.println(magics.toString().replace("[", "").replace("]", ""));
        }

        for (Map.Entry<String, Integer> entry : presentsMap.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
            }
        }
    }
}
