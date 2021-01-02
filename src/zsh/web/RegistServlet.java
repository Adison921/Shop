package zsh.web;

import zsh.pojo.User;
import zsh.service.UserService;
import zsh.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zsh
 * @create 2020-12-28-23:22
 */
public class RegistServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //��ȡ����Ĳ���
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //�����֤���Ƿ���ȷ
        if ("abcde".equalsIgnoreCase(code)) {
            if (userService.existsUsername(username)) {
                System.out.println("�û���[" + username + "]�Ѵ���!");

                //�ѻ��Ե���Ϣ���浽request����
                req.setAttribute("msg","�û����Ѵ��ڣ�");
                req.setAttribute("username",username);
                req.setAttribute("email",email);

                //����ע�����
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {

                //����service���浽���ݿ�
                userService.registUser(new User(null, username, password, email));
                //��ת��ע��ɹ�����
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }

        } else {
            //�ѻ��Ե���Ϣ���浽request����
            req.setAttribute("msg","��֤�����");
            req.setAttribute("username",username);
            req.setAttribute("email",email);

            System.out.println("��֤��[" + code + "]����");
            //����ע�����
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }
}
