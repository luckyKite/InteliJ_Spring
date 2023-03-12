package com.example.third.controller;

import com.example.third.controller.session.CookieConst;
import com.example.third.controller.session.MemberSession;
import com.example.third.controller.session.SessionConst;
import com.example.third.domain.Member;
import com.example.third.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class LoginController {

  MemberService memberService;

  @Autowired
  public LoginController(MemberService memberService) {
    this.memberService = memberService;
  }

  @GetMapping("/login")
  public String memberLogin(Model model) {
    Member member = new Member();
    model.addAttribute("member", member);
    return "login";
  }

  @PostMapping("/login")
  public String login(
    @ModelAttribute Member member,
    RedirectAttributes redirectAttributes,
    HttpServletRequest request,
    @RequestParam(defaultValue = "/") String redirectURL
    /* HttpServletResponse response */) {
    String loginId = member.getLoginId();
    Optional<Member> findMember = memberService.findMember(loginId); //member가 존재해야 함! member.password가 화면에서 입력한 password와 일치해야 함.

    if(!findMember.isEmpty() && findMember.get().getPassword().equals(member.getPassword())) {
      Member loginMember = findMember.get();

      MemberSession memberSession = new MemberSession();
      memberSession.setId(loginMember.getId());
      memberSession.setLoginId(loginMember.getLoginId());
      memberSession.setName(loginMember.getName());

      HttpSession session = request.getSession(true);//true : 세션이 없으면 만들어주고, 있으면 있는 세션을 반환한다.
      session.setAttribute(SessionConst.NAME, memberSession);

      //쿠키로 할 때는 매개변수로 HttpServletResponse 를 넣어준다.
//      Cookie cookie = new Cookie(CookieConst.NAME, String.valueOf(findMember.get().getId()));
//      response.addCookie(memberId);

      //미인증 사용자가 로그인 성공한 후에 최초 요청한 페이지로 돌려보내기 위함
      return "redirect:" + redirectURL;
    } else {
      redirectAttributes.addFlashAttribute("message", "로그인 실패! ");
      return "redirect:/login";
    }
  }

  @PostMapping("/logout")
  public String logout(
    //HttpServletResponse response
    HttpServletRequest request) {
    HttpSession session = request.getSession(false); //있으면 있는 것 반환, 없으면 null 반환

    if(session != null) {
      session.invalidate();
    }
    return "redirect:/";

    //쿠키로 할때
//    Cookie cookie = new Cookie(CookieConst.NAME, null);
//    cookie.setMaxAge(0);
//    response.addCookie(cookie);
//    return "redirect:/";
  }
}
