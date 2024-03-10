package com.usercenter.center.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.usercenter.center.common.ErrorCode;
import com.usercenter.center.common.ResultUtils;
import com.usercenter.center.common.baseRespond;
import com.usercenter.center.contant.UserConstant;
import com.usercenter.center.exception.BusinessException;
import com.usercenter.center.models.User;
import com.usercenter.center.models.request.UserLogInRequest;
import com.usercenter.center.models.request.UserRegisterRequest;
import com.usercenter.center.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 *@author  fyy
 *@version 1.0
 *@time    2024-02-2811:34
 *@project Center
 */
@RequestMapping("user")
@RestController
public class UserController
{
    @Resource
    private UserService userService;

    @PostMapping("/register")
    public baseRespond<Long> userRegister(@RequestBody UserRegisterRequest userRegisterRequest)
    {
        if (userRegisterRequest == null)
        {
            //return ResultUtils.fail(ErrorCode.PARAMS_ERROR);
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        String invitationNumber = userRegisterRequest.getPlanetCode();
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword, invitationNumber))
        {
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"注册信息为空");
        }
        Long result = userService.userRegister(userAccount, userPassword, checkPassword, invitationNumber);
        //return l;

        return ResultUtils.success(result);
    }


    @PostMapping("/login")
    public baseRespond<User> userLogin(@RequestBody UserLogInRequest userLoginRequest, HttpServletRequest request)
    {
        if (userLoginRequest == null)
        {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String userAccount = userLoginRequest.getUserAccount();
        String userPassword = userLoginRequest.getUserPassword();

        if (StringUtils.isAnyBlank(userAccount, userPassword))
        {
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"注册信息为空");
        }
        User user = userService.userLogIn(userAccount, userPassword, request);

        return ResultUtils.success(user);
    }

    /**
     * 获取当前用户
     *
     * @param request
     * @return
     */
    @GetMapping("/current")
    public baseRespond<User> getCurrentUser(HttpServletRequest request) {
        Object userObj = request.getSession().getAttribute(UserConstant.USER_LOGIN_STATE);
        User currentUser = (User) userObj;
        if (currentUser == null) {
            throw new BusinessException(ErrorCode.NOT_LOGIN);
        }
        long userId = currentUser.getId();
        // TODO 校验用户是否合法
        User user = userService.getById(userId);
        User safetyUser = userService.getSafetyUser(user);
        return ResultUtils.success(safetyUser);
    }

    @PostMapping("/logout")
    public baseRespond<Integer> userLogOut(HttpServletRequest request)
    {
        if (request == null)
        {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return ResultUtils.success(userService.userLogOut(request));

    }

    //@GetMapping("/{userName}")
    @GetMapping("/search")
    public baseRespond<List<User>> queryUserById(String username, HttpServletRequest request)
    {
        if (StringUtils.isAnyBlank(username) || request == null)
        {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        List<User> users = userService.queryUserById(username, request);
        if(users.isEmpty())
        {
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }
        return ResultUtils.success(users);
    }

    //@DeleteMapping("/{userId}")
    @PostMapping("/delete")
    public baseRespond<Boolean> deleteUserById(@RequestBody long id, HttpServletRequest request)
    {
        if (id <= 0 || request == null)
        {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        boolean b = userService.deleteUserById(id, request);
        return ResultUtils.success(b);
    }

}
