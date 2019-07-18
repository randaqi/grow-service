package com.oocl.grow.repository;

import com.oocl.grow.model.Object;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface ObjectRepository extends JpaRepository<Object, Integer> {
    Object findById(Long id);

    @Modifying
    @Transactional
    @Query("delete from Object where id = :id")
    void deleteById(@Param("id") Long id);
}
