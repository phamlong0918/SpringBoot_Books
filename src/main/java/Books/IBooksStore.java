package Books;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public interface IBooksStore {
    public List<Book> getAllBooks();
    public Book getBook(String name);
    public void addBook(Book book);
    public void deleteBook(String name);
}
