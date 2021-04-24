package com.samsung.exception;


@SuppressWarnings("serial")
public class SupplierConsumerException extends Exception {
  /**
   * Creates a new SupplierConsumerException with the specified message and no target
   * exception.
   *
   * @param message The exception message.
   */
  public SupplierConsumerException(String message) {
    super(message);
  }


  /**
   * Creates a new SupplierConsumerException with the specified target exception and message.
   *
   * @param message The exception message.
   * @param exception The target exception.
   */
  public SupplierConsumerException(String message, Exception exception) {
    super(message, exception);
  }
}
