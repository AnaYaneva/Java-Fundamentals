package P06;

import java.util.List;

public class Box<T extends Comparable<T>> implements Comparable<Box<T>> {

    private T element;

    public Box(T element) {
        this.element = element;
    }

    public static <T> void swap(List<T> list, int indexStart,int indexFin){
        T element=list.get(indexStart);

        list.set(indexStart,list.get(indexFin));
        list.set(indexFin,element);
    }

    public static<T extends Comparable<T>> Integer countGreater(
            List<T> list, T forCompare ){
        int count=0;

        for (Comparable<T> t : list) {
            if( t.compareTo(forCompare)>0){
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return this.element.getClass().getTypeName()+": "+this.element.toString();
    }

    @Override
    public int compareTo(Box<T> o) {
        return this.element.compareTo(o.element);
    }
}
