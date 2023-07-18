package com.example.demo.controller;

import com.example.demo.entity.Test;
import com.example.demo.form.TestForm;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    TestService service;

    @ModelAttribute
    public TestForm setUpForm(){
        TestForm form = new TestForm();
        //라디오 버튼의 초깃값 설정
        form.setAnswer(true);
        return form;
    }

    //Test 목록 표시
    @GetMapping
    private String showList(TestForm testForm, Model model){
        //신규 등록 설정

        Iterable<Test> list = service.selectAll();
        //표시용 Model에 저장
        model.addAttribute("list",list);
        model.addAttribute("title","등록 폼");
        return "crud";
    }





}
