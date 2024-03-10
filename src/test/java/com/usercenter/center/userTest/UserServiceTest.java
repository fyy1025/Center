package com.usercenter.center.userTest;

import com.usercenter.center.service.UserService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/*
 *@author  fyy
 *@version 1.0
 *@time    2024-03-028:58
 *@project Center
 */
@SpringBootTest
public class UserServiceTest
{
    @Resource
    private UserService userService;
    @Test
    public void userRegisterTest()
    {
        String userAccount = "123456";
        String userPassword = "123456";
        String checkPassword = "123456";
        String invitationNumber = "0";
        //1.验证三个参数是否有一个为空
        userAccount = "";
        long result = userService.userRegister(userAccount, userPassword, checkPassword,invitationNumber);
        Assertions.assertEquals(-1, result);
        //2.验证用户账号长度大于6
        userAccount = "12345";
        result = userService.userRegister(userAccount, userPassword, checkPassword,invitationNumber);
        Assertions.assertEquals(-1, result);
        //3.验证密码长度必须大于6
        userAccount = "12345";
        userPassword = "12345";
        result = userService.userRegister(userAccount, userPassword, checkPassword,invitationNumber);
        Assertions.assertEquals(-1, result);
        //4.验证是否包含特殊字符
        userAccount = "123456!@#";
        userPassword = "123456";
        result = userService.userRegister(userAccount, userPassword, checkPassword,invitationNumber);
        Assertions.assertEquals(-1, result);
        //5.验证密码和旧密码是否相等
        userAccount="123456";
        checkPassword = "123456789";
        result = userService.userRegister(userAccount, userPassword, checkPassword,invitationNumber);
        Assertions.assertEquals(-1, result);
        //6.账号不能已经存在了
        userAccount = "123456";
        checkPassword = "123456";
        result = userService.userRegister(userAccount, userPassword, checkPassword,invitationNumber);
        Assertions.assertEquals(-1, result);
        //7.正常插入！
        userAccount = "fyy";
        userPassword = "123456";
        checkPassword = "123456";
        result = userService.userRegister(userAccount, userPassword, checkPassword,invitationNumber);
        Assertions.assertEquals(-1, result);
    }
    
}
