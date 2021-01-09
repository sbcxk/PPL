package web.cartServlet;

import constant.Constant;
import domain.Order;
import service.OrderService;
import service.impl.OrderServiceImpl;
import util.BeanFactory;
import util.PaymentUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

/**
 * 提交订单
 * @author PPL
 *
 */
@WebServlet("/payMoneyServlet")
public class PayMoneyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        try {
            //1.获取oid
            String address=request.getParameter("address");
            String name=request.getParameter("name");
            String telephone=request.getParameter("telephone");
            String oid=request.getParameter("oid");


            //通过id获取order
            OrderService s=new OrderServiceImpl();
            Order order = s.getById(oid);

            order.setAddress(address);
            order.setName(name);
            order.setTelephone(telephone);



            //2.调用service 获取订单
            //OrderService os = new OrderServiceImpl();
            //Order order = os.getById(oid);

            //3.设置订单的状态,更新
            order.setState(Constant.order_yifukuan);
            //os.update(order);
            //更新order
            s.update(order);
            //4.重定向
            request.setAttribute("bean",order);
            request.getRequestDispatcher("/fahuo.jsp").forward(request,response);
        } catch (Exception e) {
        }



        /*//接受参数
        String address=request.getParameter("address");
        String name=request.getParameter("name");
        String telephone=request.getParameter("telephone");
        String oid=request.getParameter("oid");


        //通过id获取order
        OrderService s=(OrderService) BeanFactory.getBean("OrderService");
        Order order = null;
        try {
            order = s.getById(oid);
        } catch (Exception e) {
            e.printStackTrace();
        }

        order.setAddress(address);
        order.setName(name);
        order.setTelephone(telephone);

        //更新order
        s.update(order);


        // 组织发送支付公司需要哪些数据
        String pd_FrpId = request.getParameter("pd_FrpId");
        String p0_Cmd = "Buy";
        String p1_MerId = ResourceBundle.getBundle("merchantInfo").getString("p1_MerId");
        String p2_Order = oid;
        String p3_Amt = "0.01";
        String p4_Cur = "CNY";
        String p5_Pid = "";
        String p6_Pcat = "";
        String p7_Pdesc = "";
        // 支付成功回调地址 ---- 第三方支付公司会访问、用户访问
        // 第三方支付可以访问网址
        String p8_Url = ResourceBundle.getBundle("merchantInfo").getString("responseURL");
        String p9_SAF = "";
        String pa_MP = "";
        String pr_NeedResponse = "1";
        // 加密hmac 需要密钥
        String keyValue = ResourceBundle.getBundle("merchantInfo").getString("keyValue");
        String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
                p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
                pd_FrpId, pr_NeedResponse, keyValue);


        //发送给第三方
        StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
        sb.append("p0_Cmd=").append(p0_Cmd).append("&");
        sb.append("p1_MerId=").append(p1_MerId).append("&");
        sb.append("p2_Order=").append(p2_Order).append("&");
        sb.append("p3_Amt=").append(p3_Amt).append("&");
        sb.append("p4_Cur=").append(p4_Cur).append("&");
        sb.append("p5_Pid=").append(p5_Pid).append("&");
        sb.append("p6_Pcat=").append(p6_Pcat).append("&");
        sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
        sb.append("p8_Url=").append(p8_Url).append("&");
        sb.append("p9_SAF=").append(p9_SAF).append("&");
        sb.append("pa_MP=").append(pa_MP).append("&");
        sb.append("pd_FrpId=").append(pd_FrpId).append("&");
        sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
        sb.append("hmac=").append(hmac);*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
