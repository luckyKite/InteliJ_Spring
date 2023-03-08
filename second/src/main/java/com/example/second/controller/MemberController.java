package com.example.second.controller;

import com.example.second.domain.Member;
import com.example.second.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member") //이걸 적어줘야 JpaRepository에서 쿼리문 쓸 때 Member 오류가 안난다.
public class MemberController {

  private final MemberService memberService;

  @Autowired
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  @GetMapping("/new")
  public String newMember() {
    return "member/new";
  }

  @PostMapping("/new")
  public String newMember(MemberForm form) { //매개변수 form이 new.html에서 입력한 name 값을 받아온다.
    Member member = new Member();
    member.setName(form.getName()); //받아온 name 값을 저장
    Long id = memberService.join(member); //멤버객체에 담은 다음 service.join으로 이동
    System.out.println(id+"번 회원 등록 완료!");
    return "redirect:/";
  }

  @GetMapping("/list")
  public String memberList(Model model) {
    model.addAttribute("members", memberService.findMembers());
    return "member/list";
  }
}
