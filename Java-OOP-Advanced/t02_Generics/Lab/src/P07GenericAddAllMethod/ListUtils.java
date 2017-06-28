package P07GenericAddAllMethod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListUtils{

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List must not be empty!");
        }

        T min = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (min.compareTo(list.get(i)) > 0) {
                min = list.get(i);
            }
        }

        return min;
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List must not be empty!");
        }

        T max = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (max.compareTo(list.get(i)) < 0) {
                max = list.get(i);
            }
        }

        return max;
    }

    public static List<Integer> getNullIndices(List<?> list){
        List<Integer> nullInd=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)==null){
                nullInd.add(i);
            }
        }

        return nullInd;
    }

    public static<T> void flatten(List<? super T> destination, List<List<? extends T>> source){
        for (List<? extends T> objects : source) {

            destination.addAll(objects);
        }
    }

    public static<T> void addAll(List<? super T> destination,List<? extends T> source){
        for (T t : source) {
            destination.add(t);
        }
    }
}
