package zsh.test;

import org.junit.Test;
import zsh.pojo.User;
import zsh.service.UserService;
import zsh.service.impl.UserServiceImpl;

import static org.junit.Assert.*;

/**
 * @author zsh
 * @create 2020-12-28-21:47
 */
public class UserServiceTest {
    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null, "bbj168", "123456", "bbj168@qq.com"));
        userService.registUser(new User(null, "bbj169", "123456", "bbj169@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "bbj168", "123456", null)));
    }

    @Test
    public void existsUsername() {
        if(userService.existsUsername("zsh666")){
            System.out.println("用户名已存在！");

        }else{
            System.out.println("该用户名可用！");
        }
    }
}