package pl.coderslab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Book;
import pl.coderslab.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void add(Book book) {
        bookRepository.save(book);

    }

    @Override
    public Optional<Book> findBook(Long id) {
//        return Optional.empty();
        return bookRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);

    }

    @Override
    public void update(Book book) {
        bookRepository.save(book);

    }
}
