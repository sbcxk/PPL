package web.adminServlet;

import service.OrderService;;
import service.impl.OrderServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除订单
 * @author PPL
 *
 */
@WebServlet("/delOrderServlet")
public class DelOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //1.获取id
        String oid=request.getParameter("oid");
        //2.调用service删除
        //String oid="\'"+id+"\'";
        System.out.println(oid);
        OrderService service =new OrderServiceImpl();
        service.deleteOrder(oid);

        //2.跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/findAllOrdServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
