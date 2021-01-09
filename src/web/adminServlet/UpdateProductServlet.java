package web.adminServlet;

import domain.Product;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.ProductService;
import service.UserService;
import service.impl.ProductServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 更新商品信息
 * @author PPL
 *
 */
@WebServlet("/updateProductServlet")
public class UpdateProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");

        //获取参数
        Map<String,String[]> map=request.getParameterMap();

        //封装对象
        Product pd=new Product();
        try {
            BeanUtils.populate(pd,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用Service修改
        ProductService ps=new ProductServiceImpl();
        ps.updateProduct(pd);

        //跳转到查询所有 userListServlet
        //response.sendRedirect(request.getContextPath()+"/admin/user/list.jsp");
        response.sendRedirect(request.getContextPath()+"/findAllServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}