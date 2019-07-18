package com.oocl.grow.repository;

import com.oocl.grow.model.Object;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author MIAOOY2
 */
public interface ObjectRepository extends JpaRepository<Object, Integer> {
    /**
     *  根据id查找object
     */
    Object findById(Long id);

    /**
     * 根据id删除
     */
    @Query("delete from Object where id = :id")
    @Modifying
    void deleteById(@Param("id") Long id);
}
