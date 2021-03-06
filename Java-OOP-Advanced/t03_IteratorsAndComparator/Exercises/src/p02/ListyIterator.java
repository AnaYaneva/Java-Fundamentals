package p02;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIterator<T> implements Iterable<T> {
    private List<T>collection;
    private int index;

    public ListyIterator(T... collection) {
        this.collection = Arrays.asList(collection);
    }

    public boolean move(){
        if (hasNext()){
            this.index++;
            return true;
        }

        return false;
    }

    public boolean hasNext(){
        return this.index<this.collection.size()-1;
    }

    public void print(){
        if (this.collection.size()>0){
            System.out.println(this.collection.get(this.index));
        }else{
            System.out.println("Invalid Operation!");
        }
    }

    public void printAll(){
        for (T t : this.collection) {
            System.out.print(t+" ");
        }
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {
        return new listiterator();
    }

    private final class listiterator implements Iterator<T>{

        private int index;

        @Override
        public boolean hasNext() {
            return this.index<collection.size();
        }

        @Override
        public T next() {
            return collection.get(index++);
        }
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        this.collection.forEach(action::accept);
    }
}
