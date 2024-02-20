import java.util.*;

public class TSPBruteforce {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] distances = {{0, 10, 15, 20}, {10, 0, 35, 25}, {15, 35, 0, 30}, {20, 25, 30, 0}};
        System.out.println("The shortest distance is " + tsp_bruteforce(distances));
    }

    private static int tsp_bruteforce(int[][] distances) {
        int n = distances.length;
        int minDistance = INF;
        List<List<Integer>> tours = new ArrayList<>();
        
        // Generate all possible tours
        for (int i = 0; i < n; i++) {
            List<Integer> tour = new ArrayList<>();
            tour.add(i);
            generateTours(distances, i, 1, n, tour);
            if (!tour.isEmpty()) {
                tours.add(tour);
            }
        }
        
        // Calculate minimum distance from all generated tours
        for (List<Integer> tour : tours) {
            int dist = calculateTotalDistance(distances, tour);
            if (dist < minDistance) {
                minDistance = dist;
            }
        }
        
        return minDistance;
    }
    
    /**
     * Generates all possible tours starting from 'startIndex'.
     */
    private static void generateTours(int[][] distances, int startIndex, int currLength, int n, List<Integer> currentTour) {
        if (currLength == n) {
            // Add last edge between first and last vertices in the path
            currentTour.add(startIndex);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (distances[startIndex][i] != 0 && !currentTour.contains(i)) {
                currentTour.add(i);
                generateTours(distances, i, currLength + 1, n, currentTour);
                currentTour.remove(currentTour.size() - 1);
            }
        }
    }

    /**
     * Returns total distance covered by given list of cities.
     */
    private static int calculateTotalDistance(int[][] distances, List<Integer> tour) {
        int result = 0;
        for (int i = 0; i < tour.size(); i++) {
            int j = (i + 1) % tour.size();
            result += distances[tour.get(i)][tour.get(j)];
        }
        return result;
    }
}