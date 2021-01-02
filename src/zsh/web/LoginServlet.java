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
 * @create 2020-12-30-1:15
 */
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //��ȡ�������
        String username = req.getParameter("username");
        String password = req.getParameter("password");


        //����userService.Login()��¼����ҵ��
        User loginUser = userService.login(new User(null, username, password, null));

        if(loginUser == null){
            //�Ѵ�����Ϣ�ͻ��Ա�����Ϣ�����浽Request����
            req.setAttribute("msg","�û������������");
            req.setAttribute("username",username);

            //���ص�¼ҳ��
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }
}
