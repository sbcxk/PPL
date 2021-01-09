package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.PageBean;
import domain.User;
import service.UserService;
import util.MailUtils;
import util.UuidUtil;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用DAO完成查询
        return dao.findAll();
    }

    public User login(User user) {

        return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword(), "Y");
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserByid(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    @Override
    public void delSelectedUser(String[] ids) {
        if (ids != null && ids.length > 0) {
            //遍历数组
            for (String id : ids) {
                //调用dao删除
                dao.delete(Integer.parseInt(id));
            }
        }

    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {

        /*int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if (currentPage <= 0) {
            currentPage = 1;
        }

        //创建空的PageBean对象
        PageBean<User> pb = new PageBean<User>();

        //设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //调用dao查询总记录数
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);

        //调用dao查询List集合
        //计算开始索引
        int start = (currentPage - 1) * rows;
        List<User> list = dao.findByPage(start, rows,condition);
        pb.setList(list);

        //计算总页码
        int totalPage = (totalCount % rows) == 0 ? totalCount / rows : (totalCount / rows) + 1;
        pb.setTotalPage(totalPage);

        if (currentPage >=totalPage) {
            currentPage = totalPage;
        }
        return pb;*/
        return null;
    }

    @Override
    public boolean regist(User registUser) {
        //1.根据用户名查询用户对象
        User u=dao.findUsername(registUser.getUsername());
        if(u!=null){
            return false;
        }
        //设置位移激活码
        registUser.setCode(UuidUtil.getUuid());
        //设置激活状态
        registUser.setStatus("N");
        //保存用户信息
        dao.save(registUser);
        //发送激活码
        String content="<a href='http://localhost:8080/Pdd/activeUserServlet?code="+registUser.getCode()+"'>→_→点击激活【拼夕夕购物商城】</a>";
        MailUtils.sendMail(registUser.getEmail(),content,"拼夕夕注册限量激活码！");
        return true;
    }

    /**
     * 激活邮件
     * @param code
     * @return
     */
    @Override
    public boolean active(String code) {
        //根据激活码查询用户对象
        User user=dao.findByCode(code);
        if(user!=null){
            //调用dao改变激活状态
            dao.updateStatus(user);
            return true;
        }
        return false;
    }
}
