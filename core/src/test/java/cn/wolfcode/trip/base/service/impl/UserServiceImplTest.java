package cn.wolfcode.trip.base.service.impl;

import cn.wolfcode.trip.base.domain.User;
import cn.wolfcode.trip.base.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

//将测试类也交给Spring管理
@RunWith(SpringJUnit4ClassRunner.class)
//创建Spring要加载配置文件
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceImplTest {

    @Autowired
    private IUserService iUserService;

    @Test
    public void saveOrUpdate() {
        User user = new User();
        user.setId(42L);
        user.setNickName("陈小姐");
//        user.setEmail("email");
//        user.setPassword("password");
        iUserService.saveOrUpdate(user);
    }

    @Test
    public void delete() {
    }

    @Test
    public void getById() {
        User user = iUserService.getById(1L);
        System.out.println(user);
    }

    @Test
    public void listAll() {
        List<User> listUser = iUserService.listAll();
        for (User user : listUser) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelectByEmail() {
    }
}