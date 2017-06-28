package P04;

import java.util.List;

public class Box<T> {

    private T type;

    public Box(T type) {
        this.type = type;
    }

    public static <T> void swap(List<T> list, int indexStart,int indexFin){
        T element=list.get(indexStart);

        list.set(indexStart,list.get(indexFin));
        list.set(indexFin,element);
    }

    @Override
    public String toString() {
        return this.type.getClass().getTypeName()+": "+this.type.toString();
    }
}
