package com.example.test.form;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor  //기본 생성자를 생성
@AllArgsConstructor // 필드값 초기화 하는 값을 인수로 가지는 생성자 생성
public class TestForm {
    private Integer id;
    @NotBlank
    private String question;

    private Boolean answer;

    @NotBlank
    private String author;
    //등록 또는 변경을 판단할때 사용
    private Boolean newTest;

}
