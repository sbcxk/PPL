package web.servlet;

import domain.ResultInfo;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;
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
 * 注册
 * @author PPL
 *
 */
@WebServlet("/enrollServlet")
public class EnrollServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
        //设置编码
        req.setCharacterEncoding("utf-8");
        //获取验证码
        String verifycode=req.getParameter("verifycode");
        //3.校验验证码
        HttpSession session=req.getSession();
        String checkcode_server=(String)session.getAttribute("CHECKCODE_SERVER");
        System.out.println((String)session.getAttribute("CHECKCODE_SERVER"));
        //一次性
        session.removeAttribute("CHECKCODE_SERVER");
        session.removeAttribute("regist_msg");
        if(checkcode_server==null||!checkcode_server.equalsIgnoreCase(verifycode)){
            //验证码不正确，返回首页
            //登陆成功，将用户存入session
            session.setAttribute("regist_msg","验证码错误");
            //跳转页面
            resp.sendRedirect(req.getContextPath()+"/register.jsp");
            //提示信息
            //req.setAttribute("regist_msg","验证码错误");
            //跳转登录页面
            //req.getRequestDispatcher("/register.jsp").forward(req,resp);
            //将info序列化为json

//            ResultInfo info =new ResultInfo();
//            ObjectMapper mapper=new ObjectMapper();
//            String json = mapper.writeValueAsString(info);
//            info.setFlag(false);
//            info.setErrorMsg("验证码输入错误");
//            resp.setContentType("application/json;charset=utf-8");
//            resp.getWriter().write(json);
            return;
        }

        //获取所有请求参数
        Map<String,String[]> map=req.getParameterMap();
        //创建user对象
        User enrollUser =new User();
        //使用Beanutils封装
        try {
            BeanUtils.populate(enrollUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用UserDao的login方法
        UserService dao=new UserServiceImpl();
        //UserDao dao=new UserDao();
        boolean result =dao.regist(enrollUser);
        //动态获取虚拟目录
        String contextPath=req.getContextPath();
        //判断user
        System.out.println("用户名："+result);
        ResultInfo info =new ResultInfo();
        if(result){
            //注册ok
            //info.setFlag(true);
            resp.sendRedirect(contextPath+"/register_ok.jsp");
        }else {
            //注册失败
            req.setAttribute("regist","用户名重复");

            //info.setFlag(false);
            //info.setErrorMsg("用户名重复，注册失败");
            //跳转注册页面
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
            //转发
            //req.getRequestDispatcher("/successServlet").forward(req,resp);
        }
        //将info序列化为json
//        ObjectMapper mapper=new ObjectMapper();
//        String json = mapper.writeValueAsString(info);
//
//        //将json数据写回客户端
//        //设置content-type
//        resp.setContentType("application/json;charset=utf-8");
//        resp.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        this.doPost(req, resp);
    }
}
