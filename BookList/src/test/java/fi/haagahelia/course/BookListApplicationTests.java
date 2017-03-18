package fi.haagahelia.course;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import fi.haagahelia.course.domain.*;
import fi.haagahelia.course.web.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookListApplicationTests {
	
	@Autowired
	private BookController controller;

	@Test
	public void contextLoads() throws Exception {
	assertThat(controller).isNotNull();
	}

}
