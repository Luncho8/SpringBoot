package com.luncho.demo.chapter02;

import org.springframework.stereotype.Component;

@Component //어노테이션을 클래스에 부여한다
public class EveningGreet implements Greet{
    @Override
    public void greeting() {
        System.out.println("--------------");
        System.out.println("좋은 저녘입니다.");
        System.out.println("--------------");
    }
}
