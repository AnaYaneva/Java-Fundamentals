package P03;

import java.util.List;

public class Box<T> {

    private T type;

    public Box(T type) {
        this.type = type;
    }

    public static <T> void swap(List<T> list, int indexStart,int indexFin){
        T element=list.get(indexStart);

        list.add(indexStart,list.get(indexFin));
        list.remove(indexStart+1);
        list.remove(indexFin);
        list.add(indexFin,element);
    }

    @Override
    public String toString() {
        return this.type.getClass().getTypeName()+": "+this.type.toString();
    }
}
