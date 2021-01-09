package web.cartServlet;

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
 * 订单发货
 * @author PPL
 *
 */
@WebServlet("/deliverServlet")
public class DeliverServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        try {
            //1.获取oid
            String oid = request.getParameter("oid");

            //2.调用service 获取订单
            OrderService os = new OrderServiceImpl();
            Order order = os.getById(oid);

            //3.设置订单的状态,更新
            order.setState(Constant.order_yifahuo);
            os.update(order);

            //4.转发
            //request.setAttribute("bean",order);
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        } catch (Exception e) {
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
