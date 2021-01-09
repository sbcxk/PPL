package dao.impl;


import dao.CategoryDao;
import domain.Category;
import domain.Product;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Category> findAll() throws Exception {
        String sql="select * from category ";
        //return qr.query(sql, new BeanListHandler<>(Category.class));
        List<Category> categorys = template.query(sql, new BeanPropertyRowMapper<>(Category.class));
        return categorys;
    }

    @Override
    public List<Product> findByCid(String cid) {
        String sql = "select * from goods where cid="+cid;

        List<Product> bc = template.query(sql, new BeanPropertyRowMapper<Product>(Product.class));

        return bc;
    }

    @Override
    public void save(Category c) {
        String sql = "insert into category(cid,cname) values(?,?)";
        template.update(sql, c.getCid(),c.getCname());
    }

    @Override
    public Category findCateByCid(String cid) {
        String sql = "select * from category where cid = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Category>(Category.class), cid);
    }

    @Override
    public void update(Category cg) {
        String sql = "update category set cname = ? where cid = ?";
        template.update(sql, cg.getCname(), cg.getCid());
    }

    @Override
    public void delete(String cid) {
        //定义sql
        String sql = " delete from category where cid = ? ";
        //执行sql
        template.update(sql, cid);
    }
}
