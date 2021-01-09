package service;

import domain.Order;
import domain.PageBean;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface OrderService {
    void save(Order order) throws SQLException;

    PageBean<Order> findMyOrders(int pageNumber, int pageSize, int id) throws Exception;

    Order getById(String oid) throws Exception;

    void update(Order order);

    List<Order> findAllByState(String state);

    void deleteOrder(String oid);
}
