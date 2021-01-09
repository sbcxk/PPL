package service.impl;


import dao.CategoryDao;
import dao.impl.CategoryDaoImpl;
import domain.Category;
import domain.Product;
import service.CategoryService;
import util.JsonUtil;
import java.util.List;


public class CategoryServiceImpl implements CategoryService {
    /**
     * 后台展示分类
     * @return
     */
    @Override
    public List<Category> findList() throws Exception{
        CategoryDao cd = new CategoryDaoImpl();
        List<Category> list =cd.findAll();
        return list;
    }

    /**
     * 添加分类
     * @param c
     */
    @Override
    public void save(Category c) {
        CategoryDao cd=new CategoryDaoImpl();
        cd.save(c);
    }

    @Override
    public Category findCateByCid(String cid) {
        CategoryDao cd=new CategoryDaoImpl();
        return cd.findCateByCid(cid);
    }

    @Override
    public void updateCategory(Category cg) {
        CategoryDao cd=new CategoryDaoImpl();
        cd.update(cg);
    }

    @Override
    public void deleteCategory(String cid) {
        CategoryDao cd=new CategoryDaoImpl();
        cd.delete(cid);
    }

    /**
     * 前台分类展示
     * @return
     * @throws Exception
     */
    @Override
    public String findAll() throws Exception {
        CategoryDao cd = new CategoryDaoImpl();
        List<Category> list =cd.findAll();

        if(list!=null&&list.size()>0){
            return JsonUtil.list2json(list);

        }
        return null;
    }

    /**
     * 根据cid查询商品
     * @param cid
     * @return
     */
    @Override
    public List<Product> findByCid(String cid) {
        CategoryDao cd = new CategoryDaoImpl();
        List<Product> list = cd.findByCid(cid);

        return list;
    }


}
