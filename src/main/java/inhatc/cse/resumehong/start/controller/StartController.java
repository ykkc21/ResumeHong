package inhatc.cse.resumehong.start.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {

    @GetMapping("/")
    public String start(Model model) {

//        StartDto startDto = StartDto.builder()
//                .name("홍길동")
//                .grade(1)
//                .dept("컴퓨터시스템공학과")
//                .build();
//
//        model.addAttribute("data", startDto);

        return "temp/temp";
    }
}