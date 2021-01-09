package web.adminServlet;

import domain.Category;
import domain.User;
import service.CategoryService;
import service.UserService;
import service.impl.CategoryServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 通过Cid查询分类
 * @author PPL
 *
 */
@WebServlet("/findCateServlet")
public class FindCateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取cid
        String cid=request.getParameter("cid");
        //调用service方法
        CategoryService cs=new CategoryServiceImpl();
        Category category =cs.findCateByCid(cid);
        //3.将list放入request域中,请求转发
        HttpSession session = request.getSession();
        session.setAttribute("cate",category);
        //request.getRequestDispatcher("/admin/product/list.jsp").forward(request,response);
        response.sendRedirect(request.getContextPath()+"/admin/category/edit.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
