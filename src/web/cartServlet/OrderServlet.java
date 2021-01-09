package web.cartServlet;

import constant.Constant;
import domain.*;
import service.OrderService;
import service.impl.OrderServiceImpl;
import util.UuidUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

@WebServlet("/orderServlet")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //检测登录状态
        User user =(User) request.getSession().getAttribute("user");
        if(user==null){
            request.setAttribute("wdl","请先登录");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
        //获取购物车
        Cart cart=(Cart)request.getSession().getAttribute("cart");

        //封装对象
        //创建对象
        Order order=new Order();
        //设置oid
        order.setOid(UuidUtil.getUuid());
        //设置Ordertime
        order.setOrdertime(new Date());
        //设置购物车total
        order.setTotal(cart.getTotal());
        //设置state
        order.setState(Constant.order_weifukuan);
        //设置user
        order.setUser(user);
        //设置订单项表 items 并遍历购物项列表
        for(CartItem ci:cart.getCartItems()){
            //封装形成orderItem
            //创建orderitem
            OrderItem oi=new OrderItem();
            //设置itemid
            oi.setItemid(UuidUtil.getUuid());
            //从ci中获取count
            oi.setCount(ci.getCount());
            //设置subtotal
            oi.setSubtotal(ci.getSubtotal());
            //设置protect
            oi.setProduct(ci.getProduct());
            //设置order
            oi.setOrder(order);
            //将orderitem加入order的items
            order.getItems().add(oi);
        }

        //调用orderService保存
        OrderService os=new OrderServiceImpl();
        try {
            os.save(order);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        cart.cleanCart();
        //转发

//        request.setAttribute("bean",order);
//        response.sendRedirect(request.getContextPath()+"/fahuo.jsp");

        HttpSession session = request.getSession();
        session.setAttribute("bean",order);
        response.sendRedirect(request.getContextPath()+"/order.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
