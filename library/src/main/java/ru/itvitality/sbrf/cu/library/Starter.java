package ru.itvitality.sbrf.cu.library;

import ru.itvitality.sbrf.cu.library.dao.BookDao;
import ru.itvitality.sbrf.cu.library.dao.ClientDao;
import ru.itvitality.sbrf.cu.library.dao.impl.BookDaoImpl;
import ru.itvitality.sbrf.cu.library.dao.impl.ClientDaoImpl;
import ru.itvitality.sbrf.cu.library.entities.Book;
import ru.itvitality.sbrf.cu.library.entities.Client;
import java.sql.SQLException;
import static ru.itvitality.sbrf.cu.library.dao.utils.EntityConnectionDbH2.connectionDbH2;

public class Starter {

    public static BookDao bookDao;

    /*@Autowired
    public static BookRepo bookRepo;*/

    public static void main( String args[] ) throws SQLException, ClassNotFoundException {

        bookDao = new BookDaoImpl();
        ClientDao clientDao = new ClientDaoImpl();

        Client client = new Client();
        client.setName( "Test1" );
        client.setPhone( "1234" );
        clientDao.insert( client );

        client = new Client();
        client.setName( "test2" );
        client.setPhone( "1235" );
        clientDao.insert( client );

        //Теперь новый класс букЭнтити
        //BookEntity bookEntity = new BookEntity("isbn_rq_2", "автор", "Автор", 7);
        //bookRepo.save(bookEntity);

        Book book = new Book();
        book.setAuthor("Stiven King");
        book.setDeleted(0);
        book.setId(100500L);//Id не работает у меня
        book.setIsbn("978-5-17-123456-8");
        book.setName("...It...");
        connectionDbH2();//Создается всегда. Не стал много времени тратить на написание условий создания базы даных, так как Spring все разруливает сам.
        bookDao.add(book);
        System.out.println(bookDao.list());
        bookDao.remove(100500L);

        clientDao.list().forEach( c -> System.out.println( c ) );
    }
}
