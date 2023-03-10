package com.example.third.controller;

import com.example.third.domain.Member;
import com.example.third.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/members")
public class MemberController {

  MemberService memberService;

  @Autowired
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  @GetMapping("/join")
  public String memberJoin(Model model) {
    Member member = new Member();
    model.addAttribute("member", member);
    return "member/join";
  }

  @GetMapping("/join")
  public String join(@ModelAttribute Member member) {
    System.out.println("member = " + member);
    Long id = memberService.join(member);
    System.out.println(id+"번 회원가입 완료!");
    return "redirect:/members/login";
  }

  @GetMapping("/login")
  public String memberLogin(Model model) {
    Member member = new Member();
    model.addAttribute("member", member);
    return "member/login";
  }

  @PostMapping("/login")
  public String login(@ModelAttribute Member member, RedirectAttributes redirectAttributes) {
    String loginId = member.getLoginId();
    Optional<Member> findMember = memberService.findMember(loginId); //member가 존재해야 함! member.password가 화면에서 입력한 password와 일치해야 함.
    if(!findMember.isEmpty() && findMember.get().getPassword().equals(member.getPassword())) {
      return "redirect:/basic/items";
    } else {
      redirectAttributes.addFlashAttribute("message", "로그인 실패!");
      return "redirect:/members/login";
    }
  }
}
