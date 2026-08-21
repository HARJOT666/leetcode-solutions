# 1312. Minimum Insertion Steps to Make a String Palindrome

**Difficulty:** Hard
**Topics:** String, Dynamic Programming
**Link:** [https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/](https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/)

## Problem

Given a string `s`. In one step you can insert any character at any index of the string.

Return *the minimum number of steps* to make `s` palindrome.

A **Palindrome String** is one that reads the same backward as well as forward.

**Example 1:**

```
Input: s = "zzazz"
Output: 0
Explanation: The string "zzazz" is already palindrome we do not need any insertions.
```

**Example 2:**

```
Input: s = "mbadm"
Output: 2
Explanation: String can be "mbdadbm" or "mdbabdm".
```

**Example 3:**

```
Input: s = "leetcode"
Output: 5
Explanation: Inserting 5 characters the string becomes "leetcodocteel".
```

**Constraints:**

- `1 <= s.length <= 500`
- `s` consists of lowercase English letters.

## Solution

- **Language:** Java
- **Runtime:** 29 ms
- **Memory:** 47.5 MB

> Synced automatically from an Accepted LeetCode submission on 2026-08-21.
