package zsh.test;

import org.junit.Test;
import zsh.dao.UserDao;
import zsh.dao.impl.UserDaoImpl;
import zsh.pojo.User;

import static org.junit.Assert.*;

/**
 * @author zsh
 * @create 2020-12-28-20:58
 */
public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {

        if (userDao.queryUserByUsername("admin") == null) {
            System.out.println("用户名可用!");
        } else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDao.queryUserByUsernameAndPassword("zsh666", "123456") == null) {
            System.out.println("用户名或密码错误，登录失败！");
        } else {
            System.out.println("查询成功！");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null,"zsh66666","123456","123456zsh@qq.com")));
    }
}