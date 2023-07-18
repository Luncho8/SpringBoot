package com.example.demo.repository;

import com.example.demo.entity.Test;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Test,Integer> {
    @Query("SELECT ID FROM TEST ORDER BY RANDOM() LIMIT 1") // 이건 쿼리가 인젝션 된다는 뜻
    Integer getRandomId(); // 이건 query를 실행한단 뜻
    // 이게 의존성 주입임 // 인터페이스 만들때 쿼리 부분을 생각해서 넣어줘야됨 getrandom이라는 repository 메소드가 없어서 만들었음
    //트랜잭션 ex) 송금 중 오류가 나면 되돌려 주는 것 온전히 처리 되기 전까진 처리된게 아닌것
}