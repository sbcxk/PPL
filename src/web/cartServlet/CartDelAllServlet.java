package web.cartServlet;

import domain.Cart;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 清空购物车
 * @author PPL
 *
 */
@WebServlet("/cartDelAllServlet")
public class CartDelAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取清空购物车操作
        Cart cart=getCart(request);
        cart.cleanCart();

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
