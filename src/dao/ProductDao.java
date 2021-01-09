package dao;

import domain.PageBean;
import domain.Product;

import java.util.List;

public interface ProductDao {
    /**
     * 根据id查商品
     * @param pid
     * @return
     */
    Product getById(String pid);

    /**
     * 查询火爆商品
     * @return
     */
    List<Product> findHot();

    /**
     * 查询最新商品
     * @return
     */
    List<Product> findNew();


    List<Product> findAll();

    void save(Product p);

    void update(Product pd);

    void delete(String pid);
}
