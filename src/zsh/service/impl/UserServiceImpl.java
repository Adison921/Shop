package zsh.service.impl;

import zsh.dao.UserDao;
import zsh.dao.impl.UserDaoImpl;
import zsh.pojo.User;
import zsh.service.UserService;

/**
 * @author zsh
 * @create 2020-12-28-21:35
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if(userDao.queryUserByUsername(username)==null){
            return false;

        }else {
            return true;
        }

    }
}
