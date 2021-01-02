package zsh.test;

import java.lang.reflect.Method;

/**
 * @author zsh
 * @create 2021-01-02-11:39
 */
public class UserServletTest {
    public void login() {
        System.out.println("����login()����������");
    }

    public void regist() {
        System.out.println("����regist()����������");
    }

    public void updateUser() {
        System.out.println("����updateUser()����������");
    }

    public void updateUserPassword() {
        System.out.println("����updateUserPassword()����������");
    }


    public static void main(String[] args) {
        String action = "regist";

        try {
            // ��ȡactionҵ������ַ�������ȡ��Ӧ��ҵ�� �����������
            Method method = UserServletTest.class.getDeclaredMethod(action);

//            System.out.println(method);
            // ����Ŀ��ҵ�� ����
            method.invoke(new UserServletTest());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    }
