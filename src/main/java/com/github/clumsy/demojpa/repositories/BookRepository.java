package com.github.clumsy.demojpa.repositories;

import com.github.clumsy.demojpa.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book,Id> {

    @Query("SELECT b.name, b.author from Book b")
    List<Object[]> findBooks();
}
