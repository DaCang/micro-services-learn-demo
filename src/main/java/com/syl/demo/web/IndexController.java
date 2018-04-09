package com.syl.demo.web;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.syl.demo.model.Category;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


@Controller
public class IndexController {

    private static final long serialVersionUID = 1L;

    protected Logger logger = Logger.getLogger(IndexController.class);

 /**
   * @Title: 
   * @Description: （这里用一句话描述这个方法的作用）
   * @param null
   * @return 
   * @author 宋永利
   * @date 2018/4/9
   * @throws
  */
    @RequestMapping(value = "/category/{id}",method = {RequestMethod.GET, RequestMethod.POST})
    public String   getCategoryByName(@PathVariable Long id, HttpServletResponse response, HttpServletRequest request, Model model ) throws IOException{
        Category category = new Category();
        category.withName("动物");
        category.withId(id);
        category.withDescription("动物是多细胞真核生命体中的一大类群，统称为动物界");
        category.withWhenCreated(new Date());
        model.addAttribute("category", category);

        String jsonStr =JSON.toJSONString(category,SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.PrettyFormat,
                SerializerFeature.SortField);
        System.out.println(jsonStr);
        return "category";
    }

        @RequestMapping(value="/greeting/{name}", method= RequestMethod.GET)
        public String greeting(@PathVariable("name") String name, Model model) {
            System.out.println(name);
            model.addAttribute("name", name);
            return "greeting";
        }

}
