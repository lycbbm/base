package com.tencent.bbm.controller;


import com.tencent.bbm.entity.User;
import com.tencent.bbm.service.UserService;
import com.tencent.bbm.service.annotaion.MyAnnotation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author bbm
 * 永辉
 */
@RestController
@RequestMapping("/msg")
@Api(tags = "用户管理")
@Slf4j
public class UserController {

    /**
     * userService
     */
    @Autowired
    private UserService userService;


    /**
     *
     * @param user 用户
     */
    @PostMapping("/addUser")
    @MyAnnotation
    @ApiOperation(value = "新增用户")
    public void addUser(@RequestBody User user) {
        log.info(user.toString());
        userService.addUser(user);
    }

    /**
     *
     * @param user 用户
     */
    @PostMapping("/delUser")
    @ApiOperation(value = "删除用户")
    public void delUser(@RequestBody User user) {
        log.info("del user begin " + user.toString());
        userService.deleteUser(user);

    }

    /**
     *
     * @param userName 名字
     */
    @ApiOperation(value = "根据用户名删除")
    @ApiImplicitParam(name = "name", value = "bbm", required = true)
    @PostMapping("/delUserByName")
    public void delUser(@RequestParam(name = "name") String userName) {
        log.info("del user begin " + userName);
        User user = new User();
        user.setUserName(userName);
        userService.deleteUser(user);
    }

    /**
     *
     * @param name 名字
     * @param age  年龄
     * @return 用户列表
     */
    @GetMapping("/getUser/{name}/{age}")
    @ApiOperation(value = "根据名字查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String", example = "bbm"),
            @ApiImplicitParam(name = "age", value = "年龄", required = true, dataType = "int", example = "18")
    })
    public List<User> getUser(@PathVariable String name, @PathVariable int age) {

        log.info("name" + name + ",age" + age);
        User user = new User();
        user.setUserName(name);
        user.setUserAge(age);
        return userService.selectUser(user);
    }


    /**
     *
     * @param name 名字
     * @param age  年龄
     * @return 用户列表
     */
    @GetMapping("/getUserByExam/{name}/{age}")
    @ApiOperation(value = "根据名字查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String", example = "bbm"),
            @ApiImplicitParam(name = "age", value = "年龄", required = true, dataType = "int", example = "18")
    })
    public List<User> getUserByEXample(@PathVariable String name, @PathVariable int age) {

        log.info("getUserByEXample name" + name + ",age" + age);
        List<User> users = userService.getUserByNameAndAge(name, age);
        return userService.getUserByNameAndAge(name, age);
    }


    /**
     * 根据用户名更新用户
     * @param user 用户
     * @return 更新的用户
     */

    @ApiOperation(value = "根据名字查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", required = true, dataType = "String", example = "bbm")
    })
    @PostMapping("/updateUser")
    @CachePut
    public User updateUserByName(@RequestBody User user) {
        log.info("updateUserByName name" + user.getUserName());
        return userService.updateUserByName(user);
    }
}
