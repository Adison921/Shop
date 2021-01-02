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
            System.out.println("�û�������!");
        } else {
            System.out.println("�û����Ѵ��ڣ�");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDao.queryUserByUsernameAndPassword("zsh666", "123456") == null) {
            System.out.println("�û�����������󣬵�¼ʧ�ܣ�");
        } else {
            System.out.println("��ѯ�ɹ���");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null,"zsh66666","123456","123456zsh@qq.com")));
    }
}