package threads.buffer;

public interface Buffer<T> {
    public void insert(T t);
    public T remove();
}
