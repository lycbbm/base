package com.tencent.bbm.service;

import com.tencent.bbm.entity.User;

import java.util.List;

/**
 * @author bbm
 * user
 */
public interface UserService {
    /**
     * 删除用户
     *
     * @param user 用户
     * @return 返回
     */
    User addUser(User user);

    /**
     * 删除用户根据bean
     *
     * @param user 用户
     */
    void deleteUser(User user);

    /**
     * 更新用户根据bena
     *
     * @param user 用户
     */
    void updateUser(User user);

    /**
     * 查询用户根据user
     *
     * @param user 用户
     * @return 返回用户列表
     */
    List<User> selectUser(User user);

    /**
     * 根据年龄和姓名查询用户
     *
     * @param name 姓名
     * @param age  年龄
     * @return 返回用户列表
     */
    List<User> getUserByNameAndAge(String name, int age);

    /**
     * 根据用户名更新
     * @param user 用户名
     * @return 返回修改后用户
     */
    User updateUserByName(User user);
}
