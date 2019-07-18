package com.oocl.grow.service;

import com.oocl.grow.common.CommonUtils;
import com.oocl.grow.dto.ObjectSortedDto;
import com.oocl.grow.model.Object;
import com.oocl.grow.repository.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObjectServiceImpl implements ObjectService {
    @Autowired
    private ObjectRepository repository;
    @Override
    public List<ObjectSortedDto> findAllObjects() {
        LocalDateTime nowTime = LocalDateTime.now();
        List<Object> objectList = repository.findAll().stream()
                .filter(a -> nowTime.isAfter(CommonUtils.formatStringToLocalTime(a.getBeginDate()))&&nowTime.isBefore(CommonUtils.formatStringToLocalTime(a.getEndDate())))
                .sorted((o1,o2) -> (int) ( Duration.between(CommonUtils.formatStringToLocalTime(o1.getBeginDate()),CommonUtils.formatStringToLocalTime(o1.getEndDate())).toDays()- Duration.between(CommonUtils.formatStringToLocalTime(o2.getBeginDate()),CommonUtils.formatStringToLocalTime(o2.getEndDate())).toDays()))
                .collect(Collectors.toList());
        List<ObjectSortedDto> objectSortedDtos = new ArrayList<>();
        for(Object object : objectList){
            ObjectSortedDto objectSortedDto = new ObjectSortedDto();
            objectSortedDto.setId(object.getId());
            objectSortedDto.setBeginDate(CommonUtils.formatLocalDateTime(object.getBeginDate()));
            objectSortedDto.setEndDate(CommonUtils.formatLocalDateTime(object.getEndDate()));
            objectSortedDto.setDescription(object.getDescription());
            objectSortedDto.setRestDays((int)Duration.between(CommonUtils.formatStringToLocalTime(object.getBeginDate()),CommonUtils.formatStringToLocalTime(object.getEndDate())).toDays());
            objectSortedDto.setImgUrl(object.getImgsPath().split("@")[0]);
            objectSortedDtos.add(objectSortedDto);
        }
        return objectSortedDtos;
    }


    @Override
    public void createObject(Object object) {
         repository.save(object);
    }

    @Override
    public Object findById(Long id) {
        Object object =  repository.findById(id);
        object.setBeginDate(CommonUtils.formatLocalDateTimeToCn(object.getBeginDate()));
        object.setEndDate(CommonUtils.formatLocalDateTimeToCn(object.getEndDate()));
        return object;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void updateObject(Object object) {
        object.setBeginDate(CommonUtils.formatCNToLocalTime(object.getBeginDate()));
        object.setEndDate(CommonUtils.formatCNToLocalTime(object.getEndDate()));
        repository.saveAndFlush(object);
    }
}
