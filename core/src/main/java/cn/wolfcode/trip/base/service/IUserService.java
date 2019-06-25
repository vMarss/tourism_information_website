package cn.wolfcode.trip.base.service;

/*
用户的业务接口
 */

import cn.wolfcode.trip.base.domain.User;
import cn.wolfcode.trip.base.query.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IUserService {

    void saveOrUpdate(User user);

    void delete(Long id);

    User getById(Long id);

    List<User> listAll();

    User login(String email, String password);

    PageInfo query(QueryObject qo);
}
