package web.servlet;

import service.CategoryService;
import service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 查找所有分类
 * @author PPL
 *
 */
@WebServlet("/categoryServlet")
public class CategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");

        try {
            response.setContentType("text/html;charset=utf-8");
            CategoryService service = new CategoryServiceImpl();

            //1.调用service查询所有
            CategoryService cs = new CategoryServiceImpl();
            String value = cs.findAll();

            response.getWriter().println(value);
        } catch (Exception e) {

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

//    public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        try {
//            response.setContentType("text/html;charset=utf-8");
//            CategoryService service = new CategoryServiceImpl();
//
//            //1.调用service查询所有
//            CategoryService cs = new CategoryServiceImpl();
//            String value = cs.findAll();
//
//            response.getWriter().println(value);
//        } catch (Exception e) {
//
//        }
//        return  null;
//
//    }

}
