package zsh.service;

import zsh.pojo.User;

/**
 * @author zsh
 * @create 2020-12-28-21:29
 */
public interface UserService {
    /**
     * 注册用户
     *
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     */
    public boolean existsUsername(String username);
}
