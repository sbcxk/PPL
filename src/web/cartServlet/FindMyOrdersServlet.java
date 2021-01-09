package web.cartServlet;

import com.sun.org.apache.xpath.internal.operations.Or;
import domain.Order;
import domain.PageBean;
import domain.User;
import service.OrderService;
import service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * 查找我的订单
 * @author PPL
 *
 */
@WebServlet("/findMyOrdersServlet")
public class FindMyOrdersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取pageNumber
        int pageNumber=Integer.parseInt(request.getParameter("pageNumber"));
        int pageSize=3;
        //检测登录状态
        User user =(User) request.getSession().getAttribute("user");
        if(user==null){
            request.setAttribute("wdl","请先登录");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
        //调用service查询所有数据
        OrderService os=new OrderServiceImpl();
        PageBean<Order> bean= null;
        try {
            assert user != null;
            bean = os.findMyOrders(pageNumber,pageSize,user.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }


        //转发
        request.setAttribute("pb",bean);
        request.getRequestDispatcher("/order_list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
