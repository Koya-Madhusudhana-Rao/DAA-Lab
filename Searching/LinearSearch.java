import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 10 };
        int target = sc.nextInt();
        int result = Linear(arr, target);
        System.out.println(result);

        if (result != 1) {
            System.out.println("Element found at index " + result);
        } else {
            System.out.println("Element Not found");
        }
        // Linear(arr, item);
    }

    public static int Linear(int arr[], int target) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == target) {
                return i;

            }
        }

        return 1;
    }

}