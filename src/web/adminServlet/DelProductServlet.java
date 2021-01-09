package web.adminServlet;

import service.ProductService;
import service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除商品
 * @author PPL
 *
 */
@WebServlet("/delProductServlet")
public class DelProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取id
        String pid=request.getParameter("pid");
        //2.调用service删除
        ProductService service =new ProductServiceImpl();
        service.deleteProduct(pid);

        //2.跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/findAllServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
