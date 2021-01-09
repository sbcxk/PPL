package service;

import domain.PageBean;
import domain.User;

import java.util.List;
import java.util.Map;

/*用户管理的业务接口*/
public interface UserService {
    /*
    *查询所有用户信息
    *@return
    * */
    List<User> findAll();

    /**
     * 登录方法
     * @param user
     * @return
     */
    User login(User user);

    /**
     *保存user
     * @param user
     */
    void addUser(User user);

    /**
     *根据id删除user
     * @param id
     */
    void deleteUser(String id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    User findUserByid(String id);

    /**
     * 修改用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 批量删除用户
     * @param ids
     */
    void delSelectedUser(String[] ids);

    /**
     * 分页/条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);

    /**
     * 注册
     * @param registUser
     * @return
     */
    boolean regist(User registUser);

    boolean active(String code);

}
