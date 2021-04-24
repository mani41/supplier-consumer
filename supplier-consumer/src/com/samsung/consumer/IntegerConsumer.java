package com.samsung.consumer;

import java.util.concurrent.BlockingQueue;
import com.samsung.tree.BinaryTree;

public class IntegerConsumer implements Runnable {

  private BlockingQueue<Integer> integerQueue;


  public IntegerConsumer(BlockingQueue<Integer> integerQueue) {
    super();
    this.integerQueue = integerQueue;
  }

  @Override
  public void run() {
    int i = 0;
    while (true) {
      if (!integerQueue.isEmpty()) {
        try {
          Thread.sleep(50000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        new BinaryTree().convertStramToBinaryTree(integerQueue);       
      }
    }
  }

}
