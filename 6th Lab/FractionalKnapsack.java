import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    static class Item {
        int profit, weight;

        public Item(int profit, int weight) {
            this.profit = profit;
            this.weight = weight;
        }
    }

    public static double getMaxValue(Item[] items, int capacity) {
        Arrays.sort(items, (item1, item2) -> Double.compare((double) item2.profit / item2.weight, (double) item1.profit / item1.weight));

        
        double totalValue = 0;

        for (Item item : items) {
            int currentWeight = item.weight;
            int currentValue = item.profit;

            if (capacity - currentWeight >= 0) {
                // Take the whole item
                capacity -= currentWeight;
                totalValue += currentValue;
            } else {
                // Take a fraction of the item
                double fraction = (double) capacity / currentWeight;
                totalValue += (currentValue * fraction);
                capacity = 0;  // Knapsack is full
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = {
                new Item(60, 10),
                new Item(100, 20),
                new Item(120, 30)
        };

        int capacity = 50;

        double maxValue = getMaxValue(items, capacity);

        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}
