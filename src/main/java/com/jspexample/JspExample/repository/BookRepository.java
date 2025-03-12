package com.jspexample.JspExample.repository;

import com.jspexample.JspExample.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Integer> {

    @Query("SELECT b FROM BookEntity b WHERE " +
            "(:title IS NULL OR b.title LIKE %:title%) AND " +
            "(:author IS NULL OR b.author LIKE %:author%) AND " +
            "(:priceMin IS NULL OR b.price >= :priceMin) AND " +
            "(:priceMax IS NULL OR b.price <= :priceMax) AND " +
            "(:stock IS NULL OR b.stock >= :stock)")
    List<BookEntity> findBooksByAdvancedSearch(@Param("title") String title,
                                         @Param("author") String author,
                                         @Param("priceMin") Double priceMin,
                                         @Param("priceMax") Double priceMax,
                                         @Param("stock") Integer stock);

}
