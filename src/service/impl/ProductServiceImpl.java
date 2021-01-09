package service.impl;

import dao.ProductDao;
import dao.impl.ProductDaoImpl;
import domain.PageBean;
import domain.Product;
import service.ProductService;
import web.servlet.ProductServlet;

import java.util.List;


public class ProductServiceImpl implements ProductService {
    @Override
    public Product getById(String pid) {
        ProductDao pd=new ProductDaoImpl();
        return pd.getById(pid);
    }

    @Override
    public List<Product> findHot() {
        ProductDao pd=new ProductDaoImpl();
        return pd.findHot();
    }

    @Override
    public List<Product> findNew() {
        ProductDao pd=new ProductDaoImpl();
        return pd.findNew();
    }

    @Override
    public List<Product> findAll() {
        ProductDao pd=new ProductDaoImpl();
        return pd.findAll();
    }

    /**
     * 保存商品
     * @param p
     */
    @Override
    public void save(Product p) {
        ProductDao pd=new ProductDaoImpl();
        pd.save(p);
    }

    @Override
    public void updateProduct(Product pd) {
        ProductDao pDao=new ProductDaoImpl();
        pDao.update(pd);
    }

    @Override
    public void deleteProduct(String pid) {
        ProductDao pDao=new ProductDaoImpl();
        pDao.delete(pid);
    }


}
