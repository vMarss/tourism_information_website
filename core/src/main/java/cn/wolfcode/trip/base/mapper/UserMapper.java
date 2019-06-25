package cn.wolfcode.trip.base.mapper;

import cn.wolfcode.trip.base.domain.User;
import cn.wolfcode.trip.base.query.QueryObject;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    List<User> selectAll();

    //用来实现分页查询
    List<User> selectForList(QueryObject qo);

    int updateByPrimaryKey(User record);

    @Select({"select * from user where id = #{id}"})
    User selectById(Long id);

    @Select({"select * from user where email = #{email}"})
    User selectByEmail(User user);

    @Select({"select * from user where email = #{email} and password = #{password}"})
    User selectByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}