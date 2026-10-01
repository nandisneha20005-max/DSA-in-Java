// Problem: Second Largest Element
// A2Z Sheet - Step 1 Lec 2
// Pattern: Single Pass - No Sorting

class SecondLargest {
    public static int secondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > largest) {
                second = largest;
                largest = num;
            } else if (num > second && num != largest) {
                second = num;
            }
        }
        return second;
    }
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 2};
        System.out.println(secondLargest(arr));
    }
}
