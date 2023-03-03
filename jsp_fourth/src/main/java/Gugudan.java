import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/gugudan")
public class Gugudan extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html; charset=UTF-8"); //한글깨짐 방지

    int dan = Integer.parseInt(req.getParameter("dan"));
    int limit = 9;
    req.setAttribute("dan", dan);
    req.setAttribute("limit", limit);

    RequestDispatcher dispatcher = req.getRequestDispatcher("/gugudan.jsp");
    dispatcher.forward(req, resp);

//    int dan = 0;
//    try {
//      dan =Integer.parseInt(req.getParameter("dan"));
//      String gugudan = dan + "단을 출력합니다.";
//      String gugudan2 = dan + " X 1 " + (dan*1);
//
//      resp.getWriter().append("<body><h2>" + gugudan + "</h2>" + gugudan2 + "</body>");
//
//    } catch (NumberFormatException e) {
//      resp.getWriter().append("입력 값이 없습니다.");
//    }


//    System.out.println(req.getMethod());
//    System.out.println(req.getRequestURL());
//    System.out.println(req.getRequestURI());
//    System.out.println(req.getParameter("dan"));
//    System.out.println(req.getRemoteAddr());
  }
}
