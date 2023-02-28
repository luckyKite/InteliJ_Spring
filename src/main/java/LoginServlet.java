import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html;charset=utf-8");
    List<String> members = new ArrayList<>();
    members.add("admin");
    boolean isLogin = false;

    String id = req.getParameter("id");
    Iterator<String> iterator = members.iterator();

    while (iterator.hasNext()) {
      if (iterator.next().equals(id)) {
        isLogin = true;
        break;
      }
    }

    if (isLogin) {
      resp.getWriter().append("login success");
    } else {
      resp.getWriter().append("login failed! Check id and password");
    }
  }
}
