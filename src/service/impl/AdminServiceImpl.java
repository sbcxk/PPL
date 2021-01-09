package service.impl;


import dao.AdminDao;
import dao.impl.AdminDaoImpl;
import domain.Admin;
import org.junit.Test;
import service.AdminService;

public class AdminServiceImpl implements AdminService {
    private AdminDao dao = new AdminDaoImpl();
    @Override
    public Admin login(Admin admin) {
        return dao.findAdminByUsernameAndPassword(admin.getAdminname(), admin.getAdminpassword());
    }
}
