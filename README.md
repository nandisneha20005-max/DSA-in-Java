# DSA in Java - 375 Days Challenge 🚀

Hi, I'm Sneha Nandi! This is my daily DSA practice for placement.

### 🎯 Goal
- 375 Problems in 375 Days
- Language: Java
- Started: Oct 2026
## 📅 Progress Tracker - 375 Days Challenge

| Day | Topic | Problems | Status | Solution Link |
|---|---|---|---|---|
| Day 01 | Arrays - Easy | Largest Element in Array | ✅ Done | [Code](./Day01_LargestElement) |
| Day 02 | Arrays - Easy | Second Largest & Second Smallest | ✅ Done | [Code](./Day02_SecondLargest) |
| Day 03 | Arrays - Easy | 1. Check if Array is Sorted <br> 2. Remove Duplicates (LC 26) | ✅ Done | [Code](./Day03_CheckSorted_RemoveDuplicates) |
| Day 04 | Arrays - Easy | 1. Left Rotate Array by One <br> 2. Move Zeros to End (LC 283) | ⏳ Next | - |
| Day 05 | Arrays - Easy | 1. Linear Search <br> 2. Union of Two Sorted Arrays | ⏳ Upcoming | - |

**Total Progress: 3 / 375 Days Completed (0.8%)**

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


