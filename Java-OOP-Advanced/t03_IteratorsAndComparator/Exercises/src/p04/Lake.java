package p04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake<T> implements Iterable<T> {

    private List<T> lake;

    public Lake() {
        this.lake = new ArrayList<T>();
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private final class LakeIterator implements Iterator<T>{

        private int index=-2;
        private int count;

        private int getIndex(){
            int currentInd=this.index+2;
            if (currentInd>=lake.size()){
                this.index=1;
            }else{
                this.index+=2;
            }
            this.count++;
            return this.index;
        }

        @Override
        public boolean hasNext() {
            return this.index<lake.size();
        }

        @Override
        public T next() {
            return null;
        }
    }
}
