package fi.haagahelia.course;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.course.domain.Category;
import fi.haagahelia.course.domain.Book;
import fi.haagahelia.course.domain.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void findByAuthorShouldReturnBook() {
        List<Book> books = repository.findByAuthor("orwell");      
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("orwell");
    }
    
    @Test
    public void createNewBook() {
    	Book book = new Book("1984", "orwell", (long) 155, new Category("Biography"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    

}