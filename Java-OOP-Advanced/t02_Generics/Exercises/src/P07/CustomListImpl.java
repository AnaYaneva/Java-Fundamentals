package P07;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomListImpl<T extends Comparable<T>> implements CustomList<T>, Iterable<T>{

    private List<T> list;

    public CustomListImpl() {
        this.list = new ArrayList<T>();
    }

    @Override
    public void add(T element) {
        this.list.add(element);
    }

    @Override
    public T remove(int index) {
        return this.list.remove(index);
    }

    @Override
    public boolean contains(T element) {
        return this.list.contains(element);
    }

    @Override
    public void swap(int indexOne, int indexTwo) {
        T temp=this.list.get(indexOne);
        this.list.set(indexOne, this.list.get(indexTwo));
        this.list.set(indexTwo,temp);
    }

    @Override
    public int countGreaterThat(T element) {
        int count=0;
        for (T t : this.list) {
            if (t.compareTo(element)>0){
                count++;
            }
        }
        return count;
    }

    @Override
    public T getMax() {
        T max=this.list.get(0);

        for (T t : this.list) {
            if (t.compareTo(max)>0){
                max=t;
            }
        }
        return max;
    }

    @Override
    public T getMin() {
        T min=this.list.get(0);

        for (T t : this.list) {
            if (t.compareTo(min)<0){
                min=t;
            }
        }
        return min;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index=0;

            @Override
            public boolean hasNext() {
                return list.size()>index;
            }

            @Override
            public T next() {
                return list.get(index++);
            }
        };
    }
}
