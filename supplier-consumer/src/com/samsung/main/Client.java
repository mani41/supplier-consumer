package com.samsung.main;

import static com.samsung.constant.ProjectConstants.QUEUE_BOUND;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import com.samsung.consumer.IntegerConsumer;
import com.samsung.supplier.IntegerProducer;

public class Client {

  public static void main(String[] args) {

    BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(QUEUE_BOUND);

    new Thread(new IntegerProducer(blockingQueue), "Supplier thread").start();

    new Thread(new IntegerConsumer(blockingQueue), "Consumer thread").start();

  }

}
