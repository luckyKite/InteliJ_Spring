package controller;

import data.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // /member에 접속하면 사용자 정보(id)를 list에 추가
    String id = req.getParameter("id");
    String name = req.getParameter("name");
    String password1 = req.getParameter("password1");
    String password2 = req.getParameter("password2");

    if( !password1.equals("") && password1.equals(password2) ) {
      //동적 배열 활용
      ArrayList<Member> members = new ArrayList<>();

      members.add(new Member("1", "aaa", "aaa"));
      members.add(new Member("2", "bbb", "bbb"));
      members.add(new Member("3", "ccc", "ccc"));

      Member member = new Member(id, name, password1);
      members.add(member);

      req.setAttribute("member", member);
      req.getRequestDispatcher("member.jsp").forward(req, resp);
    } else {
      req.setAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
      req.getRequestDispatcher("memberJoin.jsp").forward(req, resp);
    }
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Member member = new Member("1", "aaa", "1234");
    req.setAttribute("member", member);
    req.getRequestDispatcher("member.jsp").forward(req, resp);
  }
}
