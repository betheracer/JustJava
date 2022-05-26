import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * Created by devin on 2022-05-26.
 */

@Retention(RetentionPolicy.RUNTIME)
@interface Inject {

}


class BookRepository {
    public BookRepository() {
    }
}


class BookService {
    @Inject
    BookRepository bookRepository;

    public BookService() {

    }
}



class ContainerService {

    public static<T> T getObject(Class<T> classType) {
        return createInstance(classType);
    }

    private static <T> T createInstance(Class<T> classType) {
        try {
            return classType.getConstructor(null).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}



public class Exam01 {}





