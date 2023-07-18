package com.example.test.service;

import com.example.test.entity.Test;
import org.springframework.data.relational.core.sql.In;

import java.util.Optional;
//인터페이스는 변수형태, 이름만 정의
public interface TestService {
    //데이터를 전부 가져오는 것
    Iterable<Test> selectAll();

    //데이터를 한 건 가져오는 것
    Optional<Test>selectOneById(Integer id);

    //데이터를 랜덤으로 한 건 가져오는 것? =없는데 사용자 정의로 만들어야 함
    Optional<Test> selectOneRandomTest();

    //데이터의 true false 여부를 판단 얘도 사용자 정의 필요 (이게 비즈니스 로직) (사용자정의함수=비즈니스 로직)
    Boolean checkTest(Integer id, Boolean myAnswer);

    //퀴즈등록
    void insertTest(Test test);
    //퀴즈 변경
    void updateTest(Test test);
    //퀴즈 삭제
    void deleteTestById(Integer id);

}
