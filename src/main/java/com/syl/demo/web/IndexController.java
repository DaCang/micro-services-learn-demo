package com.syl.demo.web;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.syl.demo.model.Category;
import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@EnableAutoConfiguration
public class IndexController {

    private static final long serialVersionUID = 1L;

    protected Logger logger = Logger.getLogger(IndexController.class);


    @RequestMapping(value = "/{name}")
    public String   getCategoryByName(@PathVariable String name, HttpServletResponse response, HttpServletRequest request, Model model ) throws IOException{
        Category category = new Category();
        category.withName(name);
        category.withId(1L);
        category.withDescription("这是什么类别?"+name);

        return JSON.toJSONString(category,SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.PrettyFormat,
                SerializerFeature.SortField);


    }

}
