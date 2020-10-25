package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Type;

import javax.persistence.EnumType;
import java.util.List;



public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAll();

    List<Type> findByType(@Param("type") String type);

//    @Query(nativeQuery = true,
//            value = "SELECT * FROM Books WHERE author LIKE %:name%")
//
//    List<Book> findByAuthorName(@Param("name") String name);
    //    metodę wyszukującą książki dla zadanego tytułu.
//    List<Book> findAllByTitle(String title);
//
//    Optional<Book> findById(Long Id);
//


//    Type findById(EnumType valueOf);

//    List<Book> findByAuthor(String author);
//
//    List<Book> findByTitle(String title);

//    @Query("SELECT b FROM Books b where b.id like ?1")
//    Optional<Book> findBookById(Long Id);


}