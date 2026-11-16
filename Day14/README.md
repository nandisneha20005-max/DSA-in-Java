# 🚀 Day 14 – DSA Problem Solving in Java

<p align="center">
  <img src="https://img.shields.io/badge/Day-14-orange?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Language-Java-blue?style=for-the-badge&logo=java" />
  <img src="https://img.shields.io/badge/Topic-Stack%20%7C%20Strings-green?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Focus-Problem%20Solving-purple?style=for-the-badge" />
</p>

<p align="center">
  <b>Understand the Logic → Explore Approaches → Optimize → Master DSA</b>
</p>

---

## 📌 About Day 14

Welcome to Day 14 of my **Data Structures and Algorithms in Java** learning journey!

Today's practice focuses on two important problem-solving concepts:

1. **Stack:** Understanding LIFO principles and matching opening and closing brackets.
2. **String Manipulation:** Removing consecutive duplicate characters efficiently using traversal and two-pointer techniques.

The objective is not just to write working code but to understand how different approaches solve the same problem and why optimization matters.

### 🎯 Learning Objectives

By completing these problems, you will understand:

- How a Stack works using the LIFO principle.
- How to validate balanced parentheses.
- How to use arrays as a stack.
- How to manipulate strings in Java.
- How to use StringBuilder efficiently.
- How two-pointer techniques work.
- How to analyze time and space complexity.
- How to move from brute force to optimized solutions.

---

# 📚 Problem 01 – Valid Parentheses

<p>
  <img src="https://img.shields.io/badge/Platform-LeetCode-orange?style=flat-square" />
  <img src="https://img.shields.io/badge/Problem-20-blue?style=flat-square" />
  <img src="https://img.shields.io/badge/Difficulty-Easy-green?style=flat-square" />
</p>

## 1. Problem Statement

Given a string `s` containing only the following bracket characters:

- `()`
- `{}`
- `[]`

Determine whether the given string contains valid parentheses.

A string is considered valid if:

1. Every opening bracket has a corresponding closing bracket of the same type.
2. Opening and closing brackets must follow the correct order.
3. Every closing bracket must have a corresponding opening bracket.

### Examples

| Input | Output | Explanation |
|---|---|---|
| `"()"` | `true` | Correct opening and closing |
| `"()[]{}"` | `true` | All brackets are balanced |
| `"(]"` | `false` | Different bracket types |
| `"([)]"` | `false` | Incorrect closing order |
| `"{[]}"` | `true` | Properly nested brackets |

---

## 2. Important Concept – Stack

A Stack is a linear data structure that follows the **LIFO (Last In, First Out)** principle.

This means the element inserted last will be removed first.

### Stack Operations

| Operation | Description |
|---|---|
| `push()` | Inserts an element |
| `pop()` | Removes the top element |
| `peek()` | Returns the top element |
| `isEmpty()` | Checks whether the stack is empty |

### Why do we use Stack here?

Consider:

```text
Input: "{[]}"
```

The last opening bracket is `[`, so it must be closed first.

A Stack naturally handles this requirement because it follows LIFO.

---

## 3. Approach 1 – Brute Force

### 💡 Intuition

The simplest approach is to repeatedly remove matching pairs of brackets.

For example:

```text
Input: "{[]}"

Step 1: {[]}
Step 2: {}
Step 3: ""

Output: true
```

If all matching pairs can be removed and the string becomes empty, the parentheses are valid.

Otherwise, they are invalid.

### Algorithm

1. Check whether the string contains `()`, `{}` or `[]`.
2. Remove all matching pairs.
3. Repeat the process until no matching pairs remain.
4. Check whether the string is empty.
5. If empty, return `true`; otherwise, return `false`.

### Java Implementation

```java
class Solution {
    public boolean isValid(String s) {

        while (s.contains("()") ||
               s.contains("{}") ||
               s.contains("[]")) {

            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }

        return s.isEmpty();
    }
}
```

### Complexity Analysis

- **Time Complexity:** O(n²) – Repeated scanning and creation of new strings.
- **Space Complexity:** O(n) – Intermediate strings may require additional memory.

### Limitation

Repeated string operations are inefficient for larger inputs.

We can solve this problem more efficiently using a Stack.

---

## 4. Approach 2 – Better Approach (Using Stack)

### 💡 Intuition

Instead of repeatedly removing matching brackets, we can use a Stack to keep track of opening brackets.

Whenever we encounter:

- An opening bracket → Push it into the Stack.
- A closing bracket → Check whether it matches the top element.
- If it matches → Pop the opening bracket.
- If it does not match → Return `false`.

At the end, the Stack must be empty for the string to be valid.

### Algorithm

1. Create an empty Stack.
2. Traverse the string character by character.
3. If the character is an opening bracket, push it.
4. If the character is a closing bracket:
   - Check whether the Stack is empty.
   - If empty, return `false`.
   - Otherwise, check whether the top opening bracket matches.
   - If matching, pop it.
   - Otherwise, return `false`.
5. Finally, return whether the Stack is empty.

### Java Implementation

```java
import java.util.*;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {

                stack.push(ch);

            } else {

                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.peek();

                if ((ch == ')' && top == '(') ||
                    (ch == '}' && top == '{') ||
                    (ch == ']' && top == '[')) {

                    stack.pop();

                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
```

### Dry Run

Input:

```text
s = "{[]}"
```

| Character | Operation | Stack |
|---|---|---|
| `{` | Push | `{` |
| `[` | Push | `{ [` |
| `]` | Match and pop | `{` |
| `}` | Match and pop | Empty |

Final Stack: Empty

Output:

```text
true
```

### Complexity Analysis

- **Time Complexity:** O(n) – Each character is processed once.
- **Space Complexity:** O(n) – In the worst case, all characters may be opening brackets.

### Why is this better?

Unlike brute force, we do not repeatedly modify the original string.

The Stack allows us to check bracket matching in a single traversal.

---

## 5. Approach 3 – Optimized Implementation (Character Array as Stack)

### 💡 Intuition

We can implement the Stack functionality directly using a character array.

Instead of using Java's `Stack` class, we maintain a variable called `top`.

Initially:

```java
int top = -1;
```

Here:

- `top = -1` means the Stack is empty.
- `stack[++top] = ch` pushes a character.
- `stack[top--]` removes the top element.

This avoids the additional method-call and object overhead of the `Stack` class.

### Algorithm

1. Create a character array of size `n`.
2. Initialize `top = -1`.
3. Traverse the input string.
4. Push opening brackets into the array.
5. For closing brackets, compare with the top element.
6. If matching, decrement `top`.
7. If not matching, return `false`.
8. Finally, check whether `top == -1`.

### Java Implementation

```java
class Solution {
    public boolean isValid(String s) {

        char[] stack = new char[s.length()];
        int top = -1;

        for (char ch : s.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {

                stack[++top] = ch;

            } else {

                if (top == -1) {
                    return false;
                }

                char open = stack[top];

                if ((ch == ')' && open == '(') ||
                    (ch == '}' && open == '{') ||
                    (ch == ']' && open == '[')) {

                    top--;

                } else {
                    return false;
                }
            }
        }

        return top == -1;
    }
}
```

### Complexity Analysis

- **Time Complexity:** O(n)
- **Space Complexity:** O(n)

### Why use this implementation?

- Direct array access.
- No Stack object required.
- Simple push and pop operations.
- Same asymptotic complexity as the Stack implementation.

**Important:** Both Stack approaches are O(n) in time and O(n) in space. The character-array implementation is an implementation-level optimization, not a better asymptotic algorithm.

---

## 6. Comparison of All Approaches

| Approach | Technique | Time Complexity | Space Complexity |
|---|---|---|---|
| Brute Force | Repeated replacement | O(n²) | O(n) |
| Better | Java Stack | O(n) | O(n) |
| Optimized | Character Array Stack | O(n) | O(n) |

### 🏆 Key Takeaway

The Stack approach is the standard interview solution for Valid Parentheses.

Remember:

**Whenever a problem requires matching the most recently opened element first, think about Stack.**

---

# 📚 Problem 02 – Remove Consecutive Characters

<p>
  <img src="https://img.shields.io/badge/Platform-GeeksforGeeks-2F8D46?style=flat-square" />
  <img src="https://img.shields.io/badge/Difficulty-Easy-green?style=flat-square" />
  <img src="https://img.shields.io/badge/Topic-Strings-blue?style=flat-square" />
</p>

## 1. Problem Statement

Given a string `S`, remove all consecutive duplicate characters and return the resulting string.

**Important:** Only consecutive duplicate characters should be removed.

We are not removing every repeated character in the entire string.

### Examples

| Input | Output | Explanation |
|---|---|---|
| `"aabb"` | `"ab"` | Remove consecutive duplicates |
| `"aabaa"` | `"aba"` | Keep only one character from each group |
| `"aaaa"` | `"a"` | All characters are identical |
| `"abcde"` | `"abcde"` | No consecutive duplicates |
| `"aabbccdd"` | `"abcd"` | Remove repeated adjacent characters |

---

## 2. Important Concept – String Manipulation

A String is a sequence of characters.

In Java, Strings are immutable, meaning their contents cannot be modified after creation.

For efficient string manipulation, Java provides:

```java
StringBuilder
```

It allows us to build a new string efficiently without creating a new String object for every appended character.

We will also explore the Two Pointer technique.

---

## 3. Approach 1 – Brute Force

### 💡 Intuition

We can repeatedly compare adjacent characters.

Whenever two consecutive characters are equal, remove one of them.

Continue until no consecutive duplicate characters remain.

### Algorithm

1. Start with the original string.
2. Traverse the string.
3. Compare the current character with the next character.
4. If both are equal, remove one occurrence.
5. Repeat the process.
6. Return the final string.

### Java Implementation

```java
class Solution {
    public String removeConsecutiveCharacter(String s) {

        boolean
