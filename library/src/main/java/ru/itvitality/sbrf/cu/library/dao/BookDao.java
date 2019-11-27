package ru.itvitality.sbrf.cu.library.dao;

import ru.itvitality.sbrf.cu.library.entities.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    void add( Book book ) throws SQLException, ClassNotFoundException;

    List<Book> list();

    Book get( Long id );

    void remove( Long id );

    List<Book> getBooksOnHolder(Long holderId);
}
