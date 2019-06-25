package cn.wolfcode.trip.base.service.impl;

import cn.wolfcode.trip.base.domain.User;
import cn.wolfcode.trip.base.mapper.UserMapper;
import cn.wolfcode.trip.base.query.QueryObject;
import cn.wolfcode.trip.base.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public void saveOrUpdate(User user) {
        //有id为更新,没有为保存
        if (user.getId() != null) {
            mapper.updateByPrimaryKey(user);
        } else {
            System.out.println(user);
            User userTmp = mapper.selectByEmail(user);
            if (userTmp != null) {
                throw new RuntimeException("账户已存在！");
            }
            mapper.insert(user);
        }
    }

    @Override
    public void delete(Long id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public User getById(Long id) {
        return mapper.selectById(id);
    }

    @Override
    public List<User> listAll() {
        return mapper.selectAll();
    }

    @Override
    public User login(String email, String password) {
        //调用dao查询是否匹配
        User tmpUser = mapper.selectByEmailAndPassword(email, password);
        if (tmpUser == null) {
            throw new RuntimeException("账号or密码错误!");
        }
        return tmpUser;
    }

    @Override
    public PageInfo query(QueryObject qo) {
        //设置开始的分页
        //会拼接后面的!!第一个!!查询
        PageHelper.startPage(qo.getCurrentPage(), qo.getPageSize());

        //调用dao
        List<User> users = mapper.selectForList(qo);

        return new PageInfo(users);
    }
}
