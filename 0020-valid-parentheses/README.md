# 0020. Valid Parentheses

**Difficulty:** Easy
**Topics:** String, Stack, Bracket Sequences
**Link:** [https://leetcode.com/problems/valid-parentheses/](https://leetcode.com/problems/valid-parentheses/)

## Problem

Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.

**Example 1:**

**Input:** s = "()"

**Output:** true

**Example 2:**

**Input:** s = "()\[\]{}"

**Output:** true

**Example 3:**

**Input:** s = "(\]"

**Output:** false

**Example 4:**

**Input:** s = "(\[\])"

**Output:** true

**Example 5:**

**Input:** s = "(\[)\]"

**Output:** false

**Constraints:**

- `1 <= s.length <= 10^4`
- `s` consists of parentheses only `'()[]{}'`.

## Solution

- **Language:** Java
- **Runtime:** 5 ms
- **Memory:** 43.5 MB

> Synced automatically from an Accepted LeetCode submission on 2026-08-26.
