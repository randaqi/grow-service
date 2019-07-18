package com.oocl.grow.controller;

import com.oocl.grow.dto.ObjectSortedDto;
import com.oocl.grow.model.Object;
import com.oocl.grow.service.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/object")
public class ObjectController {
    @Autowired
    private ObjectService service;
    /**
     * 所有目标 (按剩余时间升序)
     */
    @RequestMapping(value = "objects", method = RequestMethod.GET)
    @ResponseBody
    public List<ObjectSortedDto> findAll(){
        return service.findAllObjects();
    }
    /**
     * 新增目标
     */
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public String createObject(@RequestBody Object object){
        service.createObject(object);
        return "success";
    }
    /**
     * 目标新街
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object findById(@PathVariable Long id){
        return service.findById(id);
    }
    /**
     * 删除目标
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteById(@PathVariable Long id){
        service.deleteById(id);
        return "success";
    }
    /**
     * 更新目标
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public String updateObject(@RequestBody Object object){
        service.updateObject(object);
        return "success";
    }
}
