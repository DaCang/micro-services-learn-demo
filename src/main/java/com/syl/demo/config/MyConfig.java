package com.syl.demo.config;

import org.springframework.stereotype.Component;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Component
public class MyConfig {

    @Resource
    private void ThymeleafStaticVarsConfigure(ThymeleafViewResolver viewResolver) {
        if(viewResolver != null) {
            Map<String, Object> vars = new HashMap<>();
            vars.put("ctx", "/app/");
            vars.put("var1", "var1");
            vars.put("var2", "var2");
            viewResolver.setStaticVariables(vars);
        }
    }
}
