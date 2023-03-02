package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/array")
public class ArrayServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //1. parameter을 가져온다.
    String[] array = {"jack", "lucy", "tom", "jerry", "lily"};
    System.out.println("do get = "+array);

    //2. request 객체의 attribute에 값을 저장한다.
    req.setAttribute("array", array);

    //3. dispatcher에게 값을 넘기면서 작업을 forward 한다.
    req.getRequestDispatcher("/array.jsp").forward(req, resp);
  }
}
