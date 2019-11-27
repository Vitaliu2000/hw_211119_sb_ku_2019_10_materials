package ru.itvitality.sbrf.cu.library.repo;

import org.springframework.data.repository.CrudRepository;
import ru.itvitality.sbrf.cu.library.entities.BookEntity;

//Замена BookDao и BookDaoImpl
public interface BookRepo extends CrudRepository<BookEntity, Long> {
}
