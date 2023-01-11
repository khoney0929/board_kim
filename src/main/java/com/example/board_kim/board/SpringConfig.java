package com.example.board_kim.board;

import com.example.board_kim.board.repository.MemberRepository;
import com.example.board_kim.board.repository.MemoryMemberRepository;
import com.example.board_kim.board.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }



}
