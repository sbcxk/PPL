package web.adminServlet;

import domain.Category;
import service.CategoryService;
import service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
/**
 * 查询商品分类
 * @author PPL
 *
 */
@WebServlet("/addPUIServlet")
public class AddPUIServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service获取所有分类
        CategoryService cs=new CategoryServiceImpl();
        List<Category> list= null;
        try {
            list = cs.findList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //重定向
        HttpSession session = request.getSession();
        session.setAttribute("list",list);
        response.sendRedirect("/Pdd/admin/product/add.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
