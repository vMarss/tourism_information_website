package cn.wolfcode.trip.app.web.controller;

import cn.wolfcode.trip.app.util.JSONResult;
import cn.wolfcode.trip.base.domain.User;
import cn.wolfcode.trip.base.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping
    public JSONResult register(User user) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setSuccess(true);
        try {
            userService.saveOrUpdate(user);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult.setSuccess(false);
            jsonResult.setErrorMsg(e.getMessage());
        }
        return jsonResult;
    }

    @PutMapping("/{id}")
    public JSONResult update(User user) {
        JSONResult jsonResult = new JSONResult();
        jsonResult.setSuccess(true);
        try {
            userService.saveOrUpdate(user);
            jsonResult.setObject(user);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult.setSuccess(false);
            jsonResult.setErrorMsg(e.getMessage());
        }


        return jsonResult;
    }

}
