package web.adminServlet;

import domain.Category;
import service.CategoryService;
import service.impl.CategoryServiceImpl;
import util.BeanFactory;
import util.UuidUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 添加分类
 * @author PPL
 *
 */
@WebServlet("/addUIServlet")
public class AddUIServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //分装
        Category c = new Category();
        c.setCid(UuidUtil.getUuid());
        c.setCname(request.getParameter("cname"));

        //2.调用service完成添加操作
        CategoryService cs = new CategoryServiceImpl();
        cs.save(c);

        //3.重定向
        response.sendRedirect(request.getContextPath()+"/adminCategoryServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
