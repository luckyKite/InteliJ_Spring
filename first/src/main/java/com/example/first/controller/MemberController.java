package com.example.first.controller;

import com.example.first.domain.Member;
import com.example.first.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MemberController {
  private final MemberService memberService = new MemberService();

  @GetMapping("/member/home")
  public String home() {
    return "member/home";
  }

  @GetMapping("/member/new")
  public String newMember() {
    return "member/newMember";
  }

  @PostMapping("/member/new")
  public String newMember(MemberForm memberForm) {
    Member member = new Member();
    member.setName(memberForm.getName());
    System.out.println(memberService.join(member)+ "번 사용자 가입완료!");
    return "redirect:/member/home";
  }

//  @GetMapping("/members")
//  @ResponseBody
//  public List memberList(Model model) {
//    List<Member> members = memberService.memberList();
//    model.addAttribute("members", members);
//    return members;
//  }

  @GetMapping("/members") //controller 와 view 사이에 전달 해 주는 것은 model 이고, 호출하는 url 주소
  public String memberList(Model model) {
    List<Member> members = memberService.memberList();
    model.addAttribute("members", members);
    return "member/memberlist"; //member 폴더의 memberlist.jsp를 불러와라
  }

}