package com.oocl.grow.service;

import com.oocl.grow.dto.ObjectSortedDto;
import com.oocl.grow.model.Object;

import java.util.List;

public interface ObjectService {
    List<ObjectSortedDto> findAllObjects();
    void createObject(Object object);
    Object findById(Long id);
    void deleteById(Long id);
    void updateObject(Object object);
}
