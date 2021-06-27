package Books;

import java.util.*;

public class BooksStore implements IBooksStore{
    private Map<String, Book> bookMap = new HashMap<>();

    public BooksStore(){
        //dummy data
        bookMap.put("Book_1", new Book("Book 1", "This is book 1", "Author 1", new Date()));
        bookMap.put("Book_2", new Book("Book 2", "This is book 2", "Author 2", new Date()));
        bookMap.put("Book_3", new Book("Book 3", "This is book 3", "Author 3", new Date()));
    }

    @Override
    public Iterable<Book> getAllBooks(){
        List<Book> allBooks = new LinkedList<>();
        for (Map.Entry<String, Book> book : bookMap.entrySet()) {
            allBooks.add(book.getValue());
        }
        return allBooks;
    }

    @Override
    public Book getBook(String name) {
        return bookMap.get(name);
    }

    @Override
    public void addBook(Book book) {
        bookMap.put(book.getName(), book);
    }

    @Override
    public void deleteBook(String name){
        bookMap.remove(name);
    }
}