package fi.haagahelia.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;



import fi.haagahelia.course.domain.Category;
import fi.haagahelia.course.domain.CategoryRepository;
import fi.haagahelia.course.domain.Book;
import fi.haagahelia.course.domain.BookRepository;

@SpringBootApplication
public class BookListApplication {
	private static final Logger log = LoggerFactory.getLogger(BookListApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookListApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a couple of books");
			crepository.save(new Category("Fiction"));
			crepository.save(new Category("History")); 
			crepository.save(new Category("Thriller")); 
			
			
			
			brepository.save(new Book("name of the rose", "eco", (long) 155, crepository.findByName("Fiction").get(0)));
			brepository.save(new Book("animal farm", "orwell", (long) 55, crepository.findByName("History").get(0)));	
			
			log.info("fetch all books"); 
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			} 
		};
	}
}
