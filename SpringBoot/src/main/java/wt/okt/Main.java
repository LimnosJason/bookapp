package wt.okt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@SpringBootApplication
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Main {

    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @GetMapping("/greet")
    public String great() {
        return "Hello World";
    }

    @GetMapping("/getbooks")
    public List<Book> getBooks() {
        return (List<Book>) bookRepository.findAll();
    }


    @PostMapping("/addbooks")
    public @ResponseBody String addNewBooks(@RequestBody List<Book> books) {

        bookRepository.saveAll(books);
        return books.size() + " books were added.";

    }

    @PostMapping (path="/addbook")
    public @ResponseBody String addNewBook(@RequestParam String title,@RequestParam String author, @RequestParam int amount, @RequestParam String imageURL) {
        Book newBook = new Book();

        newBook.setTitel(title);
        newBook.setAuteur(author);
        newBook.setaAntalExemplaren(amount);
        newBook.setAfbeeldingURL(imageURL);

        bookRepository.save(newBook);
        return title + " was added";
    }



    @PutMapping("/update/{id}")
    public String updateBook(@PathVariable int id, @RequestBody Book book) {
        Book updatedBook = bookRepository.findById(id).get();
        updatedBook.setTitel(book.getTitel());
        bookRepository.save(updatedBook);
        return updatedBook.getTitel() + " was updated";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        Book book= bookRepository.findById(id).get();
        bookRepository.delete(book);
        return id + " was deleted";
    }

}
