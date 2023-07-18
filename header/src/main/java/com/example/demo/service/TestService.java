package com.example.demo.service;

import com.example.demo.entity.Test;

import java.util.Optional;

public interface TestService {
    Iterable<Test> selectAll();

    //데이터를 한 건 가져오는 것
    Optional<Test> selectOneById(Integer id);

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
