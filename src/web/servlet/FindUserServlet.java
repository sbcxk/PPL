package web.servlet;

import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 通过id查找用户
 * @author PPL
 *
 */
@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取id
        String id=request.getParameter("id");
        //调用service方法
        UserService service=new UserServiceImpl();
        User user=service.findUserByid(id);

        //将user存入request
        //request.setAttribute("user",user);
        //转发到update.jsp
        //request.getRequestDispatcher("/admin/user/edit.jsp").forward(request,response);
        //3.将list放入request域中,请求转发
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        //request.getRequestDispatcher("/admin/product/list.jsp").forward(request,response);
        response.sendRedirect(request.getContextPath()+"/admin/user/edit.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
