package com.example.test.controller;

import com.example.test.entity.Test;
import com.example.test.form.TestForm;
import com.example.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    TestService service;

    @ModelAttribute
    public TestForm setUpForm(){
        TestForm form = new TestForm();
        form.setAnswer(true); // 라디오 버튼 부분임 (아직없음)
        return form;
    }
    //Test 목록 표시
    @GetMapping
    private String showList (TestForm testForm, Model model){
        //신규 등록 설정
        testForm.setNewTest(true);
        //신규 등록 설정
        Iterable<Test> list = service.selectAll();
        //표시용 Model에 저장
        model.addAttribute("list",list);
        model.addAttribute("title","등록 폼");
        return "crud";
    }

    @PostMapping("/insert")
    public String insert(@Validated TestForm testForm, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        //Form에서 Entity로 넣기
        Test test =new Test();
        test.setQuestion(testForm.getQuestion());
        test.setAnswer(testForm.getAnswer());
        test.setAuthor(test.getAuthor());
        //입력체크
        if(!bindingResult.hasErrors()){
            service.insertTest(test);
            redirectAttributes.addFlashAttribute("complete","등록이 완료되었습니다.");
            return "redirect:/test";
        }else{
            //에러가 발생한 경우에는 몰고 표시로 변경
            return showList(testForm, model);
        }
    }

    @GetMapping("/{id}")
    public String showUpdate(TestForm testForm, @PathVariable Integer id, Model model){
        Optional<Test> testOpt = service.selectOneById(id);

        Optional<TestForm> testFormOpt =  testOpt.map(t -> makeTestForm(t));

        if(testFormOpt.isPresent()){
            testForm = testFormOpt.get();
        }
        //변경을 위한 모델생성
        makeUpdateModel(testForm,model);
        return "crud";
    }

    /*function move (x){return y+y;} == (x) => y+y;*/
    private void makeUpdateModel(TestForm testForm, Model model){
        model.addAttribute("id",testForm.getId());
        testForm.setNewTest(false);
        model.addAttribute("testForm",testForm);
        model.addAttribute("title","변경 폼");
    }

    @PostMapping("update")
    public String update(
            @Validated TestForm testForm,
            BindingResult result,
            Model model,
            RedirectAttributes redirectAttributes){

        Test test = makeTest(testForm);

        if(!result.hasErrors()){
            service.updateTest(test);
            redirectAttributes.addFlashAttribute("complete","변경이 완료되었습니다.");
            //변경 화면 표시
            return "redirect:/test/" + test.getId();
        }else{
            //변경용 모델 생성
            makeUpdateModel(testForm,model);
            return "crud";
        }
    }

   private Test makeTest(TestForm testForm){
        Test test = new Test();
        test.setId(testForm.getId());
        test.setQuestion(testForm.getQuestion());
        test.setAnswer(testForm.getAnswer());
        test.setAuthor(testForm.getAuthor());
        return  test;
   }

   private TestForm makeTestForm(Test test){
       TestForm form = new TestForm();
       form.setQuestion(test.getQuestion());
       form.setAnswer(test.getAnswer());
       form.setId(test.getId());
       form.setAuthor(test.getAuthor());
       return form;
   }

   @PostMapping("/delete")
   public String delete(@RequestParam("id") String id, Model model, RedirectAttributes redirectAttributes){
        service.deleteTestById(Integer.parseInt(id));
        redirectAttributes.addFlashAttribute("delcomplete","삭제를 완료했습니다.");
        return "redirect:/test";
   }
    @GetMapping("/play")
    public String showTest(TestForm testForm, Model model){
        Optional<Test> testOpt = service.selectOneRandomTest();
        if(testOpt.isPresent()){
            Optional<TestForm> testFormOpt = testOpt.map(t -> makeTestForm(t));
            testForm = testFormOpt.get();
        }else{
            model.addAttribute("msg","등록된 문제가 없습니다.");
            return "play";
        }
        model.addAttribute("testForm",testForm);

        return "play";
    }

    @PostMapping("/check")
    public String checkTest(TestForm testForm,@RequestParam Boolean answer, Model model){
        if(service.checkTest(testForm.getId(),answer)){
            model.addAttribute("msg","정답입니다.");
        }else{
            model.addAttribute("msg","오답입니다.");
        }
        return "answer";
    }

}
















