//package web.servlet;
//
//import domain.ResultInfo;
//import domain.User;
//import org.apache.commons.beanutils.BeanUtils;
//import service.UserService;
//import service.impl.UserServiceImpl;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.lang.reflect.InvocationTargetException;
//import java.util.Map;
//
//@WebServlet("/user/*")
//public class UserServlet extends BaseServlet {
//
//    public UserServlet() {
//    }
//    //声明UserService业务对象
//    private UserService service = new UserServiceImpl();
//    public void enroll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        //super.doGet(req, resp);
//        //设置编码
//        request.setCharacterEncoding("utf-8");
//        //获取验证码
//        String verifycode=request.getParameter("verifycode");
//        //3.校验验证码
//        HttpSession session=request.getSession();
//        String checkcode_server=(String)session.getAttribute("CHECKCODE_SERVER");
//        System.out.println((String)session.getAttribute("CHECKCODE_SERVER"));
//        //一次性
//        session.removeAttribute("CHECKCODE_SERVER");
//        session.removeAttribute("regist_msg");
//        if(checkcode_server==null||!checkcode_server.equalsIgnoreCase(verifycode)){
//            //验证码不正确，返回首页
//            //登陆成功，将用户存入session
//            session.setAttribute("regist_msg","验证码错误");
//            //跳转页面
//            response.sendRedirect(request.getContextPath()+"/register.jsp");
//            //提示信息
//            //req.setAttribute("regist_msg","验证码错误");
//            //跳转登录页面
//            //req.getRequestDispatcher("/register.jsp").forward(req,resp);
//            //将info序列化为json
//
////            ResultInfo info =new ResultInfo();
////            ObjectMapper mapper=new ObjectMapper();
////            String json = mapper.writeValueAsString(info);
////            info.setFlag(false);
////            info.setErrorMsg("验证码输入错误");
////            resp.setContentType("application/json;charset=utf-8");
////            resp.getWriter().write(json);
//            return;
//        }
//
//        //获取所有请求参数
//        Map<String,String[]> map=request.getParameterMap();
//        //创建user对象
//        User enrollUser =new User();
//        //使用Beanutils封装
//        try {
//            BeanUtils.populate(enrollUser,map);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//
//        //调用UserDao的login方法
//        UserService dao=new UserServiceImpl();
//        //UserDao dao=new UserDao();
//        boolean result =dao.regist(enrollUser);
//        //动态获取虚拟目录
//        String contextPath=request.getContextPath();
//        //判断user
//        System.out.println("用户名："+result);
//        ResultInfo info =new ResultInfo();
//        if(result){
//            //注册ok
//            //info.setFlag(true);
//            response.sendRedirect(contextPath+"/register_ok.jsp");
//        }else {
//            //注册失败
//            request.setAttribute("regist","用户名重复");
//
//            //info.setFlag(false);
//            //info.setErrorMsg("用户名重复，注册失败");
//            //跳转注册页面
//            request.getRequestDispatcher("/register.jsp").forward(request,response);
//            //转发
//            //req.getRequestDispatcher("/successServlet").forward(req,resp);
//        }
//        //将info序列化为json
////        ObjectMapper mapper=new ObjectMapper();
////        String json = mapper.writeValueAsString(info);
////
////        //将json数据写回客户端
////        //设置content-type
////        resp.setContentType("application/json;charset=utf-8");
////        resp.getWriter().write(json);
//    }
//
//    /**
//     * 登录功能
//     * @param request
//     * @param response
//     * @throws ServletException
//     * @throws IOException
//     */
//    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        //设置编码
//        request.setCharacterEncoding("utf-8");
//        //2.获取数据
//        //获取验证码
//        String verifycode=request.getParameter("verifycode");
//        //3.校验验证码
//        HttpSession session=request.getSession();
//        String checkcode_server=(String)session.getAttribute("CHECKCODE_SERVER");
//        //一次性
//        session.removeAttribute("CHECKCODE_SERVER");
//        if(checkcode_server==null||!checkcode_server.equalsIgnoreCase(verifycode)){
//            //验证码不正确，返回首页
//            //提示信息
//            request.setAttribute("login_msg","验证码错误");
//            //跳转登录页面
//            request.getRequestDispatcher("/login.jsp").forward(request,response);
//            return;
//        }
//
//        Map<String,String[]> map=request.getParameterMap();
//        //4.封装User对象
//        User user=new User();
//        try {
//            BeanUtils.populate(user,map);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//
//        //调用service查询
//        UserService service=new UserServiceImpl();
//        User loginUser=service.login(user);
//        //判断是否登录成功
//        if(loginUser!=null){
//
//            //登陆成功，将用户存入session
//            session.setAttribute("user",loginUser);
//            //跳转页面
//            response.sendRedirect(request.getContextPath()+"/list.jsp");
//        }else{
//            //登录失败
//            request.setAttribute("login_msg","用户名或密码错误");
//            //跳转登录
//            request.getRequestDispatcher("/login.jsp").forward(request,response);
//
//        }
//
//    }
//
//    /**
//     * 退出
//     * @param request
//     * @param response
//     * @throws ServletException
//     * @throws IOException
//     */
//    public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        //销毁session
//        request.getSession().invalidate();
//        response.sendRedirect(request.getContextPath()+"/list.jsp");
//    }
//
//    /**
//     * 激活功能
//     * @param request
//     * @param response
//     * @throws ServletException
//     * @throws IOException
//     */
//    public void active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//        //1.获取激活码
//        String code = request.getParameter("code");
//        if(code != null){
//            //2.调用service完成激活
//            UserService service = new UserServiceImpl();
//            boolean flag = service.active(code);
//
//            //3.判断标记
//            String msg = null;
//            if(flag){
//                //激活成功
//                msg = "激活成功，请<a href='login.jsp'>登录</a>";
//            }else{
//                //激活失败
//                msg = "激活失败，请联系管理员!";
//            }
//            response.setContentType("text/html;charset=utf-8");
//            response.getWriter().write(msg);
//        }
//    }
//}
