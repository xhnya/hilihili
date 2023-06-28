package com.xhn.hilihili.auth.controller;

import com.xhn.hilihili.auth.service.UserUsersService;
import com.xhn.hilihili.auth.vo.PhoneVo;
import com.xhn.hilihili.auth.vo.UserInfoVo;
import com.xhn.hilihili.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xhn
 * @email hain.xiao@outlook.com
 * @date 2023/6/12 10:57
 * @description:
 * 登录的controller
 * 手机第一次登录自动注册
 *
 *
 */
@RestController
@RequestMapping("/auth/")
public class LoginController {

    @Autowired
    UserUsersService userUsersService;



    /**
     * 手机号登录
     * 用户登录：用户通过手机号进行登录
     * 处理登录请求
     *  -- 自动注册流程
     *  保存用户信息
     *  ----返回登录凭据
     *  客户端自动登录
     *  自动登录验证
     *  后端验证身份标识
     *  客户端登录状态更新
     **/
    @PostMapping("/loginForPhone")
    public Result loginForPhone(@Validated @RequestBody PhoneVo phoneVo){
        //判断验证码是否正确

        UserInfoVo userInfo = userUsersService.loginForPhone(phoneVo);
        return Result.ok().data("userInfo",userInfo);
    }



}