package Books;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class BooksController {

    private IBooksStore booksStore;

    public BooksController(){
        booksStore = new BooksStore();
    }

    @GetMapping("/all")
    public Iterable<Book> getAllBook() {
        return booksStore.getAllBooks();
    }

    /*@GetMapping("/add")
    public void add(Book book) {
        model.addAttribute("contact", new Contact());
        return "form";
    }*/

    @GetMapping("/books/{name}")
    public Book getBook(@PathVariable String name){
        return booksStore.getBook(name);
    }

    @GetMapping("/books/{name}/delete")
    public void delete(@PathVariable String name, RedirectAttributes redirect) {
        booksStore.deleteBook(name);
    }
}
