public class examp {

    static public int majorityElement_On(int[] arr) {
        int n = arr.length;
        int maj_ele = arr[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] == maj_ele) count += 1;
            else count -= 1;
            if (count == 0) {
                maj_ele = arr[i];
                count = 1;
            }
        }
        
        int check = 0;
        for (int i : arr) {
            if (i == maj_ele) {
                check += 1;
            }
        }
        if (check <= n / 2) return -1;
        return maj_ele;
    }

    static public int majorityElement_On2(int[] arr) {
        int n = arr.length;
        int count = 0;
        int maxele = -1;
        for (int i = 0; i < n; i++) {
            int curcount = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] == arr[i]) curcount += 1;
            }
            if (curcount > n / 2) {
                if (count == 1) return -1;
                count += 1;
                maxele = arr[i];
            }
        }
        return maxele;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        System.out.println(majorityElement_On(arr));
    }
}
