package com.example.third;

import com.example.third.filter.LogFilter;
import com.example.third.filter.LoginCheckFilter;
import com.example.third.interceptor.LogInterceptor;
import com.example.third.interceptor.LoginCheckInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.processing.Filer;
import javax.servlet.Filter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new LogInterceptor())
        .order(1)
        .addPathPatterns("/**") //하위 모든 path 에 대해 전부 적용
        .excludePathPatterns("/css/**", "/", "/favicon.ico", "error"); //단 2개의 path를 제외

    registry.addInterceptor(new LoginCheckInterceptor())
        .order(2)
        .addPathPatterns("/**")
        .excludePathPatterns("/", "/login", "/members/join", "/logout", "/css/**", "/favicon.ico", "/error"); //화이트리스트 + favicon, error
  }


  //@Bean //filter 미사용
  public FilterRegistrationBean LogFilter() { //필터들간의 순서 등록, 적용패턴
    FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
    filterFilterRegistrationBean.setFilter(new LogFilter());
    filterFilterRegistrationBean.setOrder(1);
    filterFilterRegistrationBean.addUrlPatterns("/*"); //모든 요청이 들어오는 URI에 대해서 다 적용함
    return filterFilterRegistrationBean;
  }

  //@Bean //filter 미사용
  public FilterRegistrationBean LoginCheckFilter() { //필터들 간의 순서등록, 적용 패턴
    FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
    filterFilterRegistrationBean.setFilter(new LoginCheckFilter());
    filterFilterRegistrationBean.setOrder(2);
    filterFilterRegistrationBean.addUrlPatterns("/*"); //모든 요청이 들어오는 URI에 대해서 다 적용함
    return filterFilterRegistrationBean;
  }
}
