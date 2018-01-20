package com.syl.demo;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

public class Example {

    String home(String name) {
        return name+"Hello World!";
    }
}
