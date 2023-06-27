<<<<<<< HEAD

package GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
=======
package GreedyTimes;

>>>>>>> origin/main
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");

<<<<<<< HEAD
        //var bag = new LinkedHashMap<String, LinkedHashMap<String, Long>>();
        Bag bag = new Bag(bagCapacity);

        /*long gold = 0;
        long stones = 0;
        long money = 0;*/
=======
        Bag bag = new Bag(bagCapacity);
        // Bag -> capacity, List<Item> items
        // Item -> name, amount, ItemType
        // enum ItemType
>>>>>>> origin/main

        for (int i = 0; i < safe.length; i += 2) {
            String name = safe[i];
            long amount = Long.parseLong(safe[i + 1]);

            ItemType itemType = getType(name);
<<<<<<< HEAD
            Item item = new Item(itemType, name, amount);
           /* String itemType = "";

            if (name.length() == 3) {
                itemType = "Cash";
            } else if (name.toLowerCase().endsWith("gem")) {
                itemType = "Gem";
            } else if (name.toLowerCase().equals("gold")) {
                itemType = "Gold";
            }*/

            if (itemType == null) {
                continue;
            } else if (bagCapacity < bag.getCapacity() + amount) {
                continue;
            }

           /* if (itemType.equals("")) {
                continue;
            } else if (bagCapacity < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + amount) {
                continue;
            }*/
            bag.put(item);
           /* switch (itemType) {
                case Gem:
                    if (!bag.isItemOfItemType(itemType)) {
                        if (bag.isItemOfItemType(ItemType.Gold)) {
                            if (amount > bag.getItemTypeAmount(ItemType.Gold)) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.getItemTypeAmount(itemType) + amount > bag.getItemTypeAmount(ItemType.Gold)) {
                        continue;
                    }
                    break;
                case Cash:
                    if (!bag.isItemOfItemType(itemType)) {
                        if (bag.isItemOfItemType(ItemType.Gem)) {
                            if (amount > bag.getItemTypeAmount(ItemType.Gold)) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.getItemTypeAmount(itemType) + amount > bag.getItemTypeAmount(ItemType.Gem)) {
                        continue;
                    }
                    break;
            }*/

            /*if (!bag.isItemOfItemType(itemType)) {
                Item item = new Item(itemType, name, amount);
            } else {
                Item item = bag.getItemByType(itemType);
                item.setAmount(item.getAmount() + amount);
            }*/
           /* if (!bag.containsKey(itemType)) {
                bag.put((itemType), new LinkedHashMap<String, Long>());
            }*/

            /*if (!bag.get(itemType).containsKey(name)) {
                bag.get(itemType).put(name, 0L);
            }


            bag.get(itemType).put(name, bag.get(itemType).get(name) + amount);
            if (itemType.equals("Gold")) {
                gold += amount;
            } else if (itemType.equals("Gem")) {
                stones += amount;
            } else if (itemType.equals("Cash")) {
                money += amount;
            }*/
        }
        bag.printItems();
        /*for (var x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }*/
=======

            Item item = new Item(itemType, name, amount);

            bag.put(item);
        }

        bag.printItems();
>>>>>>> origin/main
    }

    private static ItemType getType(String name) {
        ItemType itemType = null;
        if (name.length() == 3) {
            itemType = ItemType.valueOf("Cash");
        } else if (name.toLowerCase().endsWith("gem")) {
            itemType = ItemType.valueOf("Gem");
        } else if (name.equalsIgnoreCase("gold")) {
            itemType = ItemType.valueOf("Gold");
        }
        return itemType;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> origin/main
