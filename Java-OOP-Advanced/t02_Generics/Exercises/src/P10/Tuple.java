package P10;

public class Tuple<T,E> {
    private T item1;
    private E item2;

    public Tuple(T item1, E item2) {
        this.setItem1(item1);
        this.setItem2(item2);
    }

    public T getItem1() {
        return this.item1;
    }

    private void setItem1(T item1) {
        this.item1 = item1;
    }

    public E getItem2() {
        return this.item2;
    }

    private void setItem2(E item2) {
        this.item2 = item2;
    }

    @Override
    public String toString() {
        return this.getItem1() +
                " -> " + this.getItem2();
    }
}
