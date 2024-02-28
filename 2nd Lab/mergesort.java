public class mergesort {
    public static void main(String[] args) {
        int arr[] = { 2, 5, 1, 3, 4, 7, 8, 9, 6 };

        // Before Sorting of Array
        System.out.println("Befor Sorting");
        for (int n : arr) {
            System.out.print(n + " ");
        }
        // performing Merge sort
        mergesort(arr, 0, arr.length - 1);

        System.out.println("");

        System.out.println("After Sorting");
        for (int n : arr) {
            System.out.print(n + " ");
        }

    }

    // Method for dividing array
    public static void mergesort(int[] arr, int l, int r)

    {
        if (l < r) {
            int mid = (l + r) / 2;
            mergesort(arr, l, mid);
            mergesort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }
    // Actually merging elements

    public static void merge(int[] arr, int l, int m, int r)

    {
        int n1 = m + 1 - l;
        int n2 = r - m;
        int[] larr = new int[n1];
        int[] rarr = new int[n2];

        for (int x = 0; x < n1; x++) {
            larr[x] = arr[l + x];
        }
        for (int x = 0; x < n2; x++) {
            rarr[x] = arr[m + 1 + x];
        }

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (larr[i] <= rarr[j]) {
                arr[k] = larr[i];
                i++;
            } else {
                arr[k] = rarr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = larr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rarr[j];
            j++;
            k++;
        }
    }

}
