package web.servlet;

import domain.Product;
import service.ProductService;
import service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
/**
 * 主页加载
 * @author PPL
 *
 */
@WebServlet("/indexServlet")
public class indexServlet extends HttpServlet {
//    @Override
//    public String index(HttpServletRequest request, HttpServletResponse response) {
//
//            //调用product service查询
//            ProductService ps=new ProductServiceImpl();
//
//            List<Product> hotList=ps.findHot();
//            List<Product> newList=ps.findNew();
//
//            //将两个list存入request
//            request.setAttribute("hList",hotList);
//            request.setAttribute("nList",newList);
//
//
//
//        return "list.jsp";
//    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用product service查询
        ProductService ps=new ProductServiceImpl();

        List<Product> hotList=ps.findHot();
        List<Product> newList=ps.findNew();

        //将两个list存入request
        request.setAttribute("hList",hotList);
        request.setAttribute("nList",newList);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
