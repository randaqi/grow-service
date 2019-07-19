package com.oocl.grow.service;

import com.oocl.grow.common.CommonUtils;
import com.oocl.grow.dto.ObjectSortedDto;
import com.oocl.grow.model.Object;
import com.oocl.grow.repository.ObjectRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author MIAOOY2
 */
@Service
public class ObjectServiceImpl implements ObjectService {
    private final ObjectRepository repository;

    @Autowired
    public ObjectServiceImpl(ObjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ObjectSortedDto> findAllObjects() {
        LocalDateTime nowTime = LocalDateTime.now();
        List<Object> objectList = repository.findAll().stream()
                .filter(a -> nowTime.isAfter(CommonUtils.formatStringToLocalTime(a.getBeginDate()))&&nowTime.isBefore(CommonUtils.formatStringToLocalTime(a.getEndDate())))
                .sorted((o1,o2) -> (int) ( Duration.between(nowTime,CommonUtils.formatStringToLocalTime(o1.getEndDate())).toDays()- Duration.between(nowTime,CommonUtils.formatStringToLocalTime(o2.getEndDate())).toDays()))
                .collect(Collectors.toList());
        List<ObjectSortedDto> objectSortedDtos = new ArrayList<>();
        for(Object object : objectList){
            ObjectSortedDto objectSortedDto = new ObjectSortedDto();
            BeanUtils.copyProperties(object, objectSortedDto);
            objectSortedDto.setBeginDate(CommonUtils.formatLocalDateTime(object.getBeginDate()));
            objectSortedDto.setEndDate(CommonUtils.formatLocalDateTime(object.getEndDate()));
            objectSortedDto.setRestDays(CommonUtils.restDays(LocalDateTime.now(),CommonUtils.formatStringToLocalTime(object.getEndDate())));
//            objectSortedDto.setImgUrl(object.getImgsPath().split("@")[0]);
            objectSortedDtos.add(objectSortedDto);
        }
        return objectSortedDtos;
    }


    @Override
    public void createObject(Object object) {
        object.setImgsPath("imgs/3.jpg");
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
    @Transactional(rollbackFor = Exception.class)
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
