package com.example.demo.form;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestForm {//testForm
    private Integer id;
    @NotBlank
    private String question;

    private Boolean answer;

    @NotBlank
    private String author;
    //등록 또는 변경을 판단하기 위해
    private Boolean newTest;
}
