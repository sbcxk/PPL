package dao;

import domain.Admin;

public interface AdminDao {
    Admin findAdminByUsernameAndPassword(String adminname, String adminpassword);
}
