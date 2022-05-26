import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by devin on 2022-05-26.
 */
public class ContainerServiceTest {

    @Test
    public void bookRepository_인스턴스_확인() {
        BookRepository bookRepository = ContainerService.getObject(BookRepository.class);
        assertNotNull(bookRepository);
    }


    @Test
    public void bookService_인스턴스_확인() {
        BookService bookService = ContainerService.getObject(BookService.class);
        assertNotNull(bookService);
        assertNotNull(bookService.bookRepository);
    }

}
