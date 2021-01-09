package web.cartServlet;

import domain.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除购物项
 * @author PPL
 *
 */
@WebServlet("/cartDeleteServlet")
public class CartDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pid=request.getParameter("pid");
        //获取购物车
        Cart cart=getCart(request);
        cart.removeFromCart(pid);
        //重定向
        response.sendRedirect(request.getContextPath()+"/cart.jsp");
    }
    private Cart getCart(HttpServletRequest request) {
        Cart cart=(Cart)request.getSession().getAttribute("cart");
        if(cart==null){
            cart=new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        return cart;

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
