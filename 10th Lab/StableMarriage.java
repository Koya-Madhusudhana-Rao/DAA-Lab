import java.util.Arrays;

public class StableMarriage {
    private int n; // Number of couples
    private int[][] menPreferences; // Men's preferences
    private int[][] womenPreferences; // Women's preferences
    private int[] womenPartners; // Women's current partners
    private int[] menNextProposal; // Men's next proposal index

    public StableMarriage(int n, int[][] menPreferences, int[][] womenPreferences) {
        this.n = n;
        this.menPreferences = menPreferences;
        this.womenPreferences = womenPreferences;
        womenPartners = new int[n];
        menNextProposal = new int[n];

        // Initialize women's partners to -1 (no partner)
        Arrays.fill(womenPartners, -1);
    }

    // Gale-Shapley algorithm to solve the stable marriage problem
    public void solve() {
        // Initialize menNextProposal array
        for (int i = 0; i < n; i++) {
            menNextProposal[i] = 0;
        }

        // Men propose until all are matched
        boolean[] freeMen = new boolean[n];
        Arrays.fill(freeMen, true);
        int freeCount = n;

        while (freeCount > 0) {
            int man = -1;

            // Find a free man
            for (int i = 0; i < n; i++) {
                if (freeMen[i]) {
                    man = i;
                    break;
                }
            }

            // Get the next woman in the man's preference list
            int womanIndex = menPreferences[man][menNextProposal[man]];
            menNextProposal[man]++;

            // Check if the woman is free or prefers this man over her current partner
            if (womenPartners[womanIndex] == -1) {
                // The woman is free, pair her with the man
                womenPartners[womanIndex] = man;
                freeMen[man] = false;
                freeCount--;
            } else {
                int currentPartner = womenPartners[womanIndex];
                // Check if the woman prefers this man over her current partner
                if (prefersNewMan(womanIndex, man, currentPartner)) {
                    // The woman prefers this man, switch partners
                    womenPartners[womanIndex] = man;
                    freeMen[man] = false;
                    freeMen[currentPartner] = true;
                }
            }
        }
    }

    // Helper method to check if a woman prefers a new man over her current partner
    private boolean prefersNewMan(int womanIndex, int newMan, int currentPartner) {
        for (int i = 0; i < n; i++) {
            if (womenPreferences[womanIndex][i] == newMan) {
                return true;
            }
            if (womenPreferences[womanIndex][i] == currentPartner) {
                return false;
            }
        }
        return false;
    }

    // Print the stable matching
    public void printMatching() {
        System.out.println("Stable Matching:");
        for (int i = 0; i < n; i++) {
            System.out.println("Woman " + (i + 1) + " is paired with Man " + (womenPartners[i] + 1));
        }
    }

    public static void main(String[] args) {
        // Number of couples
        int n = 4;

        // Men's preferences
        int[][] menPreferences = {
            {0, 1, 2, 3},
            {0, 1, 3, 2},
            {0, 3, 1, 2},
            {2, 3, 1, 0}
        };

        // Women's preferences
        int[][] womenPreferences = {
            {0, 1, 2, 3},
            {1, 0, 3, 2},
            {2, 0, 3, 1},
            {3, 2, 1, 0}
        };

        // Create StableMarriage instance and solve the problem
        StableMarriage stableMarriage = new StableMarriage(n, menPreferences, womenPreferences);
        stableMarriage.solve();
        stableMarriage.printMatching();
    }
}
