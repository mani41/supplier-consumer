package com.samsung.supplier;

import static com.samsung.constant.ProjectConstants.INITIAL_DELAY;
import static com.samsung.constant.ProjectConstants.TIME_PERIOD;
import static com.samsung.constant.ProjectConstants.LOWER_TIME_WINDOW;
import static com.samsung.constant.ProjectConstants.UPPER_TIME_WINDOW;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class IntegerProducer implements Runnable {

  private BlockingQueue<Integer> integerQueue;
  private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

  public IntegerProducer(BlockingQueue<Integer> integerQueue) {
    super();
    this.integerQueue = integerQueue;
  }

  @Override
  public void run() {

    try {
      generateRandomNumbers();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void generateRandomNumbers() throws InterruptedException {

    scheduler.scheduleAtFixedRate(() -> {
      try {
        addRandomeInt();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }, INITIAL_DELAY, TIME_PERIOD, TimeUnit.SECONDS);

  }

  private void addRandomeInt() throws InterruptedException {
    integerQueue.add(new Random().nextInt());
    long timePeriod = new Random().nextInt(UPPER_TIME_WINDOW - LOWER_TIME_WINDOW) + 1L;
    Thread.sleep(timePeriod * 1000);
    System.out.println("queue after " + timePeriod + " " + integerQueue);

  }

}
