package web.adminServlet;

import domain.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 查询所有商品
 * @author PPL
 *
 */
@WebServlet("/findAllServlet")
public class FindAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用service 查询以上架商品
        ProductService ps = new ProductServiceImpl();
        List<Product> list = ps.findAll();

        //2.将返回值放入request中,请求转发
        HttpSession session = request.getSession();
        session.setAttribute("list",list);
        //request.getRequestDispatcher("/admin/product/list.jsp").forward(request,response);
        response.sendRedirect("/Pdd/admin/product/list.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
