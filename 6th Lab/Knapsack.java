import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value, weight;

    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class Knapsack {

    public static void main(String[] args) {
        int capacity = 50;
        Item[] items = {
                new Item(60, 10),
                new Item(100, 20),
                new Item(120, 30)
        };

        double maxValue = knapsack(items, capacity);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }

    public static double knapsack(Item[] items, int capacity) {
        // Sort items based on value-to-weight ratio in descending order
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                double ratio1 = (double) item1.value / item1.weight;
                double ratio2 = (double) item2.value / item2.weight;
                return Double.compare(ratio2, ratio1);  // Compare in descending order
            }
        });
        
        int currentWeight = 0;
        double totalValue = 0;

        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                // Add the whole item to the knapsack
                currentWeight += item.weight;
                totalValue += item.value;
            } else {
                // Add a fraction of the item to fill the remaining capacity
                double remainingCapacity = capacity - currentWeight;
                totalValue += (remainingCapacity / item.weight) * item.value;
                break;
            }
        }

        return totalValue;
    }
}
