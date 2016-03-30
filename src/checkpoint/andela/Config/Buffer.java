package checkpoint.andela.config;

/**
 * Created by suadahaji.
 */
public interface Buffer<T> {
    void insert(T obj);

    T retrieve();
}
