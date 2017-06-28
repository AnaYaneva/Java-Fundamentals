package P08;

import java.util.Comparator;

public class Sorter {
   public static <T extends Comparable<T>> void sort(CustomList<T>list){
        list.customSort();
   }
}
