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
        //获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //检查验证码是否正确
        if ("abcde".equalsIgnoreCase(code)) {
            if (userService.existsUsername(username)) {
                System.out.println("用户名[" + username + "]已存在!");

                //把回显的信息保存到request域中
                req.setAttribute("msg","用户名已存在！");
                req.setAttribute("username",username);
                req.setAttribute("email",email);

                //跳回注册界面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {

                //调用service保存到数据库
                userService.registUser(new User(null, username, password, email));
                //跳转到注册成功界面
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }

        } else {
            //把回显的信息保存到request域中
            req.setAttribute("msg","验证码错误！");
            req.setAttribute("username",username);
            req.setAttribute("email",email);

            System.out.println("验证码[" + code + "]错误");
            //跳回注册界面
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }
}
