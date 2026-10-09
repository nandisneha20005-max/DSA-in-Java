# DSA in Java - 375 Days Challenge 🚀

Hi, I'm Sneha Nandi! This is my daily DSA practice for placement.

### 🎯 Goal
- 375 Problems in 375 Days
- Language: Java
- Started: Oct 2026
## 📅 Progress Tracker - 375 Days Challenge
| Day | Topic | Problems | Status | Link |
| :--- | :--- | :--- | :--- | :--- |
| Day 01 | Arrays - Easy | Largest Element in Array | ✅ Done | [Code](./Day01_Largest_Element.java) |
| Day 02 | Arrays - Easy | Second Largest & Second Smallest | ✅ Done | [Code](./Day02_Second_Largest_Smallest.java) |
| Day 03 | Arrays - Easy | 1. Check if Array is Sorted<br>2. Remove Duplicates (LC 26) | ✅ Done | [Code](./Day03_CheckSorted_RemoveDuplicates.java) |
| Day 04 | Arrays - Easy | 1. Move Zeros to End (LC 283)<br>2. Union of Two Sorted Arrays | ✅ Done | [Code](./Day04_MoveZeroes_283.java) |
| Day 05 | Sliding Window & Two Pointers | 1. Trapping Rain Water (LC 42)<br>2. Longest Substring Without Repeating (LC 3) | ✅ Done | [Code](./Day05_Trapping_Rainwater.java) |
| 06 | 2026-10-06 | 152 | Maximum Product Subarray | Arrays, DP | Medium | O(n) | ✅ Solved |
| 06 | 2026-10-06 | 153 | Find Minimum in Rotated Sorted Array | Binary Search | Medium | O(log n) | ✅ Solved |
| 07 | 2026-10-07 |Arrays_Medium| 3 sum problem |solved |
| 08 | Container With Most Water |Two Pointers (Greedy) |O(n) | O(1) | ✅ |
| 08 | Kth Smallest Element |Min-Heap / QuickSelect|O(n log k) | O(k) | ✅ |
| 09 | Maximum and minimum element in an Array | comparing in pairs | o(n) | ✅ solved |
| 09 | Reverse an Array |  Single Pointer | o(n) | ✅ solved |

**Total Solved: 2 (Day 06)**
**Progress: 5 / 375 Days Completed**
**Total Progress: 4 / 375 Days Completed (1.06%)**

### 📂 Structure
Each Day folder contains Java solutions with pattern notes.
### Day 01 - Largest Element in Array

#### Problem: Find the Largest Element

**Logic (Bangla te):**
Ekta variable `max` nebo, prothom e `arr[0]` diye initialize korbo.
Tarpor puro array loop korbo. Jodi `arr[i] > max` hoy, tahole `max = arr[i]` kore debo.
Sesh e `max` tai largest.

**Example:**
`arr = [2, 5, 1, 3, 0]`
max=2 -> 5>2 -> max=5 -> 1>5? No -> 3>5? No -> 0>5? No -> Ans 5

**Complexity:**
- Time: O(n)
- Space: O(1)

---

### Day 02 - Second Largest & Second Smallest

#### 1. Second Largest Element

**Logic (Bangla te):**
2 to variable lagbe: `largest` and `secondLargest`.
Prothom e `largest = arr[0]`, `secondLargest = -1` (or MIN_VALUE)

Loop chalabo:
1. Jodi `arr[i] > largest` -> mane notun largest pelam.
   Tahole ager largest ta second hoye jabe: `secondLargest = largest`, `largest = arr[i]`
2. Else if `arr[i] < largest && arr[i] > secondLargest` -> mane largest er theke choto kintu second er theke boro, so second update.

**Example:**
`arr = [1, 2, 4, 7, 5]`
largest=1, second=-1
2>1 -> second=1, largest=2
4>2 -> second=2, largest=4
7>4 -> second=4, largest=7
7>7? No, but 7<7? No -> skip (duplicate)
5<7 && 5>4 -> second=5 -> Ans 5

**Complexity:**
- Time: O(n)
- Space: O(1)

#### 2. Second Smallest Element (Bonus)

**Logic:** Same, just ulta. `smallest` track korbo, tar theke boro kintu sob theke choto ta second.

---

### Day 03 - Arrays (Easy)

#### 1. Check if Array is Sorted
**Logic:** `i=1` theke loop, check `arr[i] >= arr[i-1]`. Ekbar fail korlei `false`.
**Example:** [1,2,2,3] -> Yes sorted
**Complexity:** O(n), O(1)

#### 2. Remove Duplicates from Sorted Array (LeetCode 26)
**Logic:** Two Pointer. `i=0` unique rakhar jayga, `j=1` diye scan. `arr[j]!=arr[i]` hole `i++` kore `arr[i]=arr[j]`.
**Example:** [1,1,2,2,3] -> [1,2,3] -> return 3
**Complexity:** O(n), O(1)

## 🧠 Day 04 - What I Learned Today
- **Move Zeroes:** O(n) time, O(1) space - `j` pointer diye non-zero track kora.
- **Union:** Two pointer diye duplicate avoid kora.
- ## Day 05 - Trapping Rainwater & Longest Substring Without Repeating

### 1. Trapping Rainwater (LeetCode 42)

**Logic:** We need 2 pointers: `left = 0` and `right = n-1`. And 2 variables: `leftMax = 0` and `rightMax = 0` to track max wall. `ans = 0` for water.

Loop: `while(left <= right)`:

1. If `height[left] < height[right]` -> left side is smaller:
   a. If `height[left] >= leftMax` -> found new max wall, so `leftMax = height[left]`
   b. Else `height[left] < leftMax` -> water will be trapped, so `ans += leftMax - height[left]`
   c. `left++`

2. Else `height[left] >= height[right]` -> right side is smaller:
   a. If `height[right] >= rightMax` -> `rightMax = height[right]`
   b. Else `ans += rightMax - height[right]`
   c. `right--`

**Example:** `arr = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]`
Start `left=0, right=11, leftMax=0, rightMax=0`
`0<1 -> left small -> height[0]=0 >= leftMax(0) -> leftMax=0, left=1`
`1<1? No -> right side -> height[11]=1 >= rightMax(0) -> rightMax=1, right=10` ... continues -> Ans 6

**Complexity:**
- Time: O(n)
- Space: O(1)

### 2. Longest Substring Without Repeating Characters (LeetCode 3)

**Logic:** Sliding Window + HashSet. 2 pointers: `left = 0`, `right` will iterate. Set stores chars in current window. `maxLen = 0`

Loop: `for(right=0; right < n; right++)`:

1. If `set.contains(s.charAt(right))` -> duplicate found:
   Run while loop till duplicate removed: `set.remove(s.charAt(left))`, `left++`
2. Else no duplicate:
   `set.add(s.charAt(right))`
   `maxLen = max(maxLen, right - left + 1)`

**Example:** `s = "abcabcbb"`
`left=0, right=0, set=[]`
`r=0, 'a' not in set -> add 'a', set=[a], maxLen=1`
`r=1, 'b' not in set -> add 'b', set=[a,b], maxLen=2`
`r=2, 'c' not in set -> add 'c', set=[a,b,c], maxLen=3`
`r=3, 'a' in set? Yes -> duplicate -> remove from left: remove 'a', left=1, set=[b,c] -> now 'a' not in set -> add 'a', set=[b,c,a], maxLen=3`
... continues -> Ans 3

**Complexity:**
- Time: O(n)
- Space: O(n)
- # Day 06 - Arrays & Binary Search

Solved 2 LeetCode problems focusing on Array manipulation and Binary Search optimization.

### 📅 Date: 6th Oct 2026

## Problems Solved

### 1. LeetCode 152 - Maximum Product Subarray [Medium]
- **Approach:** Dynamic Tracking (Kadane's Variant)
- **Key Logic:** Maintain both `max` and `min` product ending at current index. When we encounter a negative number, swap max and min because negative * negative = positive.
- **Complexity:**
    - Time: `O(n)`
    - Space: `O(1)`
- **Performance:** 192/192 Tests Passed | 2ms (70.49%) | 47.02 MB (87.32%)
- **File:** `152-Maximum-Product-Subarray/Solution.java`

### 2. LeetCode 153 - Find Minimum in Rotated Sorted Array [Medium]
- **Approach:** Binary Search
- **Key Logic:** If `nums[mid] > nums[right]`, minimum lies on the right side (`left = mid + 1`). Else, it lies on the left including mid (`right = mid`).
- **Complexity:**
    - Time: `O(log n)`
    - Space: `O(1)`
- **Performance:** 0ms (100%) | Runtime Beats 100%
- **File:** `153-Min-in-Rotated-Sorted-Array/Solution.java`

## Learnings
- Handling negatives in product problems requires tracking both min and max.
- Rotated array minimum can be found without linear scan using modified binary search.
## 📅 Day 08 – DSA Practice

### Problems Solved

#### 1. Container With Most Water

* **Approach:** Two Pointer
* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(1)`
* **Key Concept:** Two Pointers, Greedy Approach

The solution uses two pointers starting from both ends of the array. At every step, the area is calculated and the pointer corresponding to the shorter height is moved inward to find a potentially larger container.

#### 2. Kth Smallest Element

* **Approach:** Quickselect
* **Average Time Complexity:** `O(n)`
* **Worst-Case Time Complexity:** `O(n²)`
* **Space Complexity:** `O(1)`
* **Key Concept:** Partitioning, Quickselect

The solution uses the Quickselect algorithm to partition the array around a pivot and searches only the relevant portion instead of completely sorting the array.

### 🧠 Key Learnings

* Practiced the **Two Pointer technique** for optimizing array problems.
* Learned how to achieve `O(n)` time for the Container With Most Water problem.
* Understood the **Quickselect algorithm** for finding the kth smallest element efficiently.
* Improved understanding of **in-place algorithms** and space optimization.

**Day 08 completed ✅**

## 📅 Day 09 – DSA Practice


### Problems Solved
#### 1. Maximum and Minimum element in an Array

* **Approach:** Compairing in pairs
* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(1)`
* **Key Concept:** Optimal Approach

#### 2.Array Reverse

* **Approach:** Single pointer
*Time Complexity:** o(n)
* **Space Complexity:** `O(1)`
* **Key Concept:** iterate over the first half and then swapping 

### 🧠 Key Learnings

* Practiced the **Single pointer technique** for optimizing array problems.
* Learned how to achieve `O(n)` time for the Mim and max element finding in an array

**Day 09 completed ✅**





---
⭐ Star this repo if you are also doing Striver Sheet!
#DSA #Java #StriverSheet #100DaysOfCode

