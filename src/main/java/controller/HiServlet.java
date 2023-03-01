package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/name")
public class HiServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html;charset=utf-8");
    String name = "DingDong";
    resp.getWriter().append("Hello, "+name);
    System.out.println("do get = " + name);
  }

  @Override
  protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name = req.getParameter("name");
    System.out.println("do put = " + name); //form 양식은 get, post만 지원하므로 출력되지 않음!
  }

  @Override
  protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name = req.getParameter("name");
    System.out.println("do delete = " + name); //form 양식은 get, post만 지원하므로 출력되지 않음!
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //1. parameter을 가져온다.
    //2. request 객체의 attribute에 값을 저장한다.
    //3. dispatcher에게 값을 넘기면서 작업을 forward 한다.

    req.setCharacterEncoding("UTF-8"); //한글깨짐 방지
    String name = req.getParameter("name");
    req.setAttribute("name", name);

    System.out.println("do post = " + name);
    RequestDispatcher dispatcher = req.getRequestDispatcher("hi.jsp");
    dispatcher.forward(req, resp);


  }
}
