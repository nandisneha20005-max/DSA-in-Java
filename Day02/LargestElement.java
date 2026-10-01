// Problem: Largest Element in Array
// A2Z Sheet - Step 1 Lec 2
// Pattern: Linear Traversal
// Time: O(n)

class LargestElement {
    public static int largest(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 2};
        System.out.println(largest(arr));
    }
}
