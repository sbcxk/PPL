package service;

import domain.Admin;

public interface AdminService {
    /**
     * 管理员登录
     * @param admin
     * @return
     */
    Admin login(Admin admin);
}
