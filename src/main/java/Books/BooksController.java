package Books;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class BooksController {

    private IBooksStore booksStore;

    public BooksController(){
        booksStore = new BooksStore();
    }

    // all books
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return booksStore.getAllBooks();
    }

    // detail of a books
    @GetMapping("/books/{name}")
    public Book getBook(@PathVariable String name){
        return booksStore.getBook(name);
    }

    // add a new book
    @PostMapping("/books")
    void addBook(@RequestBody Book newBook) {
        booksStore.addBook(newBook);
    }

    // edit a new book
    @PutMapping("/books/{name}")
    void replaceEmployee(@RequestBody Book book, @PathVariable String name) {
        Book editBook = booksStore.getBook(name);
        editBook.setName(book.getName());
        editBook.setDescription(book.getDescription());
        editBook.setAuthor(book.getAuthor());
        editBook.setPublishDate(book.getPublishDate());
    }

    // delete a book
    @DeleteMapping("/books/{name}")
    public void delete(@PathVariable String name) {
        booksStore.deleteBook(name);
    }
}
