package com.example.demo.repository;

import com.example.demo.entity.Test;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Test, Integer> {
    @Query("SELECT id FROM test ORDER BY RANDOM() limit 1")
    Integer getRandomId();
}
