package P08;

public interface CustomList<T extends Comparable<T>> {
    void add(T element);

    T remove(int index);

    boolean contains(T element);

    void swap(int indexOne, int indexTwo);

    int countGreaterThat(T element);

    T getMax();

    T getMin();

    void customSort();
}
