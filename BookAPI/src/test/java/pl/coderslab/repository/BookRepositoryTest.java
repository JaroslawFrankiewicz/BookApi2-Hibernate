package pl.coderslab.repository;

import junit.framework.TestCase;
import org.hibernate.validator.constraints.ISBN;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.coderslab.entity.Book;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

//@DataJpaTest
//public class BookRepositoryTest {
//
//    @Autowired
//    private BookRepository bookRepository;
//    private String Title = "book222";
//    private String Author = "JF";
//    private String Isbn = "978-83-38-33331-1";
//    private String Publisher = "Test2";
//    private String Type = "ok";
//
//    @Before
//    public void setUp() throws Exception {
//    }
//
//    @Test
//    public void testPersistence() {
//        //given
//        Book book = new Book();
//        book.setId(1L);
//        book.setIsbn(Isbn);
//        book.setTitle(Title);
//        book.setAuthor(Author);
//        book.setPublisher(Publisher);
//        book.setType(Type);
//
//        //when
//        bookRepository.save(book);
//
//        //then
//        Assert.assertNotNull(book.getId());
//        Book book1 = bookRepository.findById(book.getId()).orElse(null);
//        Assert.assertEquals((Long) 1L, book1.getId());
//        Assert.assertEquals(Isbn, book1.getIsbn());
//        Assert.assertEquals(Title, book1.getTitle());
//        Assert.assertEquals(Author, book1.getAuthor());
//        Assert.assertEquals(Publisher, book1.getPublisher());
//        Assert.assertEquals(Type, book1.getType());
//    }
//}


