package com.example.board_kim.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!");

        return "hello";
    }

    // localhost:8080/hello-mvc?name=쓰고싶은말  <- hello-template.html 파일안 타임리프 문법으로 name 변수에 쓰고싶은말이 들어감
    @GetMapping("/hello-mvc")
    public String helloMvc(@RequestParam("name") String kwak, Model model) {
        model.addAttribute("name", kwak);

        return "hello-template";
    }

    // 보여지는 화면에 return에 명시된것만 간결하게 나옴 html소스 안보임
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {

        return "hello " + name;
    }



    // JSON 방식 알아볼것
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName(){
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }



}
