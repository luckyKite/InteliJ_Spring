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

  @GetMapping("/members")
  @ResponseBody // json 응답
  public List memberList(Model model) {
    List<Member> members = memberService.memberList();
    model.addAttribute("members", members);
    return members;
  }

}
