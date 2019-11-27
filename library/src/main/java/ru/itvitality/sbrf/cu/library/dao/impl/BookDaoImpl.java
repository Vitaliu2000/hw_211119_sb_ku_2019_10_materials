package ru.itvitality.sbrf.cu.library.dao.impl;

import ru.itvitality.sbrf.cu.library.dao.BookDao;
import ru.itvitality.sbrf.cu.library.entities.Book;
import java.util.List;

import static ru.itvitality.sbrf.cu.library.dao.utils.EntityConnectionDbH2.*;
import static ru.itvitality.sbrf.cu.library.dao.utils.EntityConnectionDbH2.sqlUpdater;

public class BookDaoImpl extends AbstractDaoImpl implements BookDao {

    /**
     * Положить книгу в табл. "BOOK"
     * @param book
     */
    @Override
    public void add( Book book ) {
        String addTableBook = "" +
                "INSERT INTO BOOK (id,author,deleted,isbn,name)\n" +
                "VALUES (" + book.getId() + ", '" + book.getAuthor() + "', '"+ book.getDeleted() +"', '"+ book.getIsbn() +"', '"+ book.getName() +"');";
        sqlUpdater(addTableBook);
    }

    @Override
    public List<Book> list() {
        String selectAll = "" +
                "select * from book";
        return sqlGetList(selectAll);
    }

    @Override
    public Book get( Long id ) {
        Book book = em.find( Book.class, id );
        return book.getDeleted() == 1 ? null : book;
    }

    /**
     * Удаление из табл. BOOK книги по определенному @id
     * @param id
     */
    @Override
    public void remove( Long id ) {
        String removeTableBook = "" +
                "delete from BOOK " +
                "where id = " + id+ "";
        sqlRemove(removeTableBook);
    }

    @Override
    public List<Book> getBooksOnHolder( Long holderId ) {
        //TODO * implement
        return null;
    }
}
