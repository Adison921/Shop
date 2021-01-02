package zsh.dao;

import zsh.pojo.User;

/**
 * @author zsh
 * @create 2020-12-28-17:31
 */
public interface UserDao {

    public User queryUserByUsername(String username);

    public User queryUserByUsernameAndPassword(String username,String password);

    public int saveUser(User user);
}
