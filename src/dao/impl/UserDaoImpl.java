package dao.impl;

import dao.UserDao;
import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        //使用JDBC操作数据库
        //定义sql
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }


    public User findUserByUsernameAndPassword(String username, String password,String status) {
        try {
            String sql = "select * from user where username = ? and password = ? and status = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password,status);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public void add(User user) {
        //定义sql
        String sql = "insert into user(username,password,email) values(?,?,?)";
        //执行sql
        template.update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }

    @Override
    public void delete(int id) {
        //定义sql
        String sql = "delete from user where id = ?";
        //执行sql
        template.update(sql, id);
    }

    @Override
    public User findById(int id) {
        String sql = "select * from user where id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
    }

    @Override
    public void update(User user) {
        String sql = "update user set username = ? , password = ? , email = ? , status = ? where id = ?";
        template.update(sql, user.getUsername(), user.getPassword(),  user.getEmail(), user.getStatus(),user.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //定义初始化模板
        String sql = "select count(*) from user where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        //遍历map
        Set<String> keySet = condition.keySet();
        //定义参数集合
        List<Object> params=new ArrayList<Object>();
        for (String key : keySet) {
            if("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                sb.append(" and " + key + " like ? ");
                params.add("%"+value+"%");//?条件的值
            }
        }

        return template.queryForObject(sb.toString(), Integer.class,params.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from user where 1 = 1 ";

        StringBuilder sb = new StringBuilder(sql);
        //遍历map
        Set<String> keySet = condition.keySet();
        //定义参数集合
        List<Object> params=new ArrayList<Object>();
        for (String key : keySet) {
            if("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                sb.append(" and " + key + " like ? ");
                params.add("%"+value+"%");//?条件的值
            }
        }
        //添加分页
        sb.append(" limit ? , ? ");
        //添加分页查询参数
        params.add(start);
        params.add(rows);

        sql=sb.toString();
        return template.query(sql, new BeanPropertyRowMapper<User>(User.class),params.toArray());
    }

    @Override
    public void save(User registUser) {
        String sql="insert into user(username,password,email,status,code) values(?,?,?,?,?)";
        int result=template.update(sql,registUser.getUsername(), registUser.getPassword(),
                registUser.getEmail(),registUser.getStatus(),registUser.getCode()
        );
    }


    @Override
    public User findUsername(String username) {
        User user = null;
        try {
            //查询用户名
            String sql="select * from user where username = ?";
            user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username);
        } catch (DataAccessException e) {

        }

        return user;
    }

    @Override
    public User findByCode(String code) {
        User user = null;
        try {
            String sql="select * from user where code = ? ";
            user=template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),code);
        } catch (DataAccessException e) {

        }

        return user;
    }

    @Override
    public void updateStatus(User user) {
        String sql=" update user set status = 'Y' where id = ? ";
        template.update(sql,user.getId());
    }


}
