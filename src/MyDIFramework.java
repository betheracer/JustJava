import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;


/**
 * Created by devin on 2022-05-26.
 */

@Retention(RetentionPolicy.RUNTIME)
@interface Injectt {

}


class BookRepository {
    public BookRepository() {
    }
}


class BookService {
    @Injectt
    BookRepository bookRepository;

    public BookService() {

    }
}



class ContainerService {

    public static<T> T getObject(Class<T> classType) {
        T instance = createInstance(classType);

        Arrays.stream(classType.getDeclaredFields())
                .filter(f -> f.getAnnotation(Injectt.class) != null)
                .forEach(annotation ->{
                    Object fieldObject = createInstance(annotation.getType());
                    annotation.setAccessible(true);
                    try{
                        annotation.set(instance, fieldObject);
                    }catch (IllegalAccessException e){
                        throw new RuntimeException(e);
                    }
                });


        return instance;
    }

    private static <T> T createInstance(Class<T> classType) {
        try {
            return classType.getConstructor(null).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}



public class MyDIFramework {}





