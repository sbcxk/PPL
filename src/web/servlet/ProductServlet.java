package web.servlet;


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
/**
 *查询gid对应的商品
 * @author PPL
 *
 */
@WebServlet("/productServlet")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取商品id
        String pid=request.getParameter("gid");
        ProductService ps=new ProductServiceImpl();
        Product pro=ps.getById(pid);
        request.setAttribute("pro",pro);
        request.getRequestDispatcher("/goods.jsp").forward(request,response);
        //HttpSession session = request.getSession();

        //session.setAttribute("pro",pro);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
