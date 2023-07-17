package com.example.demo.entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data //getter, setter를 생성
@AllArgsConstructor //전체 필드에 대한 초깃값을 인수로 받는 생성자를 생성
public class Member {
    private Integer id;
    private String name;
}
