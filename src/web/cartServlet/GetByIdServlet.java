package web.cartServlet;

import domain.Order;
import service.OrderService;
import service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 通过Oid查找订单
 * @author PPL
 *
 */
@WebServlet("/getByIdServlet")
public class GetByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取oid
        String oid=request.getParameter("oid");
        //调用service查询
        OrderService os=new OrderServiceImpl();
        Order order= null;
        try {
            order = os.getById(oid);
        } catch (Exception e) {

        }
        //请求转发
        request.setAttribute("bean",order);
        request.getRequestDispatcher("/order.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
