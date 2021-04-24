package com.samsung.tree;

import java.util.concurrent.BlockingQueue;

public class BinaryTree {


  static final int COUNT = 15;

  public void convertStramToBinaryTree(BlockingQueue<Integer> queue) {
    Node root = null;
    while (!queue.isEmpty()) {
      root = insert(root, queue.poll());
    }

    printPrettyTree(root, 0);
  }

  static void printPrettyTree(Node root, int space) {
    if (root == null)
      return;

    // Increase distance between levels
    space += COUNT;

    // Process right child first
    printPrettyTree(root.right, space);

    // Print current node after space
    System.out.print("\n");
    for (int i = COUNT; i < space; i++)
      System.out.print(" ");
    System.out.print(root.data + "\n");

    // Process left child
    printPrettyTree(root.left, space);

  }

  private Node insert(Node root, Integer data) {
    if (root == null)
      return new Node(data);

    if (data < root.data)
      root.left = insert(root.left, data);
    else if (data > root.data)
      root.right = insert(root.right, data);

    return root;
  }

}
