package service;

import domain.PageBean;
import domain.Product;

import java.util.List;

public interface ProductService {
    Product getById(String pid);

    List<Product> findHot();

    List<Product> findNew();

    List<Product> findAll();

    void save(Product p) ;

    void updateProduct(Product pd);

    void deleteProduct(String pid);
}
