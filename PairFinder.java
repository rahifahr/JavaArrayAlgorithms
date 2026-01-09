public class PairFinder {

    // Method with O(n²) complexity
    public static void findPairSums(int k, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k) {
                    System.out.println(arr[i] + " + " + arr[j] + " = " + k);
                }
            }
        }
    }

    // Method with O(n log n) complexity
    public static void findPairSumsFaster(int k, int[] arr) {
        Sort.quickSort(arr);

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == k) {
                System.out.println(arr[left] + " + " + arr[right] + " = " + k);
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--; 
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 4, 7, 7, 8, 5, 15};
        int k = 12;

        System.out.println("Using findPairSums:");
        findPairSums(k, arr);

        System.out.println("\nUsing findPairSumsFaster:");
        findPairSumsFaster(k, arr);
    }
}