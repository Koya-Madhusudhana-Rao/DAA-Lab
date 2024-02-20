import java.util.Scanner;

public class LinearSearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 10 }; // Same array structure
        System.out.println("Enter the target element");
        int target = sc.nextInt();

        // Call Linear only once and directly print its output
        System.out.println(Linear(arr, target));

    }

    public static String Linear(int arr[], int target) {
        // Iterate through the entire array (fix potential missed element)
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return "Element found at index " + i;
            }
        }
        return "Element Not found";
    }

}
