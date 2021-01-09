package web.adminServlet;

import domain.Order;
import domain.OrderItem;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import service.OrderService;
import service.impl.OrderServiceImpl;
import util.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 展示订单详情
 * @author PPL
 *
 */
@WebServlet("/showDetailServlet")
public class ShowDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //0.设置编码
            response.setContentType("text/html;charset=utf-8");

            //1.获取oid
            String oid = request.getParameter("oid");

            //2.调用service 获取订单
            OrderService os = new OrderServiceImpl();
            Order order = os.getById(oid);

            //3.获取订单的订单项列表 转成json 写回浏览器
            if(order != null){
                List<OrderItem> list = order.getItems();
                if(list != null && list.size()>0){
                    //扩展：出去累赘数据
                    JsonConfig config = JsonUtil.configJson(new String[]{"order","pdate","pdesc","itemid"});
                    response.getWriter().println(JSONArray.fromObject(list, config));
                }
            }

        } catch (Exception e) {

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
