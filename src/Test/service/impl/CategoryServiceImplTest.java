package service.impl;

import dao.CategoryDao;
import dao.impl.CategoryDaoImpl;
import domain.Category;
import domain.Product;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class CategoryServiceImplTest extends TestCase {
    @Test
    public void testFindList() {
    }

    @Test
    public void testSave() {
    }

    @Test
    public void testFindCateByCid() {

    }

    @Test
    public void testUpdateCategory() {
    }

    @Test
    public void testDeleteCategory() {
        CategoryDao cd=new CategoryDaoImpl();
        cd.delete("1");
    }

    @Test
    public void testFindAll() throws Exception {
        CategoryDao cd = new CategoryDaoImpl();
        List<Category> list =cd.findAll();
        System.out.println(list);
    }

    @Test
    public void testFindByCid() {
        CategoryDao cd = new CategoryDaoImpl();
        List<Product> list = cd.findByCid("3");
        System.out.println(list);
    }
}