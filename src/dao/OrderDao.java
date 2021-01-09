package dao;

import domain.Order;
import domain.OrderItem;
import domain.PageBean;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    void save(Order order);

    void saveItem(OrderItem oi);

    int getTotalRecord(int id);

    List<Order> findMyOrderByPage(PageBean<Order> pb, int id) throws Exception;

    Order getById(String oid) throws Exception;

    void updata(Order order);

    List<Order> findAllByState(String state);

    void delete(String oid);
}
