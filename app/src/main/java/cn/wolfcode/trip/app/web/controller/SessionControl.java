package cn.wolfcode.trip.app.web.controller;

import cn.wolfcode.trip.app.util.JSONResult;
import cn.wolfcode.trip.base.domain.User;
import cn.wolfcode.trip.base.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/sessions")
public class SessionControl {

    @Autowired
    private IUserService userService;

    @PostMapping
    public JSONResult login(String email, String password, HttpSession session) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setSuccess(true);
        try {
            //调用service层查询是否匹配
            User tmpUser = userService.login(email, password);

            //将对象保存到封装类中
            jsonResult.setObject(tmpUser);

            //存到session中
            session.setAttribute("USER_IN_SESSION", tmpUser);

        } catch (Exception e) {
            //接收到异常，说明登录失败
            e.printStackTrace();
            jsonResult.setSuccess(false);
            jsonResult.setErrorMsg(e.getMessage());
        }

        return jsonResult;
    }

}
