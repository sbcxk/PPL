package web.adminServlet;

import service.CategoryService;
import service.impl.CategoryServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除分类
 * @author PPL
 *
 */
@WebServlet("/delCateServlet")
public class DelCateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取id
        String cid=request.getParameter("cid");
        //cid="\'"+cid+"\'";
        //2.调用service删除
        CategoryService cs=new CategoryServiceImpl();
        cs.deleteCategory(cid);
        System.out.println("cid"+cid);
        //2.跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/adminCategoryServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
