package com.seavus.members;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {
    MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/{id}")
    public Member getMember(@PathVariable Long id){
        return memberService.getMember(id);
    }

    @PostMapping
    public void createMember(@RequestBody Member member){
        memberService.createMember(member);
    }

    @GetMapping
    public List<Member> findAll (){
        return memberService.findAll();
    }
}
