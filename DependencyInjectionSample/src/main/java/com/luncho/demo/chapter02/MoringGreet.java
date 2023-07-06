package com.luncho.demo.chapter02;

import org.springframework.stereotype.Component;

//인스턴스를 이용하고 싶은곳에 어노테이션을 부여한다.
//@Component
public class MoringGreet implements Greet{
    @Override
    public void greeting() { //인스턴스를  명시적으로 생성하지 않는다
        System.out.println("--------------");
        System.out.println("좋은 아침입니다.");
        System.out.println("--------------");
    }
}
