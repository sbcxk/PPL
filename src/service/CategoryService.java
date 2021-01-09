package service;



import domain.Category;
import domain.Product;

import java.util.List;

public interface CategoryService {

    String findAll() throws Exception;

    List<Product> findByCid(String cid);

    List<Category> findList() throws Exception;

    void save(Category c);

    Category findCateByCid(String cid);

    void updateCategory(Category cg);

    /**
     * 管理员删除分类
     * @param cid
     */
    void deleteCategory(String cid);
}
