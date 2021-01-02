package zsh.service;

import zsh.pojo.User;

/**
 * @author zsh
 * @create 2020-12-28-21:29
 */
public interface UserService {
    /**
     * ע���û�
     *
     * @param user
     */
    public void registUser(User user);

    /**
     * ��¼
     */
    public User login(User user);

    /**
     * ����û����Ƿ����
     */
    public boolean existsUsername(String username);
}
