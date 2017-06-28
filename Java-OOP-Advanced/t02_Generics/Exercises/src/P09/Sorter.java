package P09;

public class Sorter {
   public static <T extends Comparable<T>> void sort(CustomList<T> list){
        list.customSort();
   }
}
