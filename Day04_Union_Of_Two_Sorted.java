import java.util.ArrayList;

class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        int n = a.length;
        int m = b.length;
        int i = 0, j = 0;
        ArrayList<Integer> union = new ArrayList<>();

        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                if (union.size() == 0 || union.get(union.size() - 1)!= a[i]) {
                    union.add(a[i]);
                }
                i++;
            } else {
                if (union.size() == 0 || union.get(union.size() - 1)!= b[j]) {
                    union.add(b[j]);
                }
                j++;
            }
        }

        // Baki elements add koro
        while (i < n) {
            if (union.get(union.size() - 1)!= a[i]) {
                union.add(a[i]);
            }
            i++;
        }
        while (j < m) {
            if (union.get(union.size() - 1)!= b[j]) {
                union.add(b[j]);
            }
            j++;
        }
        return union;
    }
}

// Time: O(n+m)
// Approach: Two Pointer - Striver A-Z Sheet
