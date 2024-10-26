package com.pa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pa.entity.BookDownload;

public interface BookDownloadRepo extends JpaRepository<BookDownload, Long> {
    @Query("SELECT bd FROM BookDownload bd WHERE bd.id = :id")
    Optional<BookDownload> findById(@Param("id") int id);
}
