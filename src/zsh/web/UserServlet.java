package zsh.web;

import zsh.pojo.User;
import zsh.service.UserService;
import zsh.service.impl.UserServiceImpl;
import zsh.test.UserServletTest;
import zsh.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author zsh
 * @create 2021-01-01-16:31
 */
public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    /**
     * �����¼�Ĺ���
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //  1����ȡ����Ĳ���
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // ���� userService.login()��¼����ҵ��
        User loginUser = userService.login(new User(null, username, password, null));
        // �������null,˵����¼ ʧ��!
        if (loginUser == null) {
            // �Ѵ�����Ϣ���ͻ��Եı�����Ϣ�����浽Request����
            req.setAttribute("msg", "�û����������");
            req.setAttribute("username", username);
            //   ���ص�¼ҳ��
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            // ��¼ �ɹ�
            //�����ɹ�ҳ��login_success.html
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }

    }

    /**
     * ����ע��Ĺ���
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //  1����ȡ����Ĳ���
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

//        2����� ��֤���Ƿ���ȷ  === д��,Ҫ����֤��Ϊ:abcde
        if ("abcde".equalsIgnoreCase(code)) {
//        3����� �û����Ƿ����
            if (userService.existsUsername(username)) {
                System.out.println("�û���[" + username + "]�Ѵ���!");

                // �ѻ�����Ϣ�����浽Request����
                req.setAttribute("msg", "�û����Ѵ��ڣ���");
                req.setAttribute("username", username);
                req.setAttribute("email", email);

//        ����ע��ҳ��
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                //      ����
//                ����Sservice���浽���ݿ�
                userService.registUser(new User(null, username, password, email));
//
//        ����ע��ɹ�ҳ�� regist_success.jsp
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            // �ѻ�����Ϣ�����浽Request����
            req.setAttribute("msg", "��֤����󣡣�");
            req.setAttribute("username", username);
            req.setAttribute("email", email);

            System.out.println("��֤��[" + code + "]����");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }

    }


}