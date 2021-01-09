package dao;

import domain.User;

import java.util.List;
import java.util.Map;

/*用户操作的Dao*/
public interface UserDao {

    List<User> findAll();

    User findUserByUsernameAndPassword(String username, String password,String status);

    void add(User user);

    void delete(int i);

    User findById(int id);

    void update(User user);

    /**
     * 查询总记录数
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询每页jilu
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);

    /**
     * 注册保存功能
     * @param registUser
     */
    void save(User registUser);

    /**
     * 根据用户名查询信息
     * @param username
     * @return
     */
    public User findUsername(String username);

    User findByCode(String code);

    void updateStatus(User user);
}
