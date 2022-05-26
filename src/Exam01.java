import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.junit
/**
 * Created by devin on 2022-05-26.
 */

@Retention(RetentionPolicy.RUNTIME)
@interface Inject {

}


class BookRepository {

}


class BookService {
    @Inject
    BookRepository bookRepository;
}



class ContainerService {
    public static<T> T getObject(Class<T> classType) {
        return null;
    }
}


@Test
public class Exam01 {

    public static void main(String[] args) {

        BookRepository bookRepository = ContainerService.getObject(BookRepository.class);
        assertNotNull
    }


}





