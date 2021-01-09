package dao.impl;

import dao.AdminDao;
import domain.Admin;
import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

public class AdminDaoImpl implements AdminDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Admin findAdminByUsernameAndPassword(String adminname, String adminpassword) {
        try {
            String sql = "select * from admin where adminname = ? and adminpassword = ? ";
            Admin admin = template.queryForObject(sql, new BeanPropertyRowMapper<Admin>(Admin.class), adminname, adminpassword);
            return admin;
        } catch (DataAccessException e) {
            return null;
        }
    }
}
