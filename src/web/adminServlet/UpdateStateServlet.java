package web.adminServlet;

import constant.Constant;
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
 * 更新订单状态
 * @author PPL
 *
 */
@WebServlet("/updateStateServlet")
public class UpdateStateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //1.获取oid
            String oid = request.getParameter("oid");

            //2.调用service 获取订单
            OrderService os = new OrderServiceImpl();
            Order order = os.getById(oid);

            //3.设置订单的状态,更新
            order.setState(Constant.order_yifahuo);
            os.update(order);

            //4.重定向
            response.sendRedirect(request.getContextPath()+"/findAllOrdServlet?state=1");
        } catch (Exception e) {
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
