package com.pa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pa.entity.Authors;

public interface AuthorRepo extends JpaRepository<Authors, Long>{
	@Query("SELECT bd FROM Authors bd WHERE bd.id = :id")
    Optional<Authors> findById(@Param("id") int id);
}
