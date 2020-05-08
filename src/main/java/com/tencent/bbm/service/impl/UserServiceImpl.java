package com.tencent.bbm.service.impl;

import com.tencent.bbm.dao.UserMapper;
import com.tencent.bbm.entity.User;
import com.tencent.bbm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author bbm
 * 用户实现类
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    /**
     * userMapper 注入
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * redistemplate
     */
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public User addUser(User user) {
        int i = userMapper.insertSelective(user);
        log.info(String.valueOf(i));
        log.info("");
        return user;
    }

    @Override
    public void deleteUser(User user) {
        userMapper.delete(user);
        log.info("delete user success");
    }

    @Override
    public void updateUser(User user) {
       userMapper.updateByPrimaryKey(user);
        log.info("delete user success");
    }

    @Override
    public  List<User> selectUser(User user) {
        List<User> users = userMapper.select(user);
        log.info("delete user success");
        return users;
    }

    @Cacheable(value = "users")
    @Override
    public List<User> getUserByNameAndAge(String name, int age) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userName", name);
        criteria.andEqualTo("userAge", age);
        List<User> users = userMapper.selectByExample(example);
        return users;
    }

    @Override
    public User updateUserByName(User user) {
//        updateByName(user);
        userMapper.updateByPrimaryKeySelective(user);
        redisTemplate.opsForValue().set("name", user.getUserName());
        redisTemplate.opsForValue().get("name");

        return user;
    }

    /**
     * 更具用户名更新
     * @param user 用户
     */
    private void updateByName(User user) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userName", user.getUserName());
        User user1 = new User();
        user1.setUserName("test0502");
        redisTemplate.opsForValue().set("name", user.getUserName());
        int i = userMapper.updateByExample(user1, example);
        System.out.println("update i");
    }
}
