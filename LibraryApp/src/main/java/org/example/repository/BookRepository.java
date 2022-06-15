package org.example.repository;

import org.example.app.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("select b from Book b where b.category.id = :id")
    List<Book> findByCategoryJpql(@Param("b")  Long id);


}
