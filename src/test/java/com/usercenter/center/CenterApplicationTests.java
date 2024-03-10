package com.usercenter.center;


import com.usercenter.center.models.User;
import com.usercenter.center.service.UserService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;


@SpringBootTest
class CenterApplicationTests
{
    @Resource
    private UserService userService;

    @Test
    public void addTest()
    {
        User user = new User();
        user.setUserName("fyy");
        user.setUserAccount("fyy666");

        String encryptPassword = DigestUtils.md5DigestAsHex(("fyy" + "12345678").getBytes());
        user.setUserPassword(encryptPassword);
        boolean save = userService.save(user);
        System.out.println(save);


    }

    @Test
    void contextLoads()
    {
    }

}
