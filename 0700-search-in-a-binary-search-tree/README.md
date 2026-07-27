# 0700. Search in a Binary Search Tree

**Difficulty:** Easy
**Topics:** Tree, Binary Search Tree, Binary Tree
**Link:** [https://leetcode.com/problems/search-in-a-binary-search-tree/](https://leetcode.com/problems/search-in-a-binary-search-tree/)

## Problem

You are given the `root` of a binary search tree (BST) and an integer `val`.

Find the node in the BST that the node's value equals `val` and return the subtree rooted with that node. If such a node does not exist, return `null`.

**Example 1:**

![](https://assets.leetcode.com/uploads/2021/01/12/tree1.jpg)

```
Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]
```

**Example 2:**

![](https://assets.leetcode.com/uploads/2021/01/12/tree2.jpg)

```
Input: root = [4,2,7,1,3], val = 5
Output: []
```

**Constraints:**

- The number of nodes in the tree is in the range `[1, 5000]`.
- `1 <= Node.val <= 10^7`
- `root` is a binary search tree.
- `1 <= val <= 10^7`

## Solution

- **Language:** Java
- **Runtime:** 0 ms
- **Memory:** 47 MB

> Synced automatically from an Accepted LeetCode submission on 2026-07-27.
