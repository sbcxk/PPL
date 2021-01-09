package web.cartServlet;

import domain.Cart;
import domain.CartItem;
import domain.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 购物车模块
 * @author PPL
 *
 */
@WebServlet("/cartServlet")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取pid count
        String pid=request.getParameter("pid");
        int count=Integer.parseInt(request.getParameter("count"));
        //封装cartitem
        //调用service获取product
        ProductService ps=new ProductServiceImpl();
        Product product=ps.getById(pid);
        //创建cartitem
        CartItem cartItem=new CartItem(product,count);
        //获取购物车
        Cart cart=getCart(request);
        cart.add2Cart(cartItem);
        //重定向
        response.sendRedirect(request.getContextPath()+"/cart.jsp");
        //request.getRequestDispatcher("/cart.jsp").forward(request,response);
    }

    /**
     * 获取购物车
     * @param request
     * @return
     */
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
