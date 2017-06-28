import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Library<Book> implements Iterable<Book>{
    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return null;
    }

    private class LibIterator implements Iterator<Book>{
        private int index=0;

        @Override
        public boolean hasNext() {
            return this.index<books.length;
        }

        @Override
        public Book next() {
            return books[this.index++];
        }
    }

}
