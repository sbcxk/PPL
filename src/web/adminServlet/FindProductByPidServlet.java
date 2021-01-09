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

/**
 * 通过Pid查询商品
 * @author PPL
 *
 */
@WebServlet("/findProductByPidServlet")
public class FindProductByPidServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取商品id
        String pid=request.getParameter("pid");
        ProductService ps=new ProductServiceImpl();
        Product pd=ps.getById(pid);
        HttpSession session = request.getSession();
        session.setAttribute("pd",pd);
        //request.getRequestDispatcher("/admin/product/list.jsp").forward(request,response);
        response.sendRedirect(request.getContextPath()+"/admin/product/edit.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
