package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class SpringmvcViewController {
    @Controller
    @RequestMapping("hello")
//@RequestMapping(value = { "hello", "hellospring" })
    public class HelloViewController {
        @GetMapping("view")
        //@GetMapping( value = { "view", "viewspring" })
        public String helloView() {
            return "hello";
        }

        //@GetMapping("view2")
        @GetMapping(value = {"view2", "view2spring"})
        public String morning() {
            return "morning";
        }
    }
}
