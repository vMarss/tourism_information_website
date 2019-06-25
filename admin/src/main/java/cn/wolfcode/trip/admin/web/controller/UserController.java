package cn.wolfcode.trip.admin.web.controller;

import cn.wolfcode.trip.base.domain.User;
import cn.wolfcode.trip.base.query.QueryObject;
import cn.wolfcode.trip.base.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 供我们内部员工访问
 */


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService service;

    @RequestMapping("/list")
    public String list(Model model, QueryObject qo) {//Model用来共享数据的
        /**
         * List<User> users = service.listAll();
         *         //将查到的对象放到页面,利用Model来共享数据
         *         model.addAttribute("list", users);
         */
        System.out.println(qo);
        //实现分页
        model.addAttribute("pageInfo", service.query(qo));

        return "user/list";
    }

}
