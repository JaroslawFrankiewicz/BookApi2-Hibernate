package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Book;
import pl.coderslab.services.BookService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;

    }

    @ModelAttribute("types")
    public List<String> types() {
        return Arrays.asList("SCIENCE_FICTION", "'THRILLER", "FANTASY", "HORROR", "POETRY", "ROMANCE");
    }

    @GetMapping("/all")
    public String allBooks(Model model) {
        model.addAttribute("books", bookService.getBooks());
        return "/books/all";
    }


    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("book", new Book());
        return "books/add";
    }

    @PostMapping("/add")
    public String add(@Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/add";
        }
        bookService.add(book);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/show/{id}")
    public String show(Model model, @PathVariable long id) {
        model.addAttribute("book", bookService.findBook(id).orElseThrow(EntityNotFoundException::new));
        return "books/show";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Optional<Book> book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "books/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/edit";
        }
        bookService.add(book);
        return "redirect:/admin/books/all";
    }

}

//    @GetMapping("/addBook")
//    public String addBookForm(Model model) {
//        model.addAttribute("book", new Book());
//        return "addBook";
//    }
//
//    @PostMapping("/addBook")
//    public String add(@Valid Book book, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "addBook";
//        }
//        bookService.save(book);
//        return "redirect:/admin/books";
//    }

//    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
//    public String showEditForm(@PathVariable long id, Model model) {
//        model.addAttribute("book", bookService.findBook(id));
//        return "books/edit";
//    }


//    metodę wyszukującą książki dla zadanego tytułu.
//    @RequestMapping("/getBooks")
//    public String getBookByTitle(Model model) {
//        List<Book> books = bookRepository.findAllByTitle("test4");
//        for (Book book : books) {
//            System.out.println(book.getId() + " ");
//        }
//        model.addAttribute("books", books);
//        return "getBooks";
//    }

//    @GetMapping
//    public String allBooks(Model model) {
//        List<Book> books = bookService.getBooks();
//        model.addAttribute("books", books);
//        return "books";
//    }


//    @GetMapping("/dtoByRating")
//    @ResponseBody
//    public String booksDtoByRating() {
//        List<BookDto> allByRating = bookRepository.findDtoAllByRating(1, 10);
//        return String.valueOf(allByRating.size());
//    }


//    @GetMapping("/byTitle")
//    @ResponseBody
//    public String booksByTitle2() {
//        List<Book> allByRating = bookRepository.findAllByTitle2("test4");
//        return String.valueOf(allByRating.size());
//    }

//@AllArgsConstructor
//@Controller
//public class BookController {
//    private final BookService bookService;
//
//    @RequestMapping(value = "/book/all")
//    @ResponseBody
//    public String allBooks() {
//        List<Book> books = bookService.findAll();
//        books.forEach(b -> System.out.println(b.toString()));
//        return "Ilość książek" + books.size();
//    }
//    @RequestMapping(value = "/book/add")
//    @ResponseBody
//    public String addBook() {
//        Book book = bookService.addBook();
//        return "Id dodanej książki to:" + book.getId();
//    }
//    @RequestMapping(value = "/book/get")
//    @ResponseBody
//    public String getBook() {
//        Book book = bookService.findById(1L);
//        return "Id dodanej książki to:" + book.getId();
//    }
//
//    @RequestMapping(value = "/book/all/{rating}")
//    @ResponseBody
//    public String allBooksByRating(@PathVariable int rating) {
//        List<Book> books = bookService.findAllByRating(rating);
//        books.forEach(b -> System.out.println(b.toString()));
//        return "Ilość książek" + books.size();
//    }
//
//    @RequestMapping(value = "/book/publisher/{id}")
//    @ResponseBody
//    public String allBooksWithPublisher(@PathVariable int id) {
//        List<Book> books = bookService.findAllWithPublisher(id);
//        books.forEach(b -> System.out.println(b.toString()));
//        return "Ilość książek mającyh wydawców : " + books.size();
//    }
//
//}

