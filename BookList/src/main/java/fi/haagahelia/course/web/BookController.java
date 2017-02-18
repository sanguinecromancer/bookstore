package fi.haagahelia.course.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.course.domain.Category;
import fi.haagahelia.course.domain.CategoryRepository;
import fi.haagahelia.course.domain.Book;
import fi.haagahelia.course.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository brepository; 
	
	@Autowired
	private CategoryRepository crepository; 
	
	//show all books
    @RequestMapping(value="/booklist")
    public String bookList(Model model) {	
        model.addAttribute("books", brepository.findAll());
        return "booklist";
    }
  
    //add a new book
    @RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories", crepository.findAll());
        return "addbook";
    }     
    
    
    //save new book
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        brepository.save(book);
        return "redirect:booklist";
    }    

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	brepository.delete(bookId);
        return "redirect:../booklist";
    }     
}
