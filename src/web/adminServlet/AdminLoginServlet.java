package web.adminServlet;

import domain.Admin;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.AdminService;
import service.UserService;
import service.impl.AdminServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 管理员登录
 * @author PPL
 *
 */
@WebServlet("/adminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");

        Map<String,String[]> map=request.getParameterMap();

        //4.封装admin对象
        Admin admin=new Admin();
        try {
            BeanUtils.populate(admin,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用service查询
        try {
            AdminService service=new AdminServiceImpl();
            Admin loginAdmin=service.login(admin);
            //判断是否登录成功
            if(loginAdmin!=null){
                HttpSession session=request.getSession();
                //登陆成功，将用户存入session
                session.setAttribute("admin",loginAdmin);
                //跳转页面
                response.sendRedirect(request.getContextPath()+"/admin/home.jsp");
            }else{
                //登录失败
                //request.setAttribute("admin_msg","用户名或密码错误");
                //跳转登录
                //request.getRequestDispatcher("/admin/admin.jsp").forward(request,response);
                //重定向
                HttpSession session = request.getSession();
                session.setAttribute("admin_msg","用户名或密码错误");
                response.sendRedirect(request.getContextPath()+"/admin/admin.jsp");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
