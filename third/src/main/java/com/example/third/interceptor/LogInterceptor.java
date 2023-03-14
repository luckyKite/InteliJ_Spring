package com.example.third.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler) throws Exception {
    String requestUrl = request.getRequestURI();
    String uuid = UUID.randomUUID().toString();
    request.setAttribute("uuid", uuid); //각 요청별로 pre, post, after 단계를 거치기 때문에 동일한 요청을 세곳에서 접근

    log.info("(preHandle) requestUrl, UUID, handler : {}, [ {} ], {} " , requestUrl, uuid, handler);

    return true; //true로 주면 다음 컨트롤러 호출, false이면 종료
  }

  @Override
  public void postHandle(HttpServletRequest request,
                         HttpServletResponse response,
                         Object handler,
                         ModelAndView modelAndView) throws Exception {
    String uuid = request.getAttribute("uuid").toString();

    log.info("(postHandle) UUID, handler, modelAndView : [ {} ], {}, {} ", uuid, handler, modelAndView);
  }

  @Override
  public void afterCompletion(HttpServletRequest request,
                              HttpServletResponse response,
                              Object handler,
                              Exception ex) throws Exception {
    String requestUrl = request.getRequestURI();
    String uuid = request.getAttribute("uuid").toString();

    log.info("(afterComplete) requestUrl, UUID, handler : {}, [ {} ], {} ", requestUrl, uuid, handler);

    if(ex!=null) {
      log.error("(afterComplete) error! ", ex);
    }
  }

}
