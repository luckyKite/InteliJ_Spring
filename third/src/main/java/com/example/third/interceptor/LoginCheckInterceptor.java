package com.example.third.interceptor;

import com.example.third.controller.session.SessionConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
  //로그인 실패하면 더이상 진행하지 않고 종료, pre(o)/post(x)/afterCompletion(x)


  @Override
  public boolean preHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler) throws Exception {
    String requestUrl = request.getRequestURI();
    String uuid = UUID.randomUUID().toString();
    HttpSession session = request.getSession(false);

    if(session != null && session.getAttribute(SessionConst.NAME) != null) {
      log.info("(loginCheck-preHandle) : {} , [ {} ], {} ", requestUrl, uuid,session.getAttribute(SessionConst.NAME));
      return true; //로그인 성공하면 다음 컨트롤러로 넘김
    }

    log.error("(loginCheck) 미인증 사용자에 의한 요청");

    //로그인 화면으로 보내기 위함(현재 화면으로 redirect 시켜주기 위해 요청 url을 같이 전송해줌
    response.sendRedirect("/login?redirectURL=" + requestUrl);

    return false; //로그인 실패하면 로그인화면으로 보낸 후 종료
  }
}
