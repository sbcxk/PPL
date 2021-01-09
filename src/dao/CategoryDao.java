package dao;


import domain.Category;
import domain.Product;

import java.util.List;

public interface CategoryDao {
    List<Category> findAll() throws Exception;

    List<Product> findByCid(String cid);

    void save(Category c);

    Category findCateByCid(String cid);

    void update(Category cg);

    void delete(String cid);
    /**
     * 查询所有
     * @return
     */

}
