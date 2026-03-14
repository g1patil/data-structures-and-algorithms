package ood.customdatastructures.queue;

/**
 * Contrast for simple Queue.
 * */
public interface CustomQueue<T> {
    T peek();
    T poll();
    boolean add(T val);
    boolean isEmpty();
}
