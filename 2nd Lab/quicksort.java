//import java.util.Scanner;
public class quicksort {
    public static void main(String args[]) {

        //Scanner sc = new Scanner(System.in);

        int arr[] = { 1, 2, 3, 8, 7, 6, 4 };
        int l = 0;
        int r = arr.length;
        // Before Sorting of arrya
        System.out.println("Before sorting");
        for (int n : arr) {
            System.out.print(n + " ");
        }
        // Performing quicksort

        quicksorte(arr, 0, arr.length - 1);

        // after sorting
        System.out.println("");

        System.out.println("After sorting");
        for (int n : arr) {
            System.out.print(n + " ");
        }

    }

    // Method to qucksort recursively
    public static void quicksorte(int[] arr, int l, int r) {
        if(l < r) {
            int pi = partition(arr, l, r);

            quicksorte(arr, l, pi - 1);
            quicksorte(arr, pi + 1, r);

        }

    }

    // method for finding pivot element and swaping with left most element if it was
    // low
    public static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = (l - 1);

        for (int j = l; j <= r - 1; j++) {

            // If current element is smaller than the pivot
            if (arr[j] < pivot) {

                // Increment index of smaller element
                i++;
                swap(arr, i, j);
            }

        }
        swap(arr, i + 1, r);
        return (i + 1);
    }

    // Performing swaping

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

}
