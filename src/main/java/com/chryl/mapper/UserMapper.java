package com.chryl.mapper;

import com.chryl.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Chryl on 2019/10/26.
 */
public interface UserMapper {

    List<User> queryUsers();

    User selectByPrimaryKey(@Param("id") String id);

    int insertUser(@Param("user") User user);

    int deleteByPrimaryKey(@Param("id") String id);

    int updateUser(@Param("user") User user);

    int deleteUserListByIds(@Param("userIds") List<String> ids);

}
