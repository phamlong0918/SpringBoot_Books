package Books;

import java.util.List;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BooksController {

    @Autowired
    private BookRepository bookRepository;

    // All books
    @GetMapping("/books")
    public @ResponseBody Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Detail of a books
    @GetMapping("/books/{id}")
    public @ResponseBody Optional<Book> getBook(@PathVariable Integer id){
        return bookRepository.findById(id);
    }

    // Add a new book
    @PostMapping("/books")
    public @ResponseBody String addBook(@RequestParam String name
    , @RequestParam String description
    , @RequestParam String author
    , @RequestParam String publishDate) {
        try
        {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = dateFormat.parse(publishDate);

            Book newBook = new Book();
            newBook.setName(name);
            newBook.setDescription(description);
            newBook.setAuthor(author);
            newBook.setPublishDate(date);
            bookRepository.save(newBook);
        }
        catch (Exception e)
        {
            return e.toString();
        }

        return "Add book success!";
    }

    // Edit a new book
    @PutMapping("/books/{id}")
    public @ResponseBody String editBook(@PathVariable Integer id
            , @RequestParam String newName
            , @RequestParam String newDescription
            , @RequestParam String newAuthor
            , @RequestParam String newPublishDate) {

        try
        {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date newDate = dateFormat.parse(newPublishDate);

            bookRepository.findById(id)
                    .map(book -> {
                        book.setName(newName);
                        book.setDescription(newDescription);
                        book.setAuthor(newAuthor);
                        book.setPublishDate(newDate);
                        return bookRepository.save(book);
                    });
        }
        catch (Exception e)
        {
            return e.toString();
        }

        return "Edit success";
    }

    // Delete a book
    @DeleteMapping("/books")
    public @ResponseBody String deleteBook(@RequestParam Integer id) {
        bookRepository.deleteById(id);
        return "Delete success";
    }
}
