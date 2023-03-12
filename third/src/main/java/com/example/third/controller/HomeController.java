package com.example.third.controller;

import com.example.third.controller.session.CookieConst;
import com.example.third.controller.session.MemberSession;
import com.example.third.controller.session.SessionConst;
import com.example.third.domain.Member;
import com.example.third.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j //log 찍어보려면 필요함.
@Controller
public class HomeController {

  MemberService memberService;

  public HomeController(MemberService memberService) {
    this.memberService = memberService;
  }

  @GetMapping("/")
  public String home(
    //@CookieValue(value = CookieConst.NAME, required = false) Long memberId, Model model
    HttpServletRequest request, Model model) {
    HttpSession session = request.getSession(false); //없으면 반환, 있으면 있는 것 반환

    log.info("member id : [ {} ]", session);
    if(session == null) {
      return "home";
    } else {
      MemberSession memberSession = (MemberSession) session.getAttribute(SessionConst.NAME);
      model.addAttribute("member", memberSession);
      return "loginHome";
    }

    //쿠키를 쓸 때 코드
//    log.info("member id : [ {} ]", memberId);
//    if(memberId == null =) //로그인 안한 사용자, 로그인 하지 않은 사람은 home으로 보여져서 로그인 하게 만든다.
//      return "home";
//    Member member = memberService.findMemberById(memberId).get();
//    model.addAttribute("member", member);
//    return "loginHome"; //로그인 안한 사람은 상품관리 목록으로 이동하거나 로그아웃 하도록 한다.
  }
}
