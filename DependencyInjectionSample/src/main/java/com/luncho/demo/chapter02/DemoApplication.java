package com.luncho.demo.chapter02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //스프링부트를 실행하자 마자 이 어노테이션이 붙은 곳을 실행
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args)
                .getBean(DemoApplication.class).execute();
    }

    @Autowired //스프링 프레임워크에서 인스턴스를 생성한다.
    Greet greet;

    private void execute(){
        greet.greeting();
    }
}
