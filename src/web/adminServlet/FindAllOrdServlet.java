package web.adminServlet;

import domain.Order;
import service.OrderService;
import service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 查询所有订单
 * @author PPL
 *
 */
@WebServlet("/findAllOrdServlet")
public class FindAllOrdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取state
        String state = request.getParameter("state");

        //2.调用service 获取不同的列表
        OrderService os = new OrderServiceImpl();
        List<Order> list=os.findAllByState(state);

        //3.将list放入request域中,请求转发
        HttpSession session = request.getSession();
        session.setAttribute("list",list);
        //request.getRequestDispatcher("/admin/product/list.jsp").forward(request,response);
        response.sendRedirect("/Pdd/admin/order/list.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
