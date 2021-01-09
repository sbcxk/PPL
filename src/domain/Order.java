package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    //订单编号
    private String oid;
    //下单时间
    private Date ordertime;
    //总额
    private double total;
    //订单装状态 0未付款 1已付款 2已发货 3已签收完成
    private Integer state;
    //收货地址
    private String address;
    //收件人
    private String name;
    //联系方式
    private String telephone;
    //订单归属
    private User user;
    //当前订单包含的订单项
    private List<OrderItem> items=new ArrayList<>();

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
